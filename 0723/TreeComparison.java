public class TreeComparison {
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // 1️⃣ 判斷兩棵樹是否完全相同
    public static boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.data != t2.data) return false;
        return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }

    // 2️⃣ 判斷 t2 是否為 t1 的子樹
    public static boolean isSubtree(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;
        if (t1 == null) return false;
        if (isSameTree(t1, t2)) return true;
        return isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
    }

    // 3️⃣ 找出最大公共子樹（結構與值都要相同，且節點數最多）
    static class Result {
        TreeNode node;
        int size;

        Result(TreeNode node, int size) {
            this.node = node;
            this.size = size;
        }
    }

    public static TreeNode findLargestCommonSubtree(TreeNode t1, TreeNode t2) {
        Result result = new Result(null, 0);
        findCommon(t1, t2, result);
        return result.node;
    }

    private static int findCommon(TreeNode t1, TreeNode t2, Result result) {
        if (t1 == null || t2 == null) return 0;

        if (t1.data == t2.data) {
            int left = findCommon(t1.left, t2.left, result);
            int right = findCommon(t1.right, t2.right, result);
            int total = 1 + left + right;

            if (total > result.size) {
                result.size = total;
                result.node = t1;
            }
            return total;
        } else {
            findCommon(t1.left, t2, result);
            findCommon(t1.right, t2, result);
            findCommon(t1, t2.left, result);
            findCommon(t1, t2.right, result);
            return 0;
        }
    }

    // 中序印樹（驗證用）
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        // 樹 A
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.left.left = new TreeNode(4);
        a.left.right = new TreeNode(5);

        // 樹 B：與 A 相同
        TreeNode b = new TreeNode(1);
        b.left = new TreeNode(2);
        b.right = new TreeNode(3);
        b.left.left = new TreeNode(4);
        b.left.right = new TreeNode(5);

        // 樹 C：A 的子樹
        TreeNode c = new TreeNode(2);
        c.left = new TreeNode(4);
        c.right = new TreeNode(5);

        // 樹 D：部分相同（最大公共子樹為節點 2,4）
        TreeNode d = new TreeNode(2);
        d.left = new TreeNode(4);
        d.right = new TreeNode(9);

        // 1. 判斷相同
        System.out.println("A 與 B 是否完全相同: " + isSameTree(a, b)); // true

        // 2. 判斷子樹
        System.out.println("C 是否為 A 的子樹: " + isSubtree(a, c));    // true

        // 3. 找最大公共子樹
        TreeNode common = findLargestCommonSubtree(a, d);
        System.out.print("A 與 D 的最大公共子樹 InOrder: ");
        printInOrder(common);  // 輸出 4 2
    }
}
