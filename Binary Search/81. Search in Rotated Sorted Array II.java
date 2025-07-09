// 81. Search in Rotated Sorted Array II

/*
 
There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

You must decrease the overall operation steps as much as possible.

 

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false

 */
class Solution {

    public boolean search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] == target) {
                return true; //  found the target
            }

            // If duplicates exist at both ends and mid, skip them
            if (nums[s] == nums[mid] && nums[mid] == nums[e]) {
                s++;
                e--;
            } // Left side is sorted
            else if (nums[s] <= nums[mid]) {
                // Check if target is in the left half
                if (nums[s] <= target && target < nums[mid]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } // Right side is sorted
            else {
                // Check if target is in the right half
                if (nums[mid] < target && target <= nums[e]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }

        return false;
    }
}
