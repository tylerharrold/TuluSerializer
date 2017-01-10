package serializer.fields;

import serializer.Types;
import serializer.DataSerializer;

public class TuluFieldInt extends TuluField{

	
	public TuluFieldInt(String name, int data){
		super(name);
		type = Types.INTEGER;
		
		this.data = new byte[Types.getTypeByteSize(Types.INTEGER)];
		DataSerializer.writeBytes(this.data, 0 , data);
		
	}
	

}
