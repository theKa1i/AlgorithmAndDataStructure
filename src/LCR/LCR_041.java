package LCR;

import java.util.LinkedList;
import java.util.Queue;

public class LCR_041 {
}

class MovingAverage {
    public int size;
    public int window_sum = 0;
    public int[] queue;
    public int ptr = 0;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new int[size];
    }

    public double next(int val) {
        if (size < queue.length){
            window_sum += val;
            queue[ptr++ % queue.length] = val;
            size++;
        } else {
            int del = queue[ptr % queue.length];
            window_sum = window_sum - del + val;
            queue[ptr++ % queue.length] = val;
        }
        return (double)window_sum / size;
    }
}
