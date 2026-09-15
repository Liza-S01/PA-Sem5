public class CLLCountNodes {
    static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    public static int countNodes(Node head) {
        if (head == null) return 0;

        int count = 0;
        Node curr = head;

        do {
            count++;
            curr = curr.next;
        } while (curr != head);

        return count;
    }

    public static void main(String[] args) {

        Node head = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = head;

        System.out.println("Total nodes in CLL: " + countNodes(head));

        System.out.println("Total nodes in empty CLL: " + countNodes(null));
    }
}
