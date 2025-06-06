
public class SelectionSort {

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int SI = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[SI]) {
                    SI = j;
                }
            }
            swap(arr, i, SI);
        }
    }

    public static void main(String[] args) {
        int[] arr = {26, 9, 19, 12, 1, 4};
        selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
