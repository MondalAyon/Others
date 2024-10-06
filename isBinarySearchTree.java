public class isBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        root.right.right = new TreeNode(5);

        System.out.println(isBinarySearchTree(root));

    }

    private static int minNode(TreeNode root) {

        if (root == null) return Integer.MAX_VALUE;
        return Math.min(root.val, Math.min(minNode(root.left), minNode(root.right)));

    }

    private static int maxNode(TreeNode root) {

        if (root == null) return Integer.MIN_VALUE;
        return Math.max(root.val, Math.max(maxNode(root.left), maxNode(root.right)));

    }

    public static boolean isBinarySearchTree(TreeNode root) {

        if (root == null) return true;

        if (root.val < maxNode(root.left)) return false;
        if (root.val > minNode(root.right)) return true;

        return isBinarySearchTree(root.left) && isBinarySearchTree(root.right);
    }
}
