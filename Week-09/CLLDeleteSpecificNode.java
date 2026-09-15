public class CLLDeleteSpecificNode {
    static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    public static Node deleteNode(Node head, int key) {
        if (head == null) return null;

        Node curr = head;
        Node prev = null;

        if (head.val == key && head.next == head) {
            return null;
        }

        if (head.val == key) {

            while (curr.next != head) {
                curr = curr.next;
            }
            curr.next = head.next;
            head = head.next;
            return head;
        }

        curr = head;
        while (curr.next != head && curr.val != key) {
            prev = curr;
            curr = curr.next;
        }

        if (curr.val == key) {
            prev.next = curr.next;
        } else {
            System.out.println("Key " + key + " not found in CLL.");
        }

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
        System.out.println("(Head: " + head.val + ")");
    }

    public static void main(String[] args) {

        Node head = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n5 = new Node(50);

        head.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = head;

        System.out.print("Original: ");
        printList(head);

        System.out.println("\nDeleting middle node 30:");
        head = deleteNode(head, 30);
        printList(head);

        System.out.println("\nDeleting head node 10:");
        head = deleteNode(head, 10);
        printList(head);

        System.out.println("\nDeleting tail node 50:");
        head = deleteNode(head, 50);
        printList(head);
    }
}
