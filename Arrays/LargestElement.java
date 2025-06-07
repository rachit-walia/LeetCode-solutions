
public class LargestElement {

    static int largestelement(int[] arr) {
        int n = arr.length;
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        int[] arr = {10, 24, 45, 90, 22, 43};
        int element = largestelement(arr);
        System.out.println(element);
    }
}
