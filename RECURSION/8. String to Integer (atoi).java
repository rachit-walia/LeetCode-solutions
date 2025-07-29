class Solution {
    static boolean isDigit(char ch){
        if(ch <= '9' && ch >= '0' ){
            return true;
        }
        return false;
    }

    public int myAtoi(String s) {
        int num = 0;
        int sign = 1; // by default it's positive
        int i = 0;

        // 1. whiteSpaces
        while(i < s.length() && s.charAt(i) == ' '){
            i = i + 1;
        }

        // 2. Signedness
        if(i < s.length()){
            if(s.charAt(i) == '-'){
                sign = -1;
                i = i + 1;
            }
            else if(s.charAt(i) == '+'){
                i = i + 1;
            }
        }

        // 3. Conversion
        while(i < s.length() && isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';
            
            // 4. Rounding
            if(num > (Integer.MAX_VALUE - digit) / 10){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            num = num * 10 + digit;
            i = i + 1;
        }

        return num * sign;
    }
}
