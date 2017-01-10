package serializer.datastructures;

public interface TContainer {
	/**
	 * Returns the size, in bytes of the TContainer in question.
	 * @return
	 */
	public int getByteSize();
	
	/**
	 * Writes the entire container to a byte array
	 */
	public int writeBytes(byte[] dest, int startIndex);
}
