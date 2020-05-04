package com.Thomaszhou.sample.ArrayAndStrings;

import java.util.ArrayList;
import java.util.List;

/*
You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Input: [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
 */
public class SmallerAfterSelf {
    /*
    solution 1, modified merge sort.
    Intuition: we need to see that at when merging, the count of number being move from right into result array is
    associated with the next number from left array. eg.g
    when we put a right array number into result, rightcount++
    when we put a left array number into result, count[index of this number] += rightcount
     */
    int[] count ;
    public List<Integer> countSmaller(int[] nums) {
        count = new int[nums.length];
        int[] indexes = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexes[i] = i;
        }
        // what being sort is actually the indexes array, based on value (nums[index])
        mergeSort(nums, indexes, 0, nums.length);

        // copy result
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            answer.add(count[i]);
        }

        return answer;
    }

    private void mergeSort(int[] nums, int[] indexes, int start, int end){
        if (end == start + 1 || end == start) return;
        int mid = start + (end - start) / 2;

        mergeSort(nums, indexes, start, mid);
        mergeSort(nums, indexes, mid, end);

        merge(nums, indexes, start, end);
    }

    private void merge(int[] nums, int[] indexes, int start, int end){
        int mid = start + (end - start) / 2;
        int left = start, right = mid, countIndex = 0, right2leftCount = 0;
        int[] newIndexes = new int[end - start];

        while(left < mid && right < end){
            if (nums[indexes[left]] <= nums[indexes[right]]){
                newIndexes[countIndex++] = indexes[left];
                count[indexes[left++]] += right2leftCount;
            }else{
                right2leftCount++;
                newIndexes[countIndex++] = indexes[right++];
            }
        }

        while(left < mid) {
            newIndexes[countIndex++] = indexes[left];
            count[indexes[left++]] += right2leftCount;
        }
        while(right < end){
            newIndexes[countIndex++] = indexes[right++];
        }

        for (int i = start; i < end; i++) {
            indexes[i] = newIndexes[i-start];
        }

    }
}
