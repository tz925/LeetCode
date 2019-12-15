package com.Thomaszhou.sample.Others;

import java.util.*;

/*

Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.



Example:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.


Note:

The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        // Best way is to perform the highest requested task whenever we can to reduce future CD time
        // O(time * 26log26) space O(1)
//        int[] map = new int[26];
//        for (char c: tasks)
//            map[c - 'A']++;
//        Arrays.sort(map); // now tasks ordered ascending, [0,0,0,1,3,7]
//        int time = 0;
//        while (map[25] > 0) {
//            int i = 0;
//            while (i <= n) {
//                if (map[25] == 0)
//                    break;
//                if (i < 26 && map[25 - i] > 0)
//                    map[25 - i]--;
//                time++;
//                i++;
//            }
//            Arrays.sort(map); // resorting array to make sure we still dealing with the most exisiting task.
//        }
//        return time;

        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        PriorityQueue< Integer > queue = new PriorityQueue < > (26, Collections.reverseOrder());
        for (int f: map) {
            if (f > 0)
                queue.add(f);
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int i = 0;
            List< Integer > temp = new ArrayList< >();
            while (i <= n) {
                if (!queue.isEmpty()) {
                    if (queue.peek() > 1)
                        temp.add(queue.poll() - 1);
                    else
                        queue.poll();
                }
                time++;
                if (queue.isEmpty() && temp.size() == 0)
                    break;
                i++;
            }
            for (int l: temp)
                queue.add(l);
        }
        return time;

    }
}
