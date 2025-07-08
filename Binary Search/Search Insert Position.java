// 35. Search Insert Position
/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
 */

class Solution {

    public int searchInsert(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        // int ans=0;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }

        }
        return s;
    }
}
