package serializer.arrays;

import java.io.UnsupportedEncodingException;

import serializer.ContainerType;
import serializer.DataSerializer;
import serializer.Types;
import serializer.datastructures.TContainer;

public abstract class TuluArray implements TContainer{
	
	// constructor to set up
	
	// type of container
	public static final byte CONTAINER_TYPE = ContainerType.ARRAY;
	// length of name of container
	private short arrayNameLength;
	// name of container
	private byte[] arrayName;
	// type of data
	protected byte type;
	// actual data
	protected byte[] data;
	
	// constructor to set up
	public TuluArray(String arrayName){
		arrayNameLength = (short)(arrayName.length());
		try {
			this.arrayName = arrayName.getBytes(Types.CHARSET);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// method that takes in a primitive and writes it into data byte array (using DataSerializer.java)
	
	// method that reports the current size of this entire container in bytes
	@Override
	public int getByteSize(){
		return 1 + 2 + arrayName.length + 1 + data.length;
	}
	// method that writes out entire container to byte array
	@Override
	public int writeBytes(byte[] dest , int startIndex){
		assert(startIndex + getByteSize() < dest.length); // ensure no error for now
		startIndex = DataSerializer.writeBytes(dest, startIndex, CONTAINER_TYPE);
		startIndex = DataSerializer.writeBytes(dest, startIndex, arrayNameLength);
		startIndex = DataSerializer.writeBytes(dest, startIndex, arrayName);
		startIndex = DataSerializer.writeBytes(dest, startIndex, type);
		startIndex = DataSerializer.writeBytes(dest, startIndex, data);
		return startIndex;
	}
	
	// static method that constructs a container from a given array of bytes
}
