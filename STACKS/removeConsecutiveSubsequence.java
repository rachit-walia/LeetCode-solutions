
import java.util.Stack;

public class removeConsecutiveSubsequence {

    public static int[] remove(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length;) {
            if (st.isEmpty() || st.peek() != arr[i]) {
                // Check if there's a consecutive sequence
                int j = i + 1;
                while (j < arr.length && arr[j] == arr[i]) {
                    j++;
                }
                if (j == i + 1) {
                    st.push(arr[i]); // No duplicates
                }
                // Skip entire group if duplicate sequence
                i = j;
            } else {
                st.pop(); // Remove previous duplicate
                i++;
            }
        }

        int[] res = new int[st.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 10, 10, 10, 4, 4, 4, 5, 7, 7, 2};
        int[] res = remove(arr);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
