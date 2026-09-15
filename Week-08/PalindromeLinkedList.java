public class PalindromeLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalfHead = reverseList(slow.next);

        ListNode p1 = head;
        ListNode p2 = secondHalfHead;
        boolean palindrome = true;

        while (palindrome && p2 != null) {
            if (p1.val != p2.val) {
                palindrome = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        slow.next = reverseList(secondHalfHead);

        return palindrome;
    }

    private static ListNode reverseList(ListNode head) {
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

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(2);
        h1.next.next = new ListNode(2);
        h1.next.next.next = new ListNode(1);
        System.out.print("List 1: ");
        printList(h1);
        System.out.println("Is Palindrome? " + isPalindrome(h1));

        ListNode h2 = new ListNode(1);
        h2.next = new ListNode(2);
        h2.next.next = new ListNode(3);
        h2.next.next.next = new ListNode(2);
        h2.next.next.next.next = new ListNode(1);
        System.out.print("\nList 2: ");
        printList(h2);
        System.out.println("Is Palindrome? " + isPalindrome(h2));

        ListNode h3 = new ListNode(1);
        h3.next = new ListNode(2);
        h3.next.next = new ListNode(3);
        System.out.print("\nList 3: ");
        printList(h3);
        System.out.println("Is Palindrome? " + isPalindrome(h3));
    }
}
