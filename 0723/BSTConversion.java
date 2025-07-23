public class BSTConversion {
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // ===============================
    // 1️⃣ BST → 排序雙向鏈結串列
    static class DoublyListNode {
        int data;
        DoublyListNode prev, next;

        DoublyListNode(int data) {
            this.data = data;
        }
    }

    static DoublyListNode head = null;
    static DoublyListNode prev = null;

    public static DoublyListNode bstToDoublyList(TreeNode root) {
        head = null;
        prev = null;
        inorderBSTToList(root);
        return head;
    }

    private static void inorderBSTToList(TreeNode node) {
        if (node == null) return;

        inorderBSTToList(node.left);

        DoublyListNode curr = new DoublyListNode(node.data);
        if (prev != null) {
            prev.next = curr;
            curr.prev = prev;
        } else {
            head = curr; // 第一個節點
        }
        prev = curr;

        inorderBSTToList(node.right);
    }

    // ===============================
    // 2️⃣ 排序陣列 → 平衡 BST
    public static TreeNode sortedArrayToBST(int[] arr) {
        return buildBSTFromSortedArray(arr, 0, arr.length - 1);
    }

    private static TreeNode buildBSTFromSortedArray(int[] arr, int left, int right) {
        if (left > right) return null;

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = buildBSTFromSortedArray(arr, left, mid - 1);
        root.right = buildBSTFromSortedArray(arr, mid + 1, right);
        return root;
    }

    // ===============================
    // 3️⃣ Greater Tree：每個節點值替換成「所有大於等於它的值總和」
    static int sum = 0;

    public static void convertToGreaterTree(TreeNode node) {
        if (node == null) return;

        convertToGreaterTree(node.right); // 先走右邊（大值）
        sum += node.data;
        node.data = sum;
        convertToGreaterTree(node.left);
    }

    // ===============================
    // 中序印樹
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    // 印雙向串列
    public static void printDoublyList(DoublyListNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        // 測試用 BST: [20, 10, 30, 5, 15, 25, 35]
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);

        // 1️⃣ BST → 雙向串列
        System.out.println("BST 轉雙向鏈結串列:");
        DoublyListNode list = bstToDoublyList(root);
        printDoublyList(list);

        // 2️⃣ 陣列 → 平衡 BST
        System.out.println("\n\n排序陣列 → 平衡 BST:");
        int[] sorted = {1, 2, 3, 4, 5, 6, 7};
        TreeNode bstFromArray = sortedArrayToBST(sorted);
        printInOrder(bstFromArray);

        // 3️⃣ BST 轉 Greater Tree
        System.out.println("\n\nBST 轉 Greater Tree:");
        sum = 0; // reset global sum
        convertToGreaterTree(root);
        printInOrder(root); // 變成新值的中序結果
    }
}
