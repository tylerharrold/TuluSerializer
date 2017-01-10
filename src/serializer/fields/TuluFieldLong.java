package serializer.fields;

import serializer.DataSerializer;
import serializer.Types;

public class TuluFieldLong extends TuluField{
	public TuluFieldLong(String name, long data){
		super(name);
		type = Types.LONG;
		
		this.data = new byte[Types.getTypeByteSize(Types.LONG)];
		DataSerializer.writeBytes(this.data, 0 , data);
	}
}
