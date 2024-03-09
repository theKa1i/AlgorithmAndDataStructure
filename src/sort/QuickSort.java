package sort;

public class QuickSort {
    public static void quickSort(int[] arr){
        if (arr == null || arr.length <2){
            return;
        }
        quickSort(arr, 0, arr.length-1);
    }
    public static void quickSort(int[] arr, int left, int right){
        if (left < right){
            int[] p = partition(arr, left, right);
            quickSort(arr, left, p[0] - 1);
            quickSort(arr, p[1] + 1, right);
        }
    }

    public static int[] partition(int[] arr, int left, int right){
        int p1 = left - 1, p2 = right;
        while (left < p2){
            if (arr[left] < arr[right]){
                swap(arr, left++, ++p1);
            } else if (arr[left] == arr[right]){
                left++;
            } else {
                swap(arr, left, --p2);
            }
        }
        swap(arr, right, p2);
        return new int[]{p1 + 1, p2};
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
