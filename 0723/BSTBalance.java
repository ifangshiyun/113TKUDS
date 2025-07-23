public class BSTBalance {
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // 1️⃣ 檢查是否為平衡樹
    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    // 回傳高度，若子樹不平衡則回傳 -1（剪枝）
    private static int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int left = checkHeight(node.left);
        if (left == -1) return -1;

        int right = checkHeight(node.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);
    }

    // 2️⃣ 計算每個節點的平衡因子（左高 - 右高）
    public static void printBalanceFactors(TreeNode root) {
        printBFHelper(root);
    }

    private static int printBFHelper(TreeNode node) {
        if (node == null) return 0;

        int left = printBFHelper(node.left);
        int right = printBFHelper(node.right);

        int balance = left - right;
        System.out.println("節點 " + node.data + " 的平衡因子: " + balance);
        return 1 + Math.max(left, right);
    }

    // 3️⃣ 找出最不平衡的節點（回傳平衡因子最大差的節點）
    static class ImbalanceResult {
        TreeNode node;
        int maxDiff = -1;
    }

    public static TreeNode findMostUnbalanced(TreeNode root) {
        ImbalanceResult result = new ImbalanceResult();
        findUnbalancedHelper(root, result);
        return result.node;
    }

    private static int findUnbalancedHelper(TreeNode node, ImbalanceResult result) {
        if (node == null) return 0;

        int left = findUnbalancedHelper(node.left, result);
        int right = findUnbalancedHelper(node.right, result);
        int diff = Math.abs(left - right);

        if (diff > result.maxDiff) {
            result.maxDiff = diff;
            result.node = node;
        }

        return 1 + Math.max(left, right);
    }

    // 主程式測試
    public static void main(String[] args) {
        /*
            測試樹：
                    10
                   /  \
                 5     20
                /        \
              2           30
                             \
                             40
        */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(2);
        root.right.right = new TreeNode(30);
        root.right.right.right = new TreeNode(40);

        // 1. 檢查是否為平衡
        System.out.println("是否為平衡樹: " + isBalanced(root)); // false

        // 2. 平衡因子列印
        System.out.println("\n節點平衡因子:");
        printBalanceFactors(root);

        // 3. 找出最不平衡節點
        TreeNode unbalanced = findMostUnbalanced(root);
        System.out.println("\n最不平衡節點: " + unbalanced.data);
    }
}
