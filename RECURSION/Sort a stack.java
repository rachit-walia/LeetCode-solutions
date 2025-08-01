
class GfG {

    private void insertsorted(Stack<Integer> s, int element) {
        if (s.isEmpty() || element > s.peek()) {
            s.push(element);
            return;
        }
        int top = s.pop();
        insertsorted(s, element);
        s.push(top);
    }

    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        if (!s.isEmpty()) {
            int top = s.pop();
            sort(s);
            insertsorted(s, top);
        }
        return s;
    }
}
