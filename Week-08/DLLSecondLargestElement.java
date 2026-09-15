public class DLLSecondLargestElement {
    static class Node {
        int val;
        Node prev, next;
        Node(int val) {
            this.val = val;
        }
    }

    public static int findSecondLargest(Node head) {
        if (head == null || head.next == null) {
            throw new IllegalArgumentException("DLL must have at least 2 nodes");
        }

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        Node curr = head;

        while (curr != null) {
            if (curr.val > firstMax) {
                secondMax = firstMax;
                firstMax = curr.val;
            } else if (curr.val > secondMax && curr.val < firstMax) {
                secondMax = curr.val;
            }
            curr = curr.next;
        }

        if (secondMax == Integer.MIN_VALUE) {
            throw new RuntimeException("No distinct second largest element exists.");
        }

        return secondMax;
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

        Node head = new Node(12);
        Node n2 = new Node(35);
        Node n3 = new Node(1);
        Node n4 = new Node(10);
        Node n5 = new Node(34);
        Node n6 = new Node(1);

        head.next = n2; n2.prev = head;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;
        n4.next = n5; n5.prev = n4;
        n5.next = n6; n6.prev = n5;

        System.out.print("DLL elements: ");
        printList(head);

        int secondLargest = findSecondLargest(head);
        System.out.println("Second largest element: " + secondLargest);
    }
}
