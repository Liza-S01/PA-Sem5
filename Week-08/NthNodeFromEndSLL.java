public class NthNodeFromEndSLL {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode findNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) return null;

        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++) {
            if (fast == null) {
                System.out.println("List has fewer than " + n + " nodes.");
                return null;
            }
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Linked List: ");
        printList(head);

        int n = 2;
        ListNode nthNode = findNthFromEnd(head, n);
        System.out.println(n + "nd node from the end: " + (nthNode != null ? nthNode.val : "None"));

        int n2 = 5;
        ListNode nthNode2 = findNthFromEnd(head, n2);
        System.out.println(n2 + "th node from the end: " + (nthNode2 != null ? nthNode2.val : "None"));
    }
}
