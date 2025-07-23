
import java.util.*;

public class PreviousGreaterElement {

    static int[] previous(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        res[0] = -1;
        st.push(arr[0]);

        for (int i = 1; i < res.length; i++) {

            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = st.peek();
            }
            st.push(arr[i]);

        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        int[] res = previous(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\nIt's previous greater element are: ");

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }
}
