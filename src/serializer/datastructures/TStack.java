package serializer.datastructures;

import serializer.DataSerializer;

public class TStack<T> implements TCollection<T>{

	private TNode head;
	private int size;
	
	public TStack(){
		head = null;
		size = 0;
	}
	
	
	@Override
	public void push(T addition) {
		TNode newNode = new TNode((TContainer)addition, head);
		head = newNode;
		size++;
		
	}

	@Override
	public T pop() throws EmptyCollectionException{
		if(isEmpty()){
			throw new EmptyCollectionException("Attempted pop from empty collection");
		}
		TNode currentHead = head;
		TContainer returnObj = currentHead.getItem();
		head = currentHead.getNext();
		currentHead.setNext(null);
		size--;
		
		return (T)returnObj;
		
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}


	@Override
	public int getTotalByteSize() {
		int byteSize = 0;
		TNode current = head;
		while(current!=null){
			byteSize+=current.getItem().getByteSize();
			current = current.getNext();
		}
		return byteSize;
	}


	@Override
	public int writeBytes(byte[] dest, int startIndex) {
		TNode current = head;
		while(current!=null){
			startIndex = current.getItem().writeBytes(dest, startIndex);
			current = current.getNext();
		}
		return startIndex;
	}
	
}
