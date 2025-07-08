// 34. Find First and Last Position of Element in Sorted Array

/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 */
class Solution {

    static int findFirst(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        int index = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] >= target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
            if (nums[mid] == target) {
                index = mid;
            }

        }
        return index;
    }

    static int findLast(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        int index = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] <= target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
            if (nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2];
        arr[0] = findFirst(nums, target);
        arr[1] = findLast(nums, target);
        return arr;
    }

}
