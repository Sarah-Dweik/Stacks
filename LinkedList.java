package components;

//I have made it implements comparable becuase I want the data type of the node be a linkedList
public class LinkedList<T extends Comparable<T>> implements Comparable<LinkedList<T>>{
	public Node head;
	public Node dummy = new Node(null); // avoid null pointer exception, has no data in it

	public LinkedList() {
		head = dummy;
	}

	// list length
	public int length() {
		Node curr;
		curr = head;
		int len = 0;
		while (curr != null) {
			len++;
			curr = curr.getNext();
		}
		return len - 1; // dummy is not counted
	}

	// Insertsorted a Node to the list, one case because of dummyhead
	public void insertSorted(T data) {
		Node<T> newNode = new Node<>(data);
		Node<T> curr = head;
		Node<T> prev = dummy;

		while (curr != null) {
			if (curr.getData() == null) {
				newNode.setNext(prev.getNext());
				prev.setNext(newNode);
				return; // Inserted the node, exit the method
			} else if (curr.getData().compareTo(newNode.getData()) < 0) {
				newNode.setNext(curr);
				prev.setNext(newNode);
				return; // Inserted the node, exit the method
			}

			prev = curr;
			curr = curr.getNext();
		}

		// If we reached here, the new node should be inserted at the end
		prev.setNext(newNode);
	}

	public boolean search(T data) {
		Node curr;
		curr = head;
		while (curr != null) {
			if (curr.getData() == null && curr.getNext() != null) {
				curr = curr.getNext();
			} else if (curr.getData().equals(data)) {
				return true;
			} else
				curr = curr.getNext();
		}
		return false;

	}

	public void insertFirst(T data) {
		Node newnode = new Node(data);
		if (dummy.getNext() == null) {
			dummy.setNext(newnode);
		} else {
			newnode.setNext(dummy.getNext());
			dummy.setNext(newnode);
		}
	}

	public void traverse() {
		Node curr = head;
		while (curr != null) {
			if (curr.getData() == null & curr.getNext() != null) {
				curr = curr.getNext();
			} else {
				System.out.println(curr.toString());
				curr = curr.getNext();
			}
		}
	}

	public void delete(T data) {
		Node curr = head;
		Node prev = dummy;
		while (curr != null) {
			if (curr.getData() == null && curr.getNext() != null) {
				prev = curr;
				curr = curr.getNext();
			} else if (curr.getData() != null && curr.getData().equals(data)) {
				prev.setNext(curr.getNext());
				curr = curr.getNext();
			} else {
				prev = curr;
				curr = curr.getNext();
			}
		}
	}


	@Override
	public int compareTo(LinkedList<T> other) {
        int thisLength = this.length();
        int otherLength = other.length();

        return Integer.compare(thisLength, otherLength);
    }

	
}
