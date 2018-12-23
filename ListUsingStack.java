package lab7;

import java.util.Stack;

public class ListUsingStack<T> implements ListInterface<T> {

	private Stack<T> myStack;
	private int myNumEntries;

	public ListUsingStack() {

		myStack = new Stack<T>();
		myNumEntries = 0;
	}

	@Override
	public void add(T newEntry) {

		myStack.push(newEntry);
		myNumEntries++;

	}

	@Override
	public void add(int newPosition, T newEntry) {

		if (newPosition < 1 || newPosition > getLength() + 1) {

			throw new IndexOutOfBoundsException("you really messed up now");

		} else if (newPosition == getLength() + 1) {

			myStack.push(newEntry);
			myNumEntries++;

		} else {

			Stack<T> temp = new Stack<T>();
			int counter = myNumEntries;

			while (counter > newPosition) {

				temp.push(myStack.pop());
				counter--;
			}

			temp.push(myStack.pop());
			myStack.add(newEntry);
			while (!temp.isEmpty()) {

				myStack.push(temp.pop());
			}

			myNumEntries++;
		}

	}

	@Override
	public T remove(int givenPosition) {

		if (givenPosition < 1 || givenPosition > getLength()) {

			throw new IndexOutOfBoundsException("error");

		} else if (givenPosition == myNumEntries) {

			myNumEntries--;
			return (myStack.pop());

		} else {

			Stack<T> tmp = new Stack<T>();
			int counter = myNumEntries;
			while (counter > givenPosition) {

				tmp.push(myStack.pop());
				counter--;
			}

			myNumEntries--;
			T item = myStack.pop();
			while (!tmp.isEmpty()) {

				myStack.push(tmp.pop());
			}

			return item;
		}
	}

	@Override
	public void clear() {

		while (myNumEntries != 0) {

			myStack.pop();
			myNumEntries--;
		}

	}

	@Override
	public T replace(int givenPosition, T newEntry) {

		if (givenPosition < 1 || givenPosition > getLength()) {

			throw new IndexOutOfBoundsException("error");

		} else if (givenPosition == myNumEntries) {

			myNumEntries--;
			return (myStack.pop());

		} else {

			Stack<T> tmp = new Stack<T>();
			int counter = myNumEntries;
			while (counter > givenPosition) {

				tmp.push(myStack.pop());
				counter--;
			}

			myStack.pop();
			T item = myStack.push(newEntry);

			while (!tmp.isEmpty()) {

				myStack.push(tmp.pop());
			}

			return item;
		}
	}

	@Override
	public T getEntry(int givenPosition) {

		if (givenPosition < 1 || givenPosition > getLength()) {

			throw new IndexOutOfBoundsException("error");

		} else if (givenPosition == myNumEntries) {

			myNumEntries--;
			return (myStack.pop());

		} else {

			Stack<T> tmp = new Stack<T>();
			int counter = myNumEntries;
			while (counter > givenPosition) {

				tmp.push(myStack.pop());
				counter--;
			}

			T item = myStack.peek();

			while (!tmp.isEmpty()) {

				myStack.push(tmp.pop());
			}

			return item;
		}
	}

	@Override
	public boolean contains(T anEntry) {

		Stack<T> temp = myStack;
		int counter = myNumEntries;
		while (!myStack.isEmpty()) {
			if (myStack.peek().equals(anEntry)) {
				return true;
			} else {
				myStack.pop();
			}
		}
		return false;
	}

	@Override
	public int getLength() {

		return myNumEntries;
	}

	@Override
	public boolean isEmpty() {

		return (myNumEntries == 0);
	}

}
