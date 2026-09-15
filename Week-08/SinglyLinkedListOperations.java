public class SinglyLinkedListOperations {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        System.out.print("[Head] -> ");
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static int countNodes(ListNode head) {
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    public static int linearSearch(ListNode head, int target) {
        ListNode curr = head;
        int index = 0;
        while (curr != null) {
            if (curr.val == target) return index;
            curr = curr.next;
            index++;
        }
        return -1;
    }

    public static ListNode findMiddle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);

        System.out.println("=== 1. Printing List ===");
        printList(head);

        System.out.println("\n=== 2. Counting Nodes ===");
        System.out.println("Total Nodes: " + countNodes(head));

        System.out.println("\n=== 3. Linear Search ===");
        int target = 30;
        System.out.println("Searching for " + target + ": found at index " + linearSearch(head, target));

        System.out.println("\n=== 4. Finding Middle Element ===");
        ListNode mid = findMiddle(head);
        System.out.println("Middle Node Value: " + (mid != null ? mid.val : "null"));

        System.out.println("\n=== 5. Iterative Reversal ===");
        head = reverseList(head);
        printList(head);
    }
}
