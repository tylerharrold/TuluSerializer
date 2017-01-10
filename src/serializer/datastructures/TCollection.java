package serializer.datastructures;

public interface TCollection<T> {
	public void push(T addition);
	public T pop() throws EmptyCollectionException;
	public int size();
	public boolean isEmpty();
	public int getTotalByteSize();
	public int writeBytes(byte[] dest, int startIndex);
}
