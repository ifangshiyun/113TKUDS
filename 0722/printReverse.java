public class printReverse {
    // 定義 ListNode 類別
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 反向列印鏈結串列的元素
    public static void printReverse(ListNode head) {
        if (head == null) return;

        printReverse(head.next);
        System.out.print(head.val + " ");
    }

    public static void main(String[] args) {
        // 建立一條鏈結串列：1 -> 2 -> 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        System.out.print("Reversed list: ");
        printReverse(head); // 預期輸出：3 2 1
        System.out.println();
    }
}
