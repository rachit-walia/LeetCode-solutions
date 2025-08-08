
class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean contains = true;
        int left = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int right = 0; right < nums.length; right++) {

            if (set.contains(nums[right])) {
                return true;
            }
            set.add(nums[right]);
            if (set.size() > k) {
                set.remove(nums[left]);
                left++;
            }

        }
        return false;
    }
}
