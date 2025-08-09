
class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int w, int valueDiff) {
        SortedSet<Integer> set = new TreeSet<>();

        int n = nums.length;
        int i = 0;
        for (; i <= w && i < n; ++i) {
            // int absDiff = Math.abs(valueDiff - nums[i]);
            if (set.subSet(nums[i] - valueDiff, nums[i] + valueDiff + 1).size() > 0) {
                // System.out.println(set+" "+absDiff+" "+set.subSet(nums[i]-valueDiff, nums[i]+valueDiff+1));
                return true;
            }
            set.add(nums[i]);
        }

        int s = 0;
        for (; i < n; ++i) {
            set.remove(nums[s]);
            s++;
            // int absDiff = Math.abs(valueDiff - nums[i]);
            if (set.subSet(nums[i] - valueDiff, nums[i] + valueDiff + 1).size() > 0) {
                System.out.println(set);
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
