
class Solution {

    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, maxLength = 0;
        int[] freq = new int[26];
        int maxFreq = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            freq[ch - 'A']++;
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            if ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
