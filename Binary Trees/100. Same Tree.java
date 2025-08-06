
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

// Method 2
class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        preorder(p, list1);
        preorder(q, list2);

        return list1.equals(list2);
    }

    private void preorder(TreeNode node, List<String> list) {
        if (node == null) {
            list.add("null");
            return;
        }
        // preorder--> NLR
        list.add(String.valueOf(node.val));
        preorder(node.left, list);
        preorder(node.right, list);

    }

}
