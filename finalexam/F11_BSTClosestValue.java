package finalexam;

import java.util.*;

public class F11_BSTClosestValue {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

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

    public static void printPrettyTree(TreeNode root) {
        printPrettyTree(root, 0);
    }

    private static void printPrettyTree(TreeNode node, int level) {
        if (node == null) return;
        printPrettyTree(node.right, level + 1);
        System.out.println("  ".repeat(level) + node.val);
        printPrettyTree(node.left, level + 1);
    }

    public static int findClosest(TreeNode root, int target) {
        int closest = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(closest - target) ||
                (Math.abs(root.val - target) == Math.abs(closest - target) && root.val < closest)) {
                closest = root.val;
            }
            root = target < root.val ? root.left : root.right;
        }
        return closest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> nodes = new ArrayList<>();
        for (String s : sc.nextLine().split(" ")) nodes.add(Integer.parseInt(s));
        int target = sc.nextInt();
        TreeNode root = buildTree(nodes);
        System.out.println("Closest: " + findClosest(root, target));
        printLevelOrder(root);
        System.out.println("Tree Structure:");
        printPrettyTree(root);
        sc.close();
    }
}
