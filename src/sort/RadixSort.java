package sort;

public class RadixSort {
    public static void radixSort(int[] arr){
        if (arr == null || arr.length <2){
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    public static int maxbits(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            max = Math.max(max, j);
        }
        int res = 0;
        while(max != 0){
            res++;
            max /= 10;
        }
        return res;
    }

    public static void radixSort(int[] arr, int left, int right, int digit){
        final int radix = 10;
        int i = 0, j = 0;
        int[] temp = new int[right - left + 1];
        for(int d = 1; d <= digit; d++){
            int[] count = new int[radix];
            for (i = left; i <= right; i++){
                j = arr[i] / ((int)Math.pow(radix, d - 1)) % radix;
                count[j]++;
            }
            for (i = 1; i < radix; i++){
                count[i] = count[i - 1] + count[i];
            }
            for (i = right; i >= left; i--){
                j = arr[i] / ((int)Math.pow(radix, d - 1)) % radix;
                temp[count[j] - 1] = arr[i];
                count[j]--;
            }
        }
    }
}
