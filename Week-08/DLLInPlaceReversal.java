public class DLLInPlaceReversal {
    static class Node {
        int val;
        Node prev, next;
        Node(int val) {
            this.val = val;
        }
    }

    public static Node reverseDLL(Node head) {
        if (head == null || head.next == null) return head;

        Node curr = head;
        Node temp = null;

        while (curr != null) {

            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;

            curr = curr.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }

        return head;
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " <-> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        head.next = n2; n2.prev = head;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;
        n4.next = n5; n5.prev = n4;

        System.out.print("Original DLL: ");
        printList(head);

        head = reverseDLL(head);

        System.out.print("Reversed DLL: ");
        printList(head);
    }
}
