public class TreeNodeExample {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        // 顯示單一節點資訊
        public void displayNode() {
            System.out.println("節點值: " + data);
            System.out.println("左子節點: " + (left != null ? left.data : "null"));
            System.out.println("右子節點: " + (right != null ? right.data : "null"));
        }
    }

    // 印出樹的結構（倒過來顯示，右子節點在上）
    public static void printTree(TreeNode node, int depth) {
        if (node == null) return;

        printTree(node.right, depth + 1);  // 先印右子節點
        System.out.println(" ".repeat(depth * 4) + node.data); // 每層縮排 4 空格
        printTree(node.left, depth + 1);   // 再印左子節點
    }

    public static void main(String[] args) {
        // 建立樹
        TreeNode root = new TreeNode(10);
        TreeNode leftChild = new TreeNode(5);
        TreeNode rightChild = new TreeNode(15);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);

        // 建立樹的連結
        root.left = leftChild;
        root.right = rightChild;
        leftChild.left = node1;
        leftChild.right = node2;

        // 顯示每個節點資訊
        root.displayNode();
        leftChild.displayNode();
        rightChild.displayNode();
        node1.displayNode();
        node2.displayNode();

        // 印出樹狀結構圖
        System.out.println("\n樹狀結構如下：");
        printTree(root, 0);
    }
}
