class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode top;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.top = null;
    }
}

public class TreeTraversal {
    public void inorderTraversal(TreeNode root) {
        TreeNode current = leftMostNode(root);
        while (current != null) {
            System.out.print(current.val + " ");
            if (current.right != null)     current = leftMostNode(current.right);
            else                           current = nextInOrderSuccessor(current);
        }
    }
    private TreeNode leftMostNode(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    private TreeNode nextInOrderSuccessor(TreeNode node) {
        if (node.top == null) {
            return null; // Reached the root, no more successors
        }

        if (node == node.top.left) {
            return node.top;
        } else {
            return nextInOrderSuccessor(node.top);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // 设置父节点指针
        root.left.top = root;
        root.right.top = root;
        root.left.left.top = root.left;
        root.left.right.top = root.left;

        System.out.println("Inorder Traversal:");
        TreeTraversal treeTraversal = new TreeTraversal();
        treeTraversal.inorderTraversal(root);
    }
}
