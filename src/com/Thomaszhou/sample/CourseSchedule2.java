package com.Thomaszhou.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
             course 0. So the correct course order is [0,1] .
Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
 */
public class CourseSchedule2 {
    static int UNSEEN = 1;
    static int SEEING = 2;
    static int FINISHED = 3;

    Map<Integer, Integer> color;
    Map<Integer, List<Integer>> neighborMap;
    List<Integer> resultOrder;
    boolean isPossible;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        init(numCourses);

        // create Neighbor map for courses.
        for (int i = 0; i < prerequisites.length; i++){
            int after = prerequisites[i][0];
            int pre = prerequisites[i][1];
            List<Integer> list = neighborMap.getOrDefault(pre, new ArrayList<>());
            list.add(after);
            neighborMap.put(pre, list);
        }

        // for each node if node is not seen, dfs it.
        for (int i = 0; i < numCourses; i++) {
            if (color.get(i) == UNSEEN) dfs(i);
        }

        int[] order;
        if (isPossible) {
            order = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                order[i] = resultOrder.get(numCourses - i -1);
            }
        }else{
            order = new int[0];
        }

        return order;

    }

    private void dfs(int node) {
        if (!isPossible) return;

        color.put(node, SEEING);

        // Traverse on neighbor nodes
        for (Integer neighbor: neighborMap.getOrDefault(node, new ArrayList<>())){
            if (color.get(neighbor) == UNSEEN) dfs(neighbor);
            // we come back to a seeing node means cycle
            else if (color.get(neighbor) == SEEING) isPossible = false;
        }

        color.put(node, FINISHED);
        resultOrder.add(node);
    }

    private void init(int numCourses){
        isPossible = true;
        color = new HashMap<>();
        neighborMap = new HashMap<>();
        resultOrder = new ArrayList<>();

        // set all to UNSEEN.
        for (int i = 0; i< numCourses; i++){
            color.put(i, UNSEEN);
        }
    }
}
