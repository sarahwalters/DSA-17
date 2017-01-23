public class MyArrayList {
    private Cow[] elems;
	private int size;
	private final int LOWERLIMIT = 10;

	public MyArrayList() {
		elems = new Cow[LOWERLIMIT];
		size = 0;
	}

	public MyArrayList(int capacity) {
		elems = new Cow[capacity];
		size = 0;
	}

	public void add(Cow c) {
		elems[size] = c;
		size++;
		resize();
	}

	public int size() {
		return size;
	}

	public Cow get(int index) {
		if (index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}
		return elems[index];
	}

	public Cow remove(int index) {
		Cow removed = elems[index];
		System.arraycopy(elems, index, elems, index - 1, size);
		elems[size - 1] = null;
		size--;
		resize();
		return removed;
	}

	public void add(int index, Cow c) {
		if (index > size) {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}
		System.arraycopy(elems, index, elems, index + 1, size);
		elems[index] = c;
		size++;
		resize();
	}

	private void resize() {
		if (size * 4 < elems.length || size == elems.length) {
			int newSize = Math.max(size * 2, LOWERLIMIT);
			Cow[] newElems = new Cow[newSize];
			System.arraycopy(elems, 0, newElems, 0, size);
			elems = newElems;
		}
	}
}
