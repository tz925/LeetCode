package com.Thomaszhou.sample.Design;
/*
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.


Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3)
findMedian() -> 2


Follow up:

If all integer numbers from the stream are between 0 and 100, how would you optimize it?
If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 */

/*
solution 1, every time need median, sort then output. O(nlogn)
 */

/*
solution 2, keep array sorted, every time add number, binary search(logn) for index to add, then swift array back(n)
when asked for median, output nums[size/2] O(1).
 */

/*
solution 3, keep two heaps(priorityQueue), high(min-heap) and low(max-heap), each keeps half of the numbers,
every time add a num, push to low, than push low.top to high, this makes sure the low always has the smaller numbers,
then if high.size > low.size, low.push(high.top) this makes sure that low.size always equal to high.size or high.size+1.
the how operation takes O(logn) then getting median is O(1)
 */

import java.util.PriorityQueue;

class MedianFinder {
    private PriorityQueue<Integer> low, high;
    /** initialize your data structure here. */
    public MedianFinder() {
        //max heap
        low = new PriorityQueue<>((o1, o2) -> o2 - o1);
        //min heap
        high = new PriorityQueue<>((o1, o2) -> o1 - o2);
    }

    public void addNum(int num) {
        low.offer(num);
        high.offer(low.poll());

        if (high.size() > low.size()){
            low.offer(high.poll());
        }
    }

    public double findMedian() {
        if (high.size() == low.size()) return ((high.peek()+ low.peek()) * 0.5);
        else return (double) low.peek();
    }
}

/*
solution 4, self balancing Binary Search Tree (AVL Tree), then the median will always be at root. except use pointers to
track median value in case of even number of size.
 */

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */