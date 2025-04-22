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

// Bottom --Up
class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return 0;
        }

        int[] t = new int[n + 1];
        // t[i] = money stolen when you have i houses

        t[0] = 0;
        // case 1 -- take first house -- hence skip last house
        for (int i = 1; i <= n - 1; i++) {
            int skip = t[i - 1];
            int take = nums[i - 1] + ((i - 2 >= 0) ? t[i - 2] : 0);
            t[i] = Math.max(skip, take);
        }
        int result1 = t[n - 1];
        t = new int[n + 1];

        // case 2 -- skip 1st house -- hence you can take the last house
        t[0] = 0;
        t[1] = 0;

        for (int i = 2; i <= n; i++) {
            int skip = t[i - 1];
            int take = nums[i - 1] + ((i - 2 >= 0) ? t[i - 2] : 0);
            t[i] = Math.max(skip, take);
        }

        int result2 = t[n];
        return Math.max(result1, result2);
    }
}
