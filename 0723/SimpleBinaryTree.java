public class SimpleBinaryTree {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    // 遞迴印出樹的圖形（右子節點在上）
    public static void printTree(TreeNode node, int depth) {
        if (node == null) return;

        printTree(node.right, depth + 1); // 先印右邊
        System.out.println(" ".repeat(depth * 4) + node.data); // 每層縮排 4 空格
        printTree(node.left, depth + 1);  // 再印左邊
    }

    public static void main(String[] args) {
        // 建立一個簡單的二元樹
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // 顯示節點值
        System.out.println("樹的結構:");
        System.out.println("根節點: " + root.data);
        System.out.println("左子樹: " + root.left.data);
        System.out.println("右子樹: " + root.right.data);
        System.out.println("左子樹的左子樹: " + root.left.left.data);
        System.out.println("左子樹的右子樹: " + root.left.right.data);

        // 印出樹狀結構圖
        System.out.println("\n樹狀結構如下：");
        printTree(root, 0);
    }
}

