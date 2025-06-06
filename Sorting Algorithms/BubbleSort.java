
public class BubbleSort {

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            boolean isSwap = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isSwap = true;
                }
            }
            if (isSwap == false) {
                return arr;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {15, 3, 2, 55, 56, 72};
        // int[] arr = {1, 2, 3, 4, 5};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
