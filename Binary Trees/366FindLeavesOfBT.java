
public class Solution {

    private Map<Integer, List<Integer>> mp = new HashMap<>();

    private int collectNodeWithHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int height = 1 + Math.max(collectNodeWithHeight(root.left), collectNodeWithHeight(root.right));
        mp.computeIfAbsent(height, k -> new ArrayList<>()).add(root.val);

        return height;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        mp.clear();
        collectNodeWithHeight(root);

        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> nodes : mp.values()) {
            result.add(nodes);
        }

        return result;
    }
}
