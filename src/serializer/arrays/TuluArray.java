package serializer.arrays;

import java.io.UnsupportedEncodingException;

import serializer.ContainerType;
import serializer.DataSerializer;
import serializer.Types;

public abstract class TuluArray {
	
	// constructor to set up
	
	// type of container
	public static final byte CONTAINER_TYPE = ContainerType.ARRAY;
	// length of name of container
	private short fieldNameLength;
	// name of container
	private byte[] fieldName;
	// type of data
	protected byte type;
	// actual data
	protected byte[] data;
	
	// constructor to set up
	public TuluArray(String fieldName){
		fieldNameLength = (short)(fieldName.length());
		try {
			this.fieldName = fieldName.getBytes(Types.CHARSET);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// method that takes in a primitive and writes it into data byte array (using DataSerializer.java)
	
	// method that reports the current size of this entire container in bytes
	public int getSize(){
		return 1 + 2 + fieldName.length + 1 + data.length;
	}
	// method that writes out entire container to byte array
	public int writeBytes(byte[] dest , int startIndex){
		assert(startIndex + getSize() < dest.length); // ensure no error for now
		startIndex = DataSerializer.writeBytes(dest, startIndex, CONTAINER_TYPE);
		startIndex = DataSerializer.writeBytes(dest, startIndex, fieldNameLength);
		startIndex = DataSerializer.writeBytes(dest, startIndex, fieldName);
		startIndex = DataSerializer.writeBytes(dest, startIndex, type);
		startIndex = DataSerializer.writeBytes(dest, startIndex, data);
		return startIndex;
	}
	
	// static method that constructs a container from a given array of bytes
}
