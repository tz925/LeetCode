package com.Thomaszhou.sample.TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any other server directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some server unable to reach some other server.

Return all critical connections in the network in any order.



Example 1:



Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.


Constraints:

1 <= n <= 10^5
n-1 <= connections.length <= 10^5
connections[i][0] != connections[i][1]
There are no repeated connections.
 */
public class CriticalConnectionsInANetwork {
    private int id = 0;
    private int[] idArray;
    private int[] low;
    //    private boolean[] visited;  // not neccessary b/c we can check this by idArray[node] == 0 -> not visited
    private List<Integer>[] graph;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
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

        List<List<Integer>> bridges = new ArrayList<>();
        // finds all bridges in the graph across various connected components
        // even we start with a graph that has multiple parts we can still run this.
        for (int i = 0; i < n; i++) {
            if (idArray[i] == 0){
                dfs(i, -1, bridges);
            }
        }

        return bridges;
    }

    public void dfs(int at, int parent, List<List<Integer>> bridges){
        // perform DFS to find bridges.
        // at = current node, parent = previous node.

//        visited[at] = true;
        id = id + 1;
        low[at] = idArray[at] = id;

        for (Integer to: graph[at]) {
            if (to == parent) continue;
//            if (!visited[to]){
            if (idArray[to] == 0){
                dfs(to, at, bridges);
                // 后面的已经处理完了 low[to]设置好了
                low[at] = Math.min(low[at], low[to]);
                if (low[to] > idArray[at]) {
                    List<Integer> bridge = new ArrayList<>();
                    bridge.add(at);bridge.add(to);
                    bridges.add(bridge);
                }
            } else{
                // 这时等于进入了CYCLE回到了之前的node to轮DFS还没有设置low[to] 所以要用id[to]来设置low[at]
                low[at] = Math.min(idArray[to], low[at]); // in case we have seen the to node, update at's low with possible lower id of to.
            }
        }

    }
}
