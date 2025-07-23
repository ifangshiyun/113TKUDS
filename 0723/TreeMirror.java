public class TreeMirror {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    // 1. 判斷是否為對稱樹（從根開始比較左右子樹）
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    // 判斷兩棵樹是否互為鏡像（遞迴比對）
    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return t1.data == t2.data &&
               isMirror(t1.left, t2.right) &&
               isMirror(t1.right, t2.left);
    }

    // 2. 將一棵樹轉換成其鏡像（遞迴左右互換）
    public static void mirror(TreeNode node) {
        if (node == null) return;
        // 先遞迴左右子樹
        mirror(node.left);
        mirror(node.right);

        // 再交換左右
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    // 輔助方法：中序走訪印出節點
    public static void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static void main(String[] args) {
        // 建立一棵對稱樹
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        // 1. 測試對稱性
        System.out.println("是否對稱: " + isSymmetric(root));  // true

        // 2. 鏡像轉換
        System.out.print("鏡像前中序: ");
        inOrder(root);
        System.out.println();

        mirror(root);  // 將整棵樹左右子樹交換

        System.out.print("鏡像後中序: ");
        inOrder(root);
        System.out.println();

        // 3. 比較兩棵是否為鏡像
        TreeNode treeA = new TreeNode(1);
        treeA.left = new TreeNode(2);
        treeA.right = new TreeNode(3);

        TreeNode treeB = new TreeNode(1);
        treeB.left = new TreeNode(3);
        treeB.right = new TreeNode(2);

        System.out.println("treeA 與 treeB 是否互為鏡像: " + isMirror(treeA, treeB)); // true
    }
}
