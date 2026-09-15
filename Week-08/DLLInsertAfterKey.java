public class DLLInsertAfterKey {
    static class Node {
        int val;
        Node prev, next;
        Node(int val) {
            this.val = val;
        }
    }

    public static Node insertAfterKey(Node head, int keyNodeVal, int newVal) {
        Node curr = head;

        while (curr != null && curr.val != keyNodeVal) {
            curr = curr.next;
        }

        if (curr == null) {
            System.out.println("Key " + keyNodeVal + " not found in DLL!");
            return head;
        }

        Node newNode = new Node(newVal);

        newNode.next = curr.next;
        newNode.prev = curr;

        if (curr.next != null) {
            curr.next.prev = newNode;
        }
        curr.next = newNode;

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

        Node head = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(40);
        Node n4 = new Node(50);

        head.next = n2; n2.prev = head;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;

        System.out.print("Original DLL: ");
        printList(head);

        System.out.println("Inserting 30 after key 20:");
        head = insertAfterKey(head, 20, 30);
        printList(head);
    }
}
