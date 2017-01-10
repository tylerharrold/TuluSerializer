package serializer.arrays;

import serializer.DataSerializer;
import serializer.Types;

public class TuluArrayChar extends TuluArray{
	public TuluArrayChar(String name, char[] data){
		super(name);
		this.type = Types.CHAR;
		this.data = new byte[Types.getTypeByteSize(Types.CHAR) * data.length];
		DataSerializer.writeBytes(this.data, 0, data);
	}
}
