package serializer.fields;

import serializer.DataSerializer;
import serializer.Types;

public class TuluFieldShort extends TuluField{
	public TuluFieldShort(String name, short data){
		super(name);
		type = Types.SHORT;
		
		this.data = new byte[Types.getTypeByteSize(Types.SHORT)];
		DataSerializer.writeBytes(this.data, 0 , data);
	}
}
