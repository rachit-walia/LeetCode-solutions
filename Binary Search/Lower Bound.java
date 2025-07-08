        // Lower Bound

/* Lower Bound
100
Hint
Given a sorted array of nums and an integer x, write a program to find the lower bound of x.



The lower bound algorithm finds the first and smallest index in a sorted array where the value at that index is greater than or equal to a given key i.e. x.



If no such index is found, return the size of the array.


Examples:
Input : nums= [1,2,2,3], x = 2

Output:1

Explanation:

Index 1 is the smallest index such that arr[1] >= x.

Input : nums= [3,5,8,15,19], x = 9

Output: 3*/
class Solution {

    public int lowerBound(int[] nums, int x) {
        int start = 0;
        int end = nums.length - 1;
        int answer = nums.length;  // Default: not found (out of bounds)

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] >= x) {
                answer = mid;      // Potential answer found
                end = mid - 1;     // Search left half
            } else {
                start = mid + 1;   // Search right half
            }
        }

        // If x is greater than all elements, return -1
        return (answer == nums.length) ? -1 : answer;
    }
}
