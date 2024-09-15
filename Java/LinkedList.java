class Node {
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Method to insert a new node at the beginning of the list
    public void prepend(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // Method to insert a new node at the end of the list
    public void append(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // Method to remove a node from the list
    public void remove(String data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                if (current.next == null) {
                    tail = current;
                }
                return;
            }
            current = current.next;
        }
    }

    // Method to print the elements of the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

