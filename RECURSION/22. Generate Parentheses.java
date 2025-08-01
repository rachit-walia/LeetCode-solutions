// 22. Generate Parentheses

class Solution {

    List<String> result = new ArrayList<>();

    private boolean isValid(String curr) {
        int count = 0;
        for (int i = 0; i < curr.length(); i++) {
            char ch = curr.charAt(i);
            if (ch == '(') {
                count++;
            } else {
                count--;
            }
            // Early exit if invalid
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    private void solve(String curr, int n) {
        if (curr.length() == 2 * n) {
            if (isValid(curr)) {
                result.add(curr);
            }
            return;
        }

        solve(curr + "(", n);  // add '('
        solve(curr + ")", n);  // add ')'
    }

    public List<String> generateParenthesis(int n) {
        solve("", n);
        return result;
    }
}
