package serializer.fields;

import java.io.UnsupportedEncodingException;
import serializer.DataSerializer;
import serializer.DataSerializer;

import serializer.ContainerType;
import serializer.DataReader;
import serializer.Types;

public abstract class TuluField {
	// type of container
	public static final byte CONTAINER_TYPE = ContainerType.FIELD;
	// length of name of container
	private short fieldNameLength;
	// name of container
	private byte[] fieldName;
	// type of data
	protected byte type;
	// actual data
	protected byte[] data;
	
	// constructor to set up
	public TuluField(String fieldName){
		fieldNameLength = (short)(fieldName.length());
		try {
			this.fieldName = fieldName.getBytes(Types.CHARSET);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// method that reports the current size of this entire container in bytes
	public int getSize(){
		return 1 + 2 + fieldName.length + 1 + data.length;
	}
	
	// method that writes out entire container to byte array
	public int writeBytes(byte[] dest, int startIndex){
		assert(startIndex + getSize() < dest.length); // ensure no error for now
		startIndex = DataSerializer.writeBytes(dest, startIndex, CONTAINER_TYPE);
		startIndex = DataSerializer.writeBytes(dest, startIndex, fieldNameLength);
		startIndex = DataSerializer.writeBytes(dest, startIndex, fieldName);
		startIndex = DataSerializer.writeBytes(dest, startIndex, type);
		startIndex = DataSerializer.writeBytes(dest, startIndex, data);
		return startIndex;
		
		
	}
	
	// static method that constructs a container from a given array of bytes
//	public static TuluField constructField(byte[] src , int startingIndex){
//		int myIndex = startingIndex;
//		if(DataReader.readInt(src, startingIndex) != CONTAINER_TYPE){
//			// horrible error, should probably thow exception
//			// TODO throw exception
//		}
//		else{
//			myIndex++;
//		}
//		int nameLen = DataReader.readShort(src, myIndex);
//		try {
//			String name = DataReader.readString(src, myIndex);
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		myIndex = myIndex + 2 + nameLen * 2;
//		byte type = DataReader.readByte(src, myIndex++);
//		
//		// crude
//		switch(type){
//			case BYTE: 
//					myInde;
//			case BOOLEAN: return Byte.SIZE / BITS_PER_BYTE;
//			case SHORT: return Short.SIZE / BITS_PER_BYTE;
//			case CHAR: return Character.SIZE / BITS_PER_BYTE;
//			case INTEGER: return Integer.SIZE / BITS_PER_BYTE;
//			case LONG: return Long.SIZE / BITS_PER_BYTE;
//			case FLOAT: return Float.SIZE / BITS_PER_BYTE;
//			case DOUBLE: return Double.SIZE / BITS_PER_BYTE;
//		}
//		
//	}
	
}
