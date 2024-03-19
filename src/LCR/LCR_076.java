package LCR;

import java.util.Arrays;

public class LCR_076 {
    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }


    public void quickSort(int[] arr, int l, int r){
        if (arr.length < 1) return;
        if (l < r){
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    public int[] partition(int[] arr, int l, int r){
        int head = l - 1, tail = r;
        while (l < tail){
            if (arr[l] < arr[r]){
                swap(arr, l++, ++head);
            } else if (arr[l] == arr[r]) l++;
            else {
                swap(arr, --tail, l);
            }
        }
        swap(arr, tail, r);
        return new int[]{head + 1, tail};
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
