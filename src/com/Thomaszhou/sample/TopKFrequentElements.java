package com.Thomaszhou.sample;

import java.util.*;

public class TopKFrequentElements {
    /*
    Runtime: 11 ms, faster than 87.49% of Java online submissions for Top K Frequent Elements.
Memory Usage: 40.7 MB, less than 61.21% of Java online submissions for Top K Frequent Elements.
    time(n) space(n)
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (count.containsKey(nums[i]))
                count.put(nums[i], count.get(nums[i])+1);
            else count.put(nums[i], 1);
        }

        Map<Integer, List<Integer>> frequency = new HashMap<>();

        Iterator<Map.Entry<Integer, Integer>> iter =  count.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<Integer, Integer> entry = iter.next();
            if (frequency.containsKey(entry.getValue()))
                frequency.get(entry.getValue()).add(entry.getKey());
            else {
                List<Integer> list = new ArrayList<>();
                list.add(entry.getKey());
                frequency.put(entry.getValue(), list);
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = nums.length; i > 0; i--) {
            if (answer.size() >= k) break;
            if (frequency.containsKey(i)) {
                answer.addAll(frequency.get(i));
            }
        }

        return answer;
    }

    /*LeetCode's solution using Heap.
    but this method is slower than my method
    Runtime: 47 ms, faster than 18.11% of Java online submissions for Top K Frequent Elements.
Memory Usage: 40.5 MB, less than 68.10% of Java online submissions for Top K Frequent Elements.
Time complexity : \mathcal{O}(N \log(k))O(Nlog(k)). The complexity of Counter method is
 \mathcal{O}(N)O(N). To build a heap and output list takes \mathcal{O}(N \log(k))O(Nlog(k)).
 Hence the overall complexity of the algorithm is \mathcal{O}(N + N \log(k)) =
 \mathcal{O}(N \log(k))O(N+Nlog(k))=O(Nlog(k)).

Space complexity : \mathcal{O}(N)O(N) to store the hash map.



    public List<Integer> topKFrequent(int[] nums, int k) {
        // build hash map : character and how often it appears
        HashMap<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

        // keep k top frequent elements in the heap
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // build output list
        List<Integer> top_k = new LinkedList();
        while (!heap.isEmpty())
            top_k.add(heap.poll());
        Collections.reverse(top_k);
        return top_k;
    }

     */

}
