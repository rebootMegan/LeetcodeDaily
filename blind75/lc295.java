package blind75;

import java.util.Collections;
import java.util.PriorityQueue;

public class lc295 {
    class MedianFinder {
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;
        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        }

        public void addNum(int num) {
            maxHeap.add(num);
            minHeap.add(maxHeap.remove());
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.remove());
            }
        }

        public double findMedian() {
            return maxHeap.size() == minHeap.size() ? (maxHeap.peek() + minHeap.peek()) / 2.0 : maxHeap.peek();
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

}
