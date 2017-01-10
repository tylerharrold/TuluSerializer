package serializer.objects;

import java.io.UnsupportedEncodingException;

import serializer.ContainerType;
import serializer.DataSerializer;
import serializer.Types;
import serializer.arrays.TuluArray;
import serializer.datastructures.TContainer;
import serializer.datastructures.TStack;
import serializer.fields.TuluField;

public class TuluObject implements TContainer{
	
	// type of container
	public static final byte CONTAINER_TYPE = ContainerType.OBJECT;
	// length of name of container
	private short objectNameLength;
	// name of container
	private byte[] objectName;
	// array list of tulufields
	private int tFieldCount;
	private TStack<TuluField> tFields;
	// array list of tuluarrays
	private int tArrayCount;
	private TStack<TuluArray> tArrays;
	// actual data of tuluobjects
	private int tObjectCount;
	private TStack<TuluObject> tObjects;
	
	// constructor to set up
	public TuluObject(String objectName){
		objectNameLength = (short)(objectName.length());
		try {
			this.objectName = objectName.getBytes(Types.CHARSET);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tFields = new TStack<TuluField>();
		tArrays = new TStack<TuluArray>();
		tObjects = new TStack<TuluObject>();
		
	}
	
	public void addField(TuluField field){
		tFields.push(field);
		tFieldCount++;
	}
	
	public void addArray(TuluArray array){
		tArrays.push(array);
		tArrayCount++;
	}
	
	public void addObject(TuluObject object){
		tObjects.push(object);
		tObjectCount++;
	}
	
	// method that reports the current size of this entire container in bytes
	public int getByteSize(){
		return 1 + 2 + objectName.length +  
				4 + tFields.getTotalByteSize() + 
				4 + tArrays.getTotalByteSize() +
				4 + tObjects.getTotalByteSize();	
	}
	
	// method that writes out entire container to byte array
	@Override
	public int writeBytes(byte[] dest , int startIndex){
		startIndex = DataSerializer.writeBytes(dest, startIndex, CONTAINER_TYPE);
		startIndex = DataSerializer.writeBytes(dest, startIndex, objectNameLength);
		startIndex = DataSerializer.writeBytes(dest, startIndex, objectName);
		startIndex = DataSerializer.writeBytes(dest, startIndex, tFieldCount);
		startIndex = tFields.writeBytes(dest, startIndex);
		startIndex = DataSerializer.writeBytes(dest, startIndex, tArrayCount);
		startIndex = tArrays.writeBytes(dest, startIndex);
		startIndex = DataSerializer.writeBytes(dest, startIndex, tObjectCount);
		startIndex = tObjects.writeBytes(dest, startIndex);
		return startIndex;
		
	}
	
	// static method that constructs a container from a given array of bytes
}
