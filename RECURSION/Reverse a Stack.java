
class Solution {

    static void reverse(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;            // base case

                }int element = s.pop();
        reverse(s);
        insertAtBottom(s, element);        // place popped element at bottom
    }

    // Helper to insert an element at the bottom of the stack
    private static void insertAtBottom(Stack<Integer> s, int x) {
        if (s.isEmpty()) {
            s.push(x);
            return;
        }
        int top = s.pop();
        insertAtBottom(s, x);
        s.push(top);
    }
}
