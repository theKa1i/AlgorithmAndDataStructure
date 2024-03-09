package sort;

public class MergeSort {
    public static void mergeSort(int[] arr){
        if (arr == null || arr.length <2){
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int left, int right){
        if (left == right){
            return;
        }
        int mid = left + ((right - left) >> 1);
        process(arr, left, mid);
        process(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int middle, int right){
        int[] temp = new int[right - left + 1];
        int pt = 0, p1 = left, p2 = middle + 1;
        while (p1 <= middle && p2 <= right){
                temp[pt++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= middle){
            temp[pt++] = arr[p1++];
        }

        while (p2 <= right){
            temp[pt++] = arr[p2++];
        }

        for (int i = 0; i < temp.length; i++){
            arr[left + i] = temp[i];
        }
    }
}
