import java.util.NoSuchElementException;

public class Queue<T> {
	private static class Node<T> {
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	public void enqueue(T data) {
		Node<T> newNode = new Node<>(data);
		if (tail == null) {
			head = newNode;
		} else {
			tail.next = newNode;
		}
		tail = newNode;
		size++;
	}

	public T dequeue() {
		if(isEmpty()) {
			throw new NoSuchElementException("Queue is empty");
		}
		T data = head.data;
		head = head.next;
		if (head == null) {
			tail = null;
		}
		size--;
		return data;
	}
}
