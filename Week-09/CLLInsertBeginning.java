public class CLLInsertBeginning {
    static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    public static Node insertBeginning(Node head, int val) {
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

        return newNode;
    }

    public static void printList(Node head) {
        if (head == null) {
            System.out.println("null");
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
        Node head = null;
        System.out.println("Inserting 30 at beginning:");
        head = insertBeginning(head, 30);
        printList(head);

        System.out.println("Inserting 20 at beginning:");
        head = insertBeginning(head, 20);
        printList(head);

        System.out.println("Inserting 10 at beginning:");
        head = insertBeginning(head, 10);
        printList(head);
    }
}
