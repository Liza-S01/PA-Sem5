public class DoublyLinkedListOperations {
    public static class DLLNode {
        public int val;
        public DLLNode prev;
        public DLLNode next;

        public DLLNode(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    public static class DoublyLinkedList {
        DLLNode head;
        DLLNode tail;
        int size;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public void insertAtHead(int val) {
            DLLNode newNode = new DLLNode(val);
            if (head == null) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            size++;
        }

        public void insertAtTail(int val) {
            DLLNode newNode = new DLLNode(val);
            if (tail == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            size++;
        }

        public void deleteHead() {
            if (head == null) return;
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            size--;
        }

        public void deleteTail() {
            if (tail == null) return;
            if (head == tail) {
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            size--;
        }

        public void printForward() {
            DLLNode curr = head;
            System.out.print("Forward:  [Head] <-> ");
            while (curr != null) {
                System.out.print(curr.val + " <-> ");
                curr = curr.next;
            }
            System.out.println("null");
        }

        public void printBackward() {
            DLLNode curr = tail;
            System.out.print("Backward: [Tail] <-> ");
            while (curr != null) {
                System.out.print(curr.val + " <-> ");
                curr = curr.prev;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        System.out.println("=== Doubly Linked List Operations ===");
        dll.insertAtHead(20);
        dll.insertAtHead(10);
        dll.insertAtTail(30);
        dll.insertAtTail(40);
        dll.printForward();
        dll.printBackward();

        System.out.println("\nDeleting Head and Tail...");
        dll.deleteHead();
        dll.deleteTail();
        dll.printForward();
    }
}
