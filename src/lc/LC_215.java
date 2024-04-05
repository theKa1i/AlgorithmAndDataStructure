package lc;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC_215 {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length < 1) return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k) queue.add(nums[i]);
            else {
                if (queue.peek() < nums[i]){
                    queue.poll();
                    queue.add(nums[i]);
                }
            }
        }
        return queue.peek();
    }
}
