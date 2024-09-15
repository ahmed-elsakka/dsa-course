public class MaxHeap {
    private int[] heap;
    private int size;
    private int maxSize;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[maxSize];
    }

    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos) + 1;
    }

    private int rightChild(int pos) {
        return (2 * pos) + 2;
    }

    private boolean isLeaf(int pos) {
        return pos >= size / 2 && pos <= size;
    }

    private void swap(int fpos, int spos) {
        int temp;
        temp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = temp;
    }

    private void heapifyDown(int pos) {
        while (!isLeaf(pos)) {
            int left = leftChild(pos);
            int right = rightChild(pos);
            int largest = pos;

            if (left < size && heap[left] > heap[largest])
                largest = left;

            if (right < size && heap[right] > heap[largest])
                largest = right;

            if (largest != pos) {
                swap(pos, largest);
                pos = largest;
            } else {
                break; 
            }
        }
    }


    public void insert(int element) {
        if (size >= maxSize) {
            System.out.println("Heap is full.");
            return;
        }

        int current = size;
        heap[current] = element;

        while (current != 0 && heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }

        size++;
    }

    public void print() {
        for (int i = 0; i < size / 2; i++) {
            System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " + heap[leftChild(i)]
                    + " RIGHT CHILD :" + heap[rightChild(i)]);
            System.out.println();
        }
    }

    public int remove() {
        if (size == 0)
            return Integer.MIN_VALUE;

        int popped = heap[0]; 
        heap[0] = heap[--size];
        heapifyDown(0);
        return popped;
    }
}
