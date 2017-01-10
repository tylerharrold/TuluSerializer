package serializer.arrays;

import serializer.DataSerializer;
import serializer.Types;

public class TuluArrayBoolean extends TuluArray{
	public TuluArrayBoolean(String name, boolean[] data){
		super(name);
		this.type = Types.BOOLEAN;
		this.data = new byte[Types.getTypeByteSize(Types.BOOLEAN) * data.length];
		DataSerializer.writeBytes(this.data, 0, data);
	}
}
