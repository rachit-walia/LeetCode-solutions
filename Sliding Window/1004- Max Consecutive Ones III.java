// LeetCode--1004
// Max Consecutive Ones III

class Solution {

    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, maxLength = 0;
        int n = nums.length;
        while (right < n) {
            if (nums[right] == 0) {
                k--;
            }
            while (k < 0) {
                if (nums[left] == 0) {
                    k++;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
