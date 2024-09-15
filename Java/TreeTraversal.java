class _TreeNode {
    int val;
    _TreeNode left;
    _TreeNode right;

    public _TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
	_TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public void inorderTraversal(_TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.val + " ");
            inorderTraversal(node.right);
        }
    }

    public void preorderTraversal(_TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    public void postorderTraversal(_TreeNode node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.val + " ");
        }
    }
}

public class TreeTraversal {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new _TreeNode(1);
        tree.root.left = new _TreeNode(2);
        tree.root.right = new _TreeNode(3);
        tree.root.left.left = new _TreeNode(4);
        tree.root.left.right = new _TreeNode(5);

        System.out.println("Inorder traversal:");
        tree.inorderTraversal(tree.root);
        System.out.println();

        System.out.println("Preorder traversal:");
        tree.preorderTraversal(tree.root);
        System.out.println();

        System.out.println("Postorder traversal:");
        tree.postorderTraversal(tree.root);
        System.out.println();
    }
}
