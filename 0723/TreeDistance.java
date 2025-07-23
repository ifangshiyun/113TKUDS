import java.util.*;

public class TreeDistance {
    static class TreeNode {
        int data;
        TreeNode left, right;
        TreeNode(int data) {
            this.data = data;
        }
    }

    // 1️⃣ 找出兩個節點間距離（透過 LCA 計算）
    public static int distanceBetween(TreeNode root, int val1, int val2) {
        TreeNode lca = findLCA(root, val1, val2);
        int d1 = findLevel(lca, val1, 0);
        int d2 = findLevel(lca, val2, 0);
        return d1 + d2;
    }

    private static TreeNode findLCA(TreeNode root, int a, int b) {
        if (root == null) return null;
        if (root.data == a || root.data == b) return root;

        TreeNode left = findLCA(root.left, a, b);
        TreeNode right = findLCA(root.right, a, b);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    private static int findLevel(TreeNode root, int target, int level) {
        if (root == null) return -1;
        if (root.data == target) return level;

        int left = findLevel(root.left, target, level + 1);
        if (left != -1) return left;

        return findLevel(root.right, target, level + 1);
    }

    // 2️⃣ 找出樹的直徑（最大距離）
    static int diameter = 0;
    public static int findTreeDiameter(TreeNode root) {
        diameter = 0;
        dfsDiameter(root);
        return diameter;
    }

    private static int dfsDiameter(TreeNode node) {
        if (node == null) return 0;

        int left = dfsDiameter(node.left);
        int right = dfsDiameter(node.right);

        diameter = Math.max(diameter, left + right);
        return 1 + Math.max(left, right);
    }

    // 3️⃣ 找出與根距離 K 的所有節點
    public static List<Integer> nodesAtDistanceK(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        findNodesAtDistanceK(root, k, 0, result);
        return result;
    }

    private static void findNodesAtDistanceK(TreeNode node, int k, int depth, List<Integer> result) {
        if (node == null) return;
        if (depth == k) {
            result.add(node.data);
            return;
        }
        findNodesAtDistanceK(node.left, k, depth + 1, result);
        findNodesAtDistanceK(node.right, k, depth + 1, result);
    }

    public static void main(String[] args) {
        /*
            測試樹：
                   1
                 /   \
               2       3
              / \     / \
             4   5   6   7
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // 1. 任意兩點間距離
        System.out.println("節點 4 到 7 的距離: " + distanceBetween(root, 4, 7));  // 4

        // 2. 樹的直徑
        System.out.println("整棵樹的直徑: " + findTreeDiameter(root));  // 4

        // 3. 與根距離為 2 的節點
        List<Integer> dist2 = nodesAtDistanceK(root, 2);
        System.out.println("與根距離為 2 的節點: " + dist2); // [4,5,6,7]
    }
}
