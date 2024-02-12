package stacks;

import components.FineCursorArray;

public class CStack<T extends Comparable<T>> implements Stackable<T> {

	FineCursorArray list = new FineCursorArray();
	int top;

	public CStack() {
		list.initializer();
		top = list.createList();
	}

	@Override
	public void push(T data) {
		list.insertFirst(data, top);

	}

	@Override
	public T pop() {
		if (!isEmpty()) {
			T toDel = (T) list.firstElement(top);
			list.deleteFirst(top);
			return toDel;
		}
		return null;
	}

	@Override
	public T peek() {

		if (!isEmpty()) {
			T first = (T) list.firstElement(top);
			return first;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		if (list.isEmpty(top) == true) {
			return true;
		}
		return false;
	}

	@Override
	public void clear() {
		if (!isEmpty()) {

		}
	}

}
