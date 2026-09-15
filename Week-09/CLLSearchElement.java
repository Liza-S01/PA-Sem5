public class CLLSearchElement {
    static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    public static int search(Node head, int target) {
        if (head == null) return -1;

        Node curr = head;
        int index = 0;

        do {
            if (curr.val == target) {
                return index;
            }
            curr = curr.next;
            index++;
        } while (curr != head);

        return -1;
    }

    public static void main(String[] args) {
        Node head = new Node(15);
        Node n2 = new Node(25);
        Node n3 = new Node(35);
        Node n4 = new Node(45);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = head;

        int target1 = 35;
        System.out.println("Searching for " + target1 + ": Index = " + search(head, target1));

        int target2 = 99;
        System.out.println("Searching for " + target2 + ": Index = " + search(head, target2));
    }
}
