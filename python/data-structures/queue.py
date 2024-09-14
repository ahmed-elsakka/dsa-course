class Node:
    def __init__(self, value):
        self.value = value
        self.next = None


class Queue:
    def __init__(self):
        self.front = None
        self.back = None
        self.size = 0

    def is_empty(self):
        return self.size == 0

    def enqueue(self, value):
        new_node = Node(value)
        if self.is_empty():
            self.front = self.back = new_node
        else:
            self.back.next = new_node
            self.back = new_node
        self.size += 1

    def dequeue(self):
        if not self.is_empty():
            removed_item = self.front.value
            self.front = self.front.next
            self.size -= 1
            if self.is_empty():
                self.back = None
            return removed_item
        else:
            print("Queue is empty")


print_queue = Queue()
print_queue.enqueue("Document1.pdf")
print_queue.enqueue("Document2.pdf")
print_queue.enqueue("Document3.pdf")

while not print_queue.is_empty():
    document = print_queue.dequeue()
    print("Printing: ", document)