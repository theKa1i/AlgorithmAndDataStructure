package LCR;

import java.util.PriorityQueue;

public class LCR_059 {
}

class KthLargest {
    public PriorityQueue<Integer> heap;
    public int k;
    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            if (heap.size() < k) heap.add(num);
            else {
                if (num > heap.peek()) {
                    heap.poll();
                    heap.add(num);
                }
            }
        }
    }

    public int add(int val) {
        if (heap.size() < k) {
            heap.add(val);
            return heap.peek();
        }
        if (val > heap.peek()) {
            heap.poll();
            heap.add(val);
        }
        return heap.peek();
    }
}