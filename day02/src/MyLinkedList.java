public class MyLinkedList<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size;

	private class Node<T> {
		T val;
		Node<T> prev;
		Node<T> next;

		private Node(T d, Node<T> prev, Node<T> next) {
			this.val = d;
			this.prev = prev;
			this.next = next;
		}
	}

	public MyLinkedList() {
		this.head = null;
        this.tail = null;
        this.size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(T c) {
		addLast(c);
	}

	public T pop() {
		return removeLast();
	}

	public void addLast(T c) {
        if (this.isEmpty()) {
            Node<T> cNode = new Node<T>(c, null, null);
            this.head = cNode;
            this.tail = cNode;
        } else {
            Node<T> cNode = new Node<T>(c, this.tail, null);
            this.tail.next = cNode;
            this.tail = cNode;
        }

        this.size++;
	}

	public void addFirst(T c) {
		if (this.isEmpty()) {
			Node<T> cNode = new Node<T>(c, null, null);
			this.head = cNode;
			this.tail = cNode;
		} else {
			Node<T> cNode = new Node<T>(c, null, this.head);
			this.head.prev = cNode;
			this.head = cNode;
		}

		this.size++;
	}

	private Node<T> getNode(int index) {
		if (index >= this.size) {
			throw new IndexOutOfBoundsException("Cannot get at index out of bounds.");
		}

		Node<T> nodeAtIndex = this.head;
		int i = 0;
		while (i < index) {
			i++;
			nodeAtIndex = nodeAtIndex.next;
		}

		return nodeAtIndex;
	}

	public T get(int index) {
		Node<T> nodeAtIndex = this.getNode(index);
		return nodeAtIndex.val;
	}

	public T remove(int index) {
		Node<T> nodeAtIndex = this.getNode(index);

		if (nodeAtIndex.prev != null) {
			nodeAtIndex.prev.next = nodeAtIndex.next;
		}
		if (nodeAtIndex.next != null) {
			nodeAtIndex.next.prev = nodeAtIndex.prev;
		}

		this.size--;
		return nodeAtIndex.val;
	}

	public T removeFirst() {
		if (this.size == 0) {
			throw new IndexOutOfBoundsException("Cannot remove first item in empty list.");
		}
		Node<T> oldHead = this.head;
		this.head = this.head.next;
		this.size--;
		return oldHead.val;
	}

	public T removeLast() {
		if (this.size == 0) {
			throw new IndexOutOfBoundsException("Cannot remove last item in empty list.");
		}
		Node<T> oldTail = this.tail;
		this.tail = this.tail.prev;
		this.size--;
		return oldTail.val;
	}
}
