public class DLLDeleteAllOccurrences {
    static class Node {
        int val;
        Node prev, next;
        Node(int val) {
            this.val = val;
        }
    }

    public static Node deleteAllOccurrences(Node head, int target) {
        Node curr = head;

        while (curr != null) {
            if (curr.val == target) {

                if (curr == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else {

                    if (curr.prev != null) {
                        curr.prev.next = curr.next;
                    }

                    if (curr.next != null) {
                        curr.next.prev = curr.prev;
                    }
                }
            }
            curr = curr.next;
        }

        return head;
    }

    public static void printList(Node head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " <-> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = new Node(2);
        Node n1 = new Node(10);
        Node n2 = new Node(2);
        Node n3 = new Node(30);
        Node n4 = new Node(2);
        Node n5 = new Node(2);

        head.next = n1; n1.prev = head;
        n1.next = n2; n2.prev = n1;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;
        n4.next = n5; n5.prev = n4;

        System.out.print("Original DLL: ");
        printList(head);

        int target = 2;
        System.out.println("Deleting all occurrences of " + target + ":");
        head = deleteAllOccurrences(head, target);
        printList(head);
    }
}
