package LCR;

import java.util.Arrays;

public class LCR_073 {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int start = 1, end = piles[piles.length - 1], k = end;
        while (start < end) {
            int speed = start + ((end - start) >> 1);
            long t = getTime(piles, speed);
            if (t <= h){
                k = speed;
                end = speed;
            } else {
                start = speed + 1;
            }
        }
        return k;
    }

    public long getTime(int[] piles, int speed){
        long time = 0;
        for (int p : piles){
            int cur = (p + speed - 1) / speed;
            time += cur;
        }
        return time;
    }
}
