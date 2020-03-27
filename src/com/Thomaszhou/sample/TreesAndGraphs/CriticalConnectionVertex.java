package com.Thomaszhou.sample.TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

/*
same as critical connection in a network. but look for articulation point.
 */
public class CriticalConnectionVertex {
    private int id = 0;
    private int[] idArray;
    private int[] low;
    private int outEdgeCount = 0;
    //    private boolean[] visited;  // not neccessary b/c we can check this by idArray[node] == 0 -> not visited
    private List<Integer>[] graph;
    List<Integer> artVertexs;

    public List<Integer> articulationVertex(int n, List<List<Integer>> connections) {
        // try remove each connection and try to move through graph, if less than n
        // nodes reached, then the removed connection is critical, add to answer.
        // result in O(V * (V+E)) too slow

        //Tarjan DFS, with distance array and low-link array.
        idArray = new int[n];
        low = new int[n];
//        visited = new boolean[n]; // not neccessary b/c we can check this by idArray[node] == 0 -> not visited
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        connections.forEach(conn -> {
            int from = conn.get(0), to = conn.get(1);
            graph[from].add(to);
            graph[to].add(from);
        });

//        List<List<Integer>> bridges = new ArrayList<>();
        artVertexs = new ArrayList<>();
        // finds all bridges in the graph across various connected components
        // even we start with a graph that has multiple parts we can still run this.
        for (int i = 0; i < n; i++) {
            if (idArray[i] == 0){
                outEdgeCount = 0; // reset Edge count, this is for jedge whether the root is art vertex.
                dfs(i, i, -1);
                if (outEdgeCount > 1) artVertexs.add(i);
            }
        }

        return artVertexs;
    }

    public void dfs(int root, int at, int parent){
        // perform DFS to find bridges.
        // at = current node, parent = previous node.

//        visited[at] = true;
        if (parent == root) outEdgeCount++;
        id = id + 1;
        low[at] = idArray[at] = id;

        for (Integer to: graph[at]) {
            if (to == parent) continue;
//            if (!visited[to]){
            if (idArray[to] == 0){
                dfs(root, to, at);
                // 后面的已经处理完了 low[to]设置好了
                low[at] = Math.min(low[at], low[to]);

                // articulation point found via bridge
                if (idArray[at] < low[to]) artVertexs.add(at);
                // articulation point found via cycle
                if (idArray[at] == low[to]) artVertexs.add(at);
            } else{
                // 这时等于进入了CYCLE回到了之前的node to轮DFS还没有设置low[to] 所以要用id[to]来设置low[at]
                low[at] = Math.min(idArray[to], low[at]); // in case we have seen the to node, update at's low with possible lower id of to.
            }
        }

    }
}
