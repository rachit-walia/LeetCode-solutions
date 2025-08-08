import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        // If t is longer than s, no solution is possible
        if (s.length() < t.length()) {
            return "";
        }

        // Step 1: Store frequency of each char in t
        Map<Character, Integer> required = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (required.containsKey(ch)) {
                required.put(ch, required.get(ch) + 1);
            } else {
                required.put(ch, 1);
            }
        }

        // Step 2: Variables for sliding window
        Map<Character, Integer> window = new HashMap<>();
        int matchedChars = 0; // How many unique characters are fully matched
        int totalRequired = required.size(); // Total unique characters needed

        int left = 0; // Start of window
        int minLength = Integer.MAX_VALUE;
        int minStart = 0; // Start index of smallest valid window

        // Step 3: Expand window by moving right pointer
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // Add currentChar to window count
            if (window.containsKey(currentChar)) {
                window.put(currentChar, window.get(currentChar) + 1);
            } else {
                window.put(currentChar, 1);
            }

            // If it's a needed char and counts match → fully matched
            if (required.containsKey(currentChar) &&
                window.get(currentChar).intValue() == required.get(currentChar).intValue()) {
                matchedChars++;
            }

            // Step 4: Shrink window from the left while all chars matched
            while (matchedChars == totalRequired) {
                // Update minimum window
                int windowSize = right - left + 1;
                if (windowSize < minLength) {
                    minLength = windowSize;
                    minStart = left;
                }

                // Remove left char from window
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                // If removing this char breaks the match
                if (required.containsKey(leftChar) &&
                    window.get(leftChar) < required.get(leftChar)) {
                    matchedChars--;
                }

                left++; // Move window start forward
            }
        }

        // Step 5: Return result
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(minStart, minStart + minLength);
    }
}
