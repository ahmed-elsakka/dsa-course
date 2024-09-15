
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

public class BinarySearchTree {
	private TreeNode root;
	
	public BinarySearchTree() {
		this.root = null;
	}

	public boolean search(int val) {
		TreeNode current = root;
		
		while(current != null) {
			if (val == current.val) {
				return true;
			} else if (val < current.val) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return false;
	}
	
	public void insert(int val) {
			TreeNode newNode = new TreeNode(val);
			if (root == null) {
				root = newNode;
				return;
			}
			
			TreeNode current = root;
			
			while (current != null) {
				if (val < current.val) {
					if (current.left == null) {
						current.left = newNode;
						return;
					}
					current = current.left;
				} else if (val > current.val) {
					if (current.right == null) {
						current.right = newNode;
						return;
					}
					current = current.right;
				} else {
					return;
				}
			}
	}
	

}
