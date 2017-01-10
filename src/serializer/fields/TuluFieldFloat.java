package serializer.fields;

import serializer.DataSerializer;
import serializer.Types;

public class TuluFieldFloat extends TuluField{
	public TuluFieldFloat(String name, float data){
		super(name);
		type = Types.FLOAT;
		
		this.data = new byte[Types.getTypeByteSize(Types.FLOAT)];
		DataSerializer.writeBytes(this.data, 0 , data);
	}
}
