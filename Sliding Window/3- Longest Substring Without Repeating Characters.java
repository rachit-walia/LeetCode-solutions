// LeetCode 3
// Longest Substring Without Repeating Characters

class Solution {

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, maxlength = 0;
        HashSet<Character> set = new HashSet<>();

        while (right < s.length()) {
            char currentChar = s.charAt(right);
            if (!set.contains(currentChar)) {
                set.add(currentChar);
                maxlength = Math.max(maxlength, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxlength;
    }
}
