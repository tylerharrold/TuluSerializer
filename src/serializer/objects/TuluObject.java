package serializer.objects;

import java.io.UnsupportedEncodingException;

import serializer.ContainerType;
import serializer.Types;

public class TuluObject {
	// array list of tulufields
	// array list of tuluarrays
	// actual data of tuluobjects
	
	// constructor to set up
	
	// type of container
	public static final byte CONTAINER_TYPE = ContainerType.OBJECT;
	// length of name of container
	private short fieldNameLength;
	// name of container
	private byte[] fieldName;
	// type of data
	protected ArrayList<TuluField> fields;
	// actual data
	protected byte[] data;
	
	// constructor to set up
	public TuluObject(String fieldName){
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
	
	// method that writes out entire container to byte array
	
	// static method that constructs a container from a given array of bytes
}
