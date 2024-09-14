class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None


class DoublyLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None

    def append(self, data):
        new_node = Node(data)
        if self.tail is None:
            self.head = new_node
            self.tail = new_node
            return
        self.tail.next = new_node
        new_node.prev = self.tail
        self.tail = new_node

    def prepend(self, data):
        new_node = Node(data)
        if self.head is None:
            self.head = new_node
            self.tail = new_node
            return
        self.head.prev = new_node
        new_node.next = self.head
        self.head = new_node

    def delete(self, key):
        current_node = self.head
        while current_node:
            if current_node.data == key:
                if current_node.prev:
                    current_node.prev.next = current_node.next
                else:
                    self.head = current_node.next
                if current_node.next:
                    current_node.next.prev = current_node.prev
                if current_node == self.tail:
                    self.tail = current_node.prev
                return
            current_node = current_node.next

    def print_list(self):
        current_node = self.head
        while current_node:
            print(current_node.data, end=" ")
            current_node = current_node.next
        print()


class CursorDLL(DoublyLinkedList):
    def __init__(self):
        super().__init__()
        self.cursor = self.head

    def move_cursor_forward(self):
        if self.cursor is None or self.cursor.next is None:
            return
        self.cursor = self.cursor.next

    def move_cursor_backward(self):
        if self.cursor is None or self.cursor.prev is None:
            return
        self.cursor = self.cursor.prev

    def print_list_with_cursor(self):
        current_node = self.head
        while current_node:
            if current_node == self.cursor:
                print("[{}]".format(current_node.data), end=" ")
            else:
                print(current_node.data, end=" ")
            current_node = current_node.next
        print()

    def append(self, data):
        super().append(data)
        if self.cursor is None:
            self.cursor = self.tail

    def prepend(self, data):
        super().prepend(data)
        if self.cursor is None:
            self.cursor = self.head

