public class inOrder {
    // 定義 TreeNode 類別
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // 中序走訪方法（左 -> 根 -> 右）
    public static void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        // 建立一棵簡單的樹：   5
        //                   /   \
        //                  3     7
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        System.out.print("In-order traversal: ");
        inOrder(root); // 預期輸出：3 5 7
        System.out.println();
    }
}
