
class Solution {

    private void getAllCombination(int[] arr, int idx, int target, List<List<Integer>> ans, List<Integer> combin) {
        if (idx == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(combin));  //  Add a copy of the current combination
            }
            return;
        }

        // Pick the element (single or multiple times)
        if (arr[idx] <= target) {
            combin.add(arr[idx]);  // Choose current element
            getAllCombination(arr, idx, target - arr[idx], ans, combin);  // Stay at idx for multiple uses
            combin.remove(combin.size() - 1);  //  Backtracking step
        }

        // Skip the element
        getAllCombination(arr, idx + 1, target, ans, combin);  //  Move to next index
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combin = new ArrayList<>();
        getAllCombination(candidates, 0, target, ans, combin);
        return ans;
    }
}
