public class CircularLinkedListOperations {
    static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    public static Node insertEnd(Node head, int val) {
        Node newNode = new Node(val);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.next = head;

        return head;
    }

    public static void printList(Node head) {
        if (head == null) {
            System.out.println("CLL is empty");
            return;
        }
        Node curr = head;
        System.out.print("[CLL] -> ");
        do {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        } while (curr != head);
        System.out.println("(back to Head: " + head.val + ")");
    }

    public static void printReverseHelper(Node curr, Node head) {
        if (curr == null) return;
        if (curr.next != head) {
            printReverseHelper(curr.next, head);
        }
        System.out.print(curr.val + " ");
    }

    public static void printReverse(Node head) {
        if (head == null) return;
        System.out.print("Reverse Print: ");
        printReverseHelper(head, head);
        System.out.println();
    }

    public static Node findMiddle(Node head) {
        if (head == null) return null;
        Node slow = head;
        Node fast = head;

        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static int solveJosephus(int n, int k) {
        if (n <= 0 || k <= 0) return -1;

        Node head = new Node(1);
        Node prev = head;
        for (int i = 2; i <= n; i++) {
            prev.next = new Node(i);
            prev = prev.next;
        }
        prev.next = head;

        Node curr = head;
        while (curr.next != curr) {

            for (int i = 1; i < k - 1; i++) {
                curr = curr.next;
            }

            System.out.println("Eliminated person: " + curr.next.val);
            curr.next = curr.next.next;
            curr = curr.next;
        }

        return curr.val;
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertEnd(head, 10);
        head = insertEnd(head, 20);
        head = insertEnd(head, 30);
        head = insertEnd(head, 40);
        head = insertEnd(head, 50);

        System.out.println("=== 1. CLL Traversal ===");
        printList(head);

        System.out.println("\n=== 2. Reverse Printing CLL ===");
        printReverse(head);

        System.out.println("\n=== 3. Middle Element ===");
        Node mid = findMiddle(head);
        System.out.println("Middle element value: " + (mid != null ? mid.val : "null"));

        System.out.println("\n=== 4. Josephus Problem (n = 5, k = 2) ===");
        int survivor = solveJosephus(5, 2);
        System.out.println("Survivor is person: " + survivor);
    }
}
