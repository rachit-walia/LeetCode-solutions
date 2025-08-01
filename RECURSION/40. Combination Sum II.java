class Solution {

    private void solve(int[] candidates, int target, List<Integer>curr, List<List<Integer>> result , int idx){

        if(target < 0){
            return;
        }
        if(target==0){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i = idx; i < candidates.length; i++){
            if(i > idx && candidates[i]==candidates[i-1]){
                continue;
            }
            curr.add(candidates[i]);
            solve(candidates, target-candidates[i], curr, result, i+1);
            curr.remove(curr.size()-1);
        }
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates); // to handle duplicates
        solve(candidates, target, curr, result ,0);
        return result;
    }
}