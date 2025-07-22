class Solution {
    public boolean isValid(String s) {
        int n=s.length();
        Stack<Character> st = new Stack<>();

        if ( s.length() %2 !=0){
            return false;
        }

        for(int i =0; i< s.length(); i++){
            char ch = s.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            }
            else{
                // when stack is empty, there is no matching opening brackets
                if(st.isEmpty()){
                    return false;
                }

                char top = st.pop(); 
                if ((ch==')' && top != '(') || ( ch==']' && top!= '[') || (ch == '}' && top!= '{')){
                    return false;
                }
            }
            
        }
        return st.isEmpty();
        
    }
}