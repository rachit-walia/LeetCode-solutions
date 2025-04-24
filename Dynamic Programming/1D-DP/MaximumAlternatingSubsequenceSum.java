1911--  Maximum Alternating Subsequence Sum

Recusrion-- will give TLE

class Solution {
    int n;

    long solve(int idx, int[] nums, boolean flag) {
        if (idx >= n) {
            return 0;
        }

        long skip = solve(idx + 1, nums, flag);
        long val = nums[idx];
        if (!flag) {
            val = -val;
        }

        long take = solve(idx + 1, nums, !flag) + val;

        return Math.max(skip, take);
    }

    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        return solve(0, nums, true); // true corresponds to '+'
    }
}

// Recursion + Memoization

class Solution {
    int n;
    Long[][] t = new Long[100001][2]; 

    long solve(int idx, int[] nums, boolean isEven) {
        if (idx >= n) return 0;

        int parity = isEven ? 1 : 0;
        if (t[idx][parity] != null) return t[idx][parity];

        long skip = solve(idx + 1, nums, isEven);
        long val = nums[idx];
        if (!isEven) val = -val;

        long take = solve(idx + 1, nums, !isEven) + val;

        return t[idx][parity] = Math.max(skip, take);
    }

    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        return solve(0, nums, true); 
    }
}


// Bottom Up

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] t = new long[n][2];

        t[0][0] = Math.max(-nums[0], 0);
        t[0][1] = Math.max(nums[0], 0);

        for (int i = 1; i < n; i++) {
            t[i][0] = Math.max(t[i - 1][1] - nums[i], t[i - 1][0]);
            t[i][1] = Math.max(t[i - 1][0] + nums[i], t[i - 1][1]);
        }

        return Math.max(t[n - 1][0], t[n - 1][1]);
    }
}

