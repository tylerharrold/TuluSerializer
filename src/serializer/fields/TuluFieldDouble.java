package serializer.fields;

import serializer.DataSerializer;
import serializer.Types;

public class TuluFieldDouble extends TuluField{
	public TuluFieldDouble(String name, Double data){
		super(name);
		type = Types.DOUBLE;
		
		this.data = new byte[Types.getTypeByteSize(Types.DOUBLE)];
		DataSerializer.writeBytes(this.data, 0 , data);
	}
}
