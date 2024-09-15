class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    protected Node head;
    protected Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void prepend(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    public void delete(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                return;
            }
            current = current.next;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

}

class CursorDoublyLinkedList extends DoublyLinkedList {
    private Node cursor; // Cursor node

    public CursorDoublyLinkedList() {
        super();
        this.cursor = this.head;
    }

    public void moveCursorForward() {
        if (cursor != null && cursor.next != null) {
            cursor = cursor.next;
        }
    }

    public void moveCursorBackward() {
        if (cursor != null && cursor.prev != null) {
            cursor = cursor.prev;
        }
    }

    public void printListWithCursor() {
        Node current = head;
        while (current != null) {
            if (current == cursor) {
                System.out.print("[" + current.data + "] ");
            } else {
                System.out.print(current.data + " ");
            }
            current = current.next;
        }
        System.out.println();
    }

    @Override
    public void append(int data) {
        super.append(data);
        if (cursor == null) {
            cursor = tail;
        }
    }

    @Override
    public void prepend(int data) {
        super.prepend(data);
        if (cursor == null) {
            cursor = head;
        }
    }
}


public class Main {
    public static void main(String[] args) {
        // Create a new CursorDoublyLinkedList
        CursorDoublyLinkedList list = new CursorDoublyLinkedList();

        // Append some elements to the list
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        // Print the list with the cursor
        System.out.println("List with cursor:");
        list.printListWithCursor(); // [1] 2 3 4

        // Move the cursor forward and print the updated list
        System.out.println("List after moving cursor forward:");
        list.moveCursorForward();
        list.printListWithCursor(); // 1 [2] 3 4

        // Insert an element after the cursor
        list.insertAfterCursor(5);
        list.printListWithCursor(); // 1 [2] 5 3 4

        // Move the cursor backward and print the updated list
        System.out.println("List after moving cursor backward:");
        list.moveCursorBackward();
        list.printListWithCursor(); // 1 [2] 5 3 4

        // Delete the element at the cursor position
        list.delete(2);
        list.printListWithCursor(); // 1 [5] 3 4
    }
}
