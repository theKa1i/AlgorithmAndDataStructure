package LCR;

import java.util.*;

public class LCR_035 {
    public static int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int res = Integer.MAX_VALUE;
        int first = toNum(timePoints.getFirst());
        int pre = first;
        for (int i = 1; i < timePoints.size(); i++){
            int min = toNum(timePoints.get(i));
            res = Math.min(res, min - pre);
            pre = min;
        }
        res = Math.min(res, first + 24*60 - pre);
        return res;
    }


    public static int toNum(String o1) {
        int hour1 = (o1.charAt(0) - '0') * 10 + (o1.charAt(1) - '0');
        int minute1 = (o1.charAt(3) - '0') * 10 + (o1.charAt(4) - '0');
        int time1 = hour1 * 60 + minute1;
        return time1;
    }

    public static void main(String[] args) {
        findMinDifference(new ArrayList<>(Arrays.asList(new String[]{"23:59","00:00"})));
    }

}
