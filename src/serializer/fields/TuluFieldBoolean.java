package serializer.fields;

import serializer.DataSerializer;
import serializer.Types;

public class TuluFieldBoolean extends TuluField{
	public TuluFieldBoolean(String name , boolean data){
		super(name);
		type = Types.BOOLEAN;
		this.data = new byte[Types.getTypeByteSize(Types.BOOLEAN)];
		DataSerializer.writeBytes(this.data, 0 , data);
	}
}
