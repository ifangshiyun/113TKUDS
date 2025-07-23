import java.util.*;

public class BSTValidation {
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // 1. 驗證一棵樹是否為合法 BST（上下限法）
    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.data <= min || node.data >= max) return false;
        return validate(node.left, min, node.data) &&
               validate(node.right, node.data, max);
    }

    // 2. 找出不合法的節點（中序走訪 + 降序檢查）
    public static List<Integer> findInvalidNodes(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        findInvalid(root, Long.MIN_VALUE, Long.MAX_VALUE, result);
        return result;
    }

    private static void findInvalid(TreeNode node, long min, long max, List<Integer> invalids) {
        if (node == null) return;

        if (node.data <= min || node.data >= max) {
            invalids.add(node.data);
        }

        findInvalid(node.left, min, node.data, invalids);
        findInvalid(node.right, node.data, max, invalids);
    }

    // 3. 計算最少刪除節點數（即 invalid node 數量）
    public static int countNodesToRemove(TreeNode root) {
        return findInvalidNodes(root).size();
    }

    public static void main(String[] args) {
        /*
         測試樹如下（不是合法 BST）：
                 10
                /  \
              5     15
             / \    /
           1   12  6   ← 12 和 6 是不合法的節點
        */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(12);  // ❌ 應小於 10，但大於
        root.right.left = new TreeNode(6);   // ❌ 應大於 10，但小於

        // 1. 是否為合法 BST？
        System.out.println("是否為合法 BST: " + isValidBST(root));  // false

        // 2. 印出不合法節點
        List<Integer> invalids = findInvalidNodes(root);
        System.out.println("不合法的節點: " + invalids);           // [12, 6]

        // 3. 最少移除幾個節點？
        System.out.println("需要移除的節點數: " + countNodesToRemove(root));  // 2
    }
}
