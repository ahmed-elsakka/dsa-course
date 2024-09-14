class MaxHeap:
    def __init__(self):
        self.heap = []

    def pop(self):
        if len(self.heap) == 0:
            return None

        if len(self.heap) == 1:
            return self.heap.pop()

        max_value = self.heap[0]
        self.heap[0] = self.heap.pop()
        self._heapify_down()

        return max_value

    def _heapify_down(self):
        current = 0
        while True:
            left_child_index = self._get_left_child_index(current)
            right_child_index = self._get_right_child_index(current)
            largest = current

            if (
                left_child_index < len(self.heap)
                and self.heap[left_child_index] > self.heap[largest]
            ):
                largest = left_child_index

            if (
                right_child_index < len(self.heap)
                and self.heap[right_child_index] > self.heap[largest]
            ):
                largest = right_child_index

            if largest != current:
                self._swap(current, largest)
                current = largest
            else:
                break

    def insert(self, value):
        self.heap.append(value)
        self._heapify_up()

    def _heapify_up(self):
        current_index = len(self.heap) - 1
        while current_index > 0:
            parent_index = self._get_parent_index(current_index)
            if self.heap[current_index] > self.heap[parent_index]:
                self._swap(current_index, parent_index)
                current_index = parent_index
            else:
                break

    def _swap(self, i, j):
        self.heap[i], self.heap[j] = self.heap[j], self.heap[i]

    @staticmethod
    def _get_left_child_index(self, index):
        return (index * 2) + 1

    @staticmethod
    def _get_right_child_index(self, index):
        return (index * 2) + 2

    @staticmethod
    def _get_parent_index(self, index):
        return (index - 1) // 2

