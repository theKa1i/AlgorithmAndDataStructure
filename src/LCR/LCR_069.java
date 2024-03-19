package LCR;

public class LCR_069 {
    public int peakIndexInMountainArray(int[] arr) {
        int max = -1, index = -1;
        int start = 0, end = arr.length - 1;
        int mid = start + ((end - start) >> 1);
        int prex = -1;
        while (start < end){
            if (arr[mid] > max){
                max = arr[mid];
                index = mid;
            }
            if (arr[mid] > arr[mid - 1]) start = mid;
            else end = mid;
            prex = mid;
            mid = start + ((end - start) >> 1);
            if (prex == mid) break;;
        }
        return index;
    }
}
