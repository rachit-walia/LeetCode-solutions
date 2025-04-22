// Using Recursion And Memo

class Solution {

    int[] t = new int[101];

    int solve(int[] nums, int i, int n) {
        if (i > n) {
            return 0;
        }
        if (t[i] != -1) {
            return t[i];
        }

        int take = nums[i] + solve(nums, i + 2, n);
        int skip = solve(nums, i + 1, n);

        return t[i] = Math.max(take, skip);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // Case 1: Rob from house 0 to n-2
        for (int i = 0; i < t.length; i++) {
            t[i] = -1;
        }
        int take_0th_index_house = solve(nums, 0, n - 2);

        // Case 2: Rob from house 1 to n-1
        for (int i = 0; i < t.length; i++) {
            t[i] = -1;
        }
        int take_1st_index_house = solve(nums, 1, n - 1);

        return Math.max(take_0th_index_house, take_1st_index_house);
    }
}
