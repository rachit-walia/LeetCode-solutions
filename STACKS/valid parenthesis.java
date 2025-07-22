import java.util.Stack;

class Solution {
    public boolean checkValidString(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' ) {
                st.push(ch);
            } 
            else{
                if(st.size() == 0 ) return false;
                if(st.peek() == '(') st.pop();
            }
            
        }
        if(st.size() > 0 ) return false;

        return true;
    }
}
