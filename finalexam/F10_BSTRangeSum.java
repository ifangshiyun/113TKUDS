package finalexam;

import java.util.*;

public class F10_BSTRangeSum {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // 建立 BST（層序輸入，-1 表 null）
    public static TreeNode buildTree(List<Integer> nodes) {
        if (nodes.isEmpty() || nodes.get(0) == -1) return null;

        TreeNode root = new TreeNode(nodes.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (i < nodes.size()) {
            TreeNode current = queue.poll();

            if (i < nodes.size() && nodes.get(i) != -1) {
                current.left = new TreeNode(nodes.get(i));
                queue.offer(current.left);
            }
            i++;

            if (i < nodes.size() && nodes.get(i) != -1) {
                current.right = new TreeNode(nodes.get(i));
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    // 印出 BFS 結構（含 -1）
    public static void printLevelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        System.out.print("Tree Level Order: ");
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                System.out.print("-1 ");
                continue;
            }
            System.out.print(current.val + " ");
            queue.offer(current.left);
            queue.offer(current.right);
        }
        System.out.println();
    }

    // 漂亮格式印出樹狀結構（右邊在上）
    public static void printPrettyTree(TreeNode root) {
        printPrettyTree(root, 0);
    }

    private static void printPrettyTree(TreeNode node, int level) {
        if (node == null) return;
        printPrettyTree(node.right, level + 1);
        System.out.println("  ".repeat(level) + node.val);
        printPrettyTree(node.left, level + 1);
    }

    // BST 區間總和
    public static int rangeSum(TreeNode node, int L, int R) {
        if (node == null) return 0;
        if (node.val < L) return rangeSum(node.right, L, R);
        if (node.val > R) return rangeSum(node.left, L, R);
        return node.val + rangeSum(node.left, L, R) + rangeSum(node.right, L, R);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 輸入樹節點（以空格分隔，-1 表 null）
        String[] input = scanner.nextLine().split(" ");
        List<Integer> nodes = new ArrayList<>();
        for (String val : input) {
            nodes.add(Integer.parseInt(val));
        }

        // 輸入區間 [L, R]
        int L = scanner.nextInt();
        int R = scanner.nextInt();

        TreeNode root = buildTree(nodes);

        // 計算區間總和
        int sum = rangeSum(root, L, R);
        System.out.println("Sum: " + sum);

        // 印出樹的兩種格式
        printLevelOrder(root);
        System.out.println("Tree Structure:");
        printPrettyTree(root);

        scanner.close();
    }
}





