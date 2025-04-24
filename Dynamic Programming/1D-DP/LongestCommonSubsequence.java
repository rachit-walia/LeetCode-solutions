// Leetcode--300   Longest Increasing Subsequence

// using RECURSION
class Solution {

    int n;

    int solve(int[] nums, int i, int P) {
        if (i >= n) {
            return 0;
        }
        int take = 0;
        if (P == -1 || nums[i] > nums[P]) {
            take = 1 + solve(nums, i + 1, i);
        }
        int skip = solve(nums, i + 1, P);

        return Math.max(take, skip);
    }

    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        return solve(nums, 0, -1);
    }
}

// USING RECURSION + MEMOIZATION
class Solution {

    int n;
    Integer[][] t = new Integer[2501][2501];

    int solve(int[] nums, int i, int P) {
        if (i >= n) {
            return 0;
        }

        if (P != -1 && t[i][P] != null) {
            return t[i][P];
        }

        int take = 0;
        if (P == -1 || nums[i] > nums[P]) {
            take = 1 + solve(nums, i + 1, i);
        }
        int skip = solve(nums, i + 1, P);
        if (P != -1) {
            t[i][P] = Math.max(take, skip);
        }
        return Math.max(take, skip);
    }

    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        return solve(nums, 0, -1);
    }
}
