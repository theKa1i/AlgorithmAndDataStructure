package sort;

public class HeapSort {
    public static void heapSort(int[] arr){
        if (arr == null || arr.length <2){
            return;
        }

        int heap_size = arr.length;
        for (int i = 0; i < heap_size; i++) {
            heapInsert(arr, i);
        }

        swap(arr, 0, --heap_size);
        while(heap_size > 0){
            heapify(arr, heap_size, 0);
            swap(arr, 0, --heap_size);
        }
    }

    public static void heapInsert(int[] arr, int a){
        while (arr[a] > arr[(a - 1) / 2]){
            swap(arr, a, (a - 1) / 2);
            a = (a - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int heap_size, int a){
        int left = 2 * a + 1;
        while(left < heap_size){
            int largest = left + 1 < heap_size && arr[left] < arr[left + 1]  ? left + 1 : left;

            largest = arr[largest] > arr[a] ? largest : a;

            if (largest == a) break;

            swap(arr, a, largest);
            a = largest;
            left = 2 * a + 1;
        }
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
