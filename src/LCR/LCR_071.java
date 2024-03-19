package LCR;

import java.util.Random;

public class LCR_071 {

}
class Solution {
    public int[] prefix;
    public Solution(int[] w) {
        prefix = new int[w.length];
        prefix[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefix[i] = w[i] + prefix[i - 1];
        }
    }

    public int pickIndex() {
        Random r = new Random();
        int rand = r.nextInt(prefix[prefix.length - 1]) + 1;
        int start = 0, end = prefix.length - 1, mid = (start + end) / 2;
        while (start < end) {
            if (rand > prefix[mid]){
                start = mid + 1;
            } else end = mid;
            mid = start + ((end - start) >> 1);
        }

        return end;
    }
}