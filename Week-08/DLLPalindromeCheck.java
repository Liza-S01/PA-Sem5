public class DLLPalindromeCheck {
    static class Node {
        char val;
        Node prev, next;
        Node(char val) {
            this.val = val;
        }
    }

    public static boolean isPalindromeDLL(Node head) {
        if (head == null || head.next == null) return true;

        Node left = head;
        Node right = head;
        while (right.next != null) {
            right = right.next;
        }

        while (left != right && left.prev != right) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.prev;
        }

        return true;
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

        Node h1 = new Node('R');
        Node n2 = new Node('A');
        Node n3 = new Node('D');
        Node n4 = new Node('A');
        Node n5 = new Node('R');

        h1.next = n2; n2.prev = h1;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;
        n4.next = n5; n5.prev = n4;

        System.out.print("DLL 1: ");
        printList(h1);
        System.out.println("Is Palindrome? " + isPalindromeDLL(h1));

        Node h2 = new Node('H');
        Node m2 = new Node('E');
        Node m3 = new Node('L');
        h2.next = m2; m2.prev = h2;
        m2.next = m3; m3.prev = m2;

        System.out.print("\nDLL 2: ");
        printList(h2);
        System.out.println("Is Palindrome? " + isPalindromeDLL(h2));
    }
}
