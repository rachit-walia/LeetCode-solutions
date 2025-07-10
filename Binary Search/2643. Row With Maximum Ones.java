            // 2643. Row With Maximum Ones

/*
 
Given a m x n binary matrix mat, find the 0-indexed position of the row that contains the maximum count of ones, and the number of ones in that row.

In case there are multiple rows that have the maximum count of ones, the row with the smallest row number should be selected.

Return an array containing the index of the row, and the number of ones in it.

 

Example 1:

Input: mat = [[0,1],[1,0]]
Output: [0,1]
Explanation: Both rows have the same number of 1's. So we return the index of the smaller row, 0, and the maximum count of ones (1). So, the answer is [0,1]. 
Example 2:

Input: mat = [[0,0,0],[0,1,1]]
Output: [1,2]
Explanation: The row indexed 1 has the maximum count of ones (2). So we return its index, 1, and the count. So, the answer is [1,2].
Example 3:

Input: mat = [[0,0],[1,1],[0,0]]
Output: [1,2]
Explanation: The row indexed 1 has the maximum count of ones (2). So the answer is [1,2].
 

 */
// Solving this ques using simple for loop no advance code (just for understanding/and to keep basic strong)
class Solution {

    public int[] rowAndMaximumOnes(int[][] mat) {
        int maxCount = 0;
        int rowIndex = 0;
        int[] arr = new int[2];

        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                rowIndex = i;
            }
        }

        arr[0] = rowIndex;
        arr[1] = maxCount;
        return arr;
    }
}

// Using Binary Search
class Solution {

    public int[] rowAndMaximumOnes(int[][] mat) {
        int maxCount = 0;
        int rowIndex = -1;
        int cols = mat[0].length;

        for (int i = 0; i < mat.length; i++) {
            int firstOneIndex = binarySearchFirstOne(mat[i]);
            int count = (firstOneIndex == -1) ? 0 : cols - firstOneIndex;

            if (count > maxCount) {
                maxCount = count;
                rowIndex = i;
            }
        }

        return new int[]{rowIndex, maxCount};
    }

    private int binarySearchFirstOne(int[] row) {
        int low = 0;
        int high = row.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (row[mid] == 1) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }
}
