// 236. Lowest Common Ancestor of a Binary Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        // left side se leftN nikal lo
        TreeNode leftN = lowestCommonAncestor(root.left, p, q);
        TreeNode rightN = lowestCommonAncestor(root.right, p, q);

        if (leftN != null && rightN != null) {
            return root;
        }

        if (leftN != null) {
            return leftN;
        }

        return rightN;

    }
}
