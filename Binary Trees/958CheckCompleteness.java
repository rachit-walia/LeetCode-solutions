// 958. Check Completeness of a Binary Tree

/*
 complete BT--In a complete binary tree, every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 */
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
// using BST
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

// using dfs
class Solution {
    // using dfs

    int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    boolean dfs(TreeNode root, int i, int totalNodes) {
        if (root == null) {
            return true;
        }
        if (i > totalNodes) {
            return false;
        }
        return dfs(root.left, 2 * i, totalNodes) && dfs(root.right, 2 * i + 1, totalNodes);
    }

    public boolean isCompleteTree(TreeNode root) {
        int totalNodes = countNodes(root);
        int i = 1;
        return dfs(root, i, totalNodes);
    }
}
