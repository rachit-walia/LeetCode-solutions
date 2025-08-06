
class TreeNode {

    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

public class TreeTraversal {

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    public void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeTraversal tree = new TreeTraversal();
        System.out.print("PreOrder : ");
        tree.preorder(root);
        System.out.println();

        System.out.print("Inorder: ");
        tree.inorder(root);
        System.out.println();

        System.out.print("Postorder: ");
        tree.postorder(root);
        System.out.println();
    }
}
