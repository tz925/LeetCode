package com.Thomaszhou.sample.ArrayAndStrings;

import java.util.*;

/*
A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a
 distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo
 (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).

Buildings Skyline Contour
The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are
the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed
 that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles
 grounded on an absolutely flat surface at height 0.

For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10],
 [19 24 8] ] .

The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ]
that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last
key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has
zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.

For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

Notes:

The number of buildings in any input list is guaranteed to be in the range [0, 10000].
The input list is already sorted in ascending order by the left x position Li.
The output list must be sorted by the x position.
There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5],
[7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output
 as such: [...[2 3], [4 5], [12 7], ...]
 */
public class CitySkyline {
    /*
    my idea.
    since input array already sorted by left x position, we process input int[][] in order.

    use a max heap to keep active building heights, that is , when we encounter left edge of a building, add it to the
     heap. when we encounter right edge of a buidling, remove its height from heap. this way, at any interested position,
     the max heap is the current skyline height. if the current skyline height is different from previous skyline height,
     we add (current interested position, current skyline height) to answer list.
     if the heap is empty when asked for max height, it means we dont have any building going on, return 0 as height.
     */
    public static void main(String[] args) {
        int[][] buildings = new int[5][3];
        buildings[0] = new int[]{2,9,10};
        buildings[1] = new int[]{3,7,15};
        buildings[2] = new int[]{5,12,12};
        buildings[3] = new int[]{15,20,10};
        buildings[4] = new int[]{19,24,8};
        CitySkyline c = new CitySkyline();
        List<List<Integer>> result = c.getSkyline(buildings);
        System.out.println(result);
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<Integer> activeBuildingHeights = new PriorityQueue<>((o1, o2) -> o2 - o1);
        // activeBuildingHeights.add(10);
        // activeBuildingHeights.add(15);
        // activeBuildingHeights.add(12);
        // activeBuildingHeights.add(10);
        // activeBuildingHeights.add(10);
        // System.out.println(activeBuildingHeights.toString());
        Map<Integer, List<Integer>> leftEdgeMap = new HashMap<>();
        Map<Integer, List<Integer>> rightEdgeMap = new HashMap<>();
        // Treeset is a sorted set
        Set<Integer> interestedPosition = new TreeSet<>(Comparator.comparingInt(o -> o));
        List<List<Integer>> result = new ArrayList<>();

        for (int[] building: buildings) {

            List<Integer> left = leftEdgeMap.getOrDefault(building[0], new ArrayList<>());
            left.add(building[2]);
            leftEdgeMap.put(building[0], left);

            List<Integer> right = rightEdgeMap.getOrDefault(building[1], new ArrayList<>());
            right.add(building[2]);
            rightEdgeMap.put(building[1], right);

            interestedPosition.add(building[0]);
            interestedPosition.add(building[1]);
        }
        int previousSkyline = 0;

        for (int curPos: interestedPosition) {

            for (int height: leftEdgeMap.getOrDefault(curPos, new ArrayList<>())) {
                activeBuildingHeights.add(height);
            }
            // System.out.println(activeBuildingHeights.toString());
            for (int height: rightEdgeMap.getOrDefault(curPos, new ArrayList<>())) {
                activeBuildingHeights.remove(height);
            }
            // System.out.println(activeBuildingHeights.toString());


            int currentSkyline = activeBuildingHeights.isEmpty()? 0 : activeBuildingHeights.peek();

            if (currentSkyline != previousSkyline){
                previousSkyline = currentSkyline;
                List<Integer> oneAns = new ArrayList<>();
                oneAns.add(curPos); oneAns.add(currentSkyline);
                result.add(oneAns);
            }
        }

        return result;
    }
}
