// 958. Check Completeness of a Binary Tree

/*
 complete BT--In a complete binary tree, every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 */
// using BST
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

    public boolean isCompleteTree(TreeNode root) {
        // using BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean past = false;

        while (!queue.isEmpty()) {
            TreeNode node = queue.peek();
            queue.poll();

            if (node == null) {
                past = true;
            } else {
                if (past) {
                    return false;
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return true;
    }
}
