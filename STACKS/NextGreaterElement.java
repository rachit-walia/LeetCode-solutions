
import java.util.*;

public class NextGreaterElement {

    static int[] greater(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements that are smaller or equal to current element
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            // If stack is empty, no greater element to the right
            if (st.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = st.peek();
            }

            // Push current element to stack
            st.push(arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 4, 6, 1, 4};

        int[] res = greater(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}

//  using double for loop
/*
 
public class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1, 8, 6, 3, 4};
        int[] res = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            res[i] = -1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    res[i] = arr[j];
                    break;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nNext Greater Element is :");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }
}


 */
