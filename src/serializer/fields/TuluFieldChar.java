package serializer.fields;

import serializer.DataSerializer;
import serializer.Types;

public class TuluFieldChar extends TuluField{
	public TuluFieldChar(String name , char data){
		super(name);
		type = Types.CHAR;
		
		this.data = new byte[Types.getTypeByteSize(Types.CHAR)];
		DataSerializer.writeBytes(this.data, 0 , data);
	}
}
