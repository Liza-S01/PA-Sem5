public class CLLFindMaxElement {
    static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    public static int findMax(Node head) {
        if (head == null) {
            throw new IllegalArgumentException("Circular linked list is empty.");
        }

        int maxVal = head.val;
        Node curr = head.next;

        while (curr != head) {
            if (curr.val > maxVal) {
                maxVal = curr.val;
            }
            curr = curr.next;
        }

        return maxVal;
    }

    public static void main(String[] args) {

        Node head = new Node(45);
        Node n2 = new Node(12);
        Node n3 = new Node(89);
        Node n4 = new Node(34);
        Node n5 = new Node(71);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = head;

        System.out.println("Maximum element in CLL: " + findMax(head));
    }
}
