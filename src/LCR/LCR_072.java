package LCR;

public class LCR_072 {
    public int mySqrt(int x) {
        int start = 0, end = x,mid = 0;
        int res = 0;
        while (start <= end){
            mid = (end + start) >> 1;
            if ((long)mid * mid > x){
                end = mid - 1;
            } else {
                start = mid + 1;
                res = mid;
            }
        }
        return res;
    }
}
