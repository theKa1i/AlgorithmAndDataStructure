package sort;

public class SelectionSort {
    public static void selectionSort(int[] arr){
        if (arr == null || arr.length < 2)
            return;

        for (int i = 0; i < arr.length - 1; i++){
            int min_index = i;
            for (int j = i+1; j < arr.length; j++){
                min_index = arr[j] < arr[min_index] ? j : min_index;

            }
            swap(arr, i, min_index);
        }
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
