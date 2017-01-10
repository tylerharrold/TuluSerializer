package serializer.fields;

import serializer.DataSerializer;
import serializer.Types;

public class TuluFieldByte extends TuluField{
	public TuluFieldByte(String name, Byte data){
		super(name);
		type = Types.BYTE;
		
		this.data = new byte[Types.getTypeByteSize(Types.BYTE)];
		DataSerializer.writeBytes(this.data, 0 , data);
	}
}
