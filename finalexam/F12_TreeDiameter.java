package finalexam;

import java.util.*;

public class F12_TreeDiameter {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // 建立二元樹（層序輸入，-1 表 null）
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

    // 計算直徑
    static int maxDiameter = 0;

    public static int height(TreeNode node) {
        if (node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);
        maxDiameter = Math.max(maxDiameter, left + right); // 路徑邊數
        return Math.max(left, right) + 1;
    }

    // 印出整棵樹（level-order，包括 -1）
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

    // 漂亮樹狀輸出（右上左下）
    public static void printPrettyTree(TreeNode root) {
        printPrettyTree(root, 0);
    }

    private static void printPrettyTree(TreeNode node, int level) {
        if (node == null) return;
        printPrettyTree(node.right, level + 1);
        System.out.println("  ".repeat(level) + node.val);
        printPrettyTree(node.left, level + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 輸入：節點序列（空格分隔，-1 表 null）
        String[] input = scanner.nextLine().split(" ");
        List<Integer> nodes = new ArrayList<>();
        for (String s : input) {
            nodes.add(Integer.parseInt(s));
        }

        TreeNode root = buildTree(nodes);
        height(root); // 啟動遞迴並更新 maxDiameter

        // 輸出結果與視覺化
        System.out.println("Diameter: " + maxDiameter);
        printLevelOrder(root);
        System.out.println("Tree Structure:");
        printPrettyTree(root);

        scanner.close();
    }
}





