
public class SecondLargestElement {

    static int secondlargest(int[] arr) {
        int n = arr.length;
        int largest = arr[0];
        int secondlargest = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > largest) {
                secondlargest = largest;
                largest = arr[i];
            }
        }
        return secondlargest;
    }

    public static void main(String[] args) {
        int[] arr = {12, 15, 43, 25, 52, 89};
        int element = secondlargest(arr);
        System.out.println(element);
    }
}
