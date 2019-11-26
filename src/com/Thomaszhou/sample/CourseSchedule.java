package com.Thomaszhou.sample;

import java.util.ArrayList;
import java.util.List;

/*
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Course[] courses = new Course[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses[i] = new Course();
        }
        for (int[] prereq: prerequisites){
            courses[prereq[0]].add(courses[prereq[1]]);
        }
        for (Course c: courses){
            if (isCycle(c)) return false;
        }
        return true;
    }

    private boolean isCycle(Course c){
        if (c.tested == true) return false;
        if (c.visited == true) return true;
        c.visited = true;
        for (Course pre: c.pre){
            if (isCycle(pre)) return true;
        }
        c.tested = true;
        return false;
    }

    class Course {
        boolean visited = false;
        boolean tested = false;
        List<Course> pre = new ArrayList<>();

        public void add(Course c){
            pre.add(c);
        }
    }
}
