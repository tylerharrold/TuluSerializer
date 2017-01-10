package serializer.arrays;

import serializer.DataSerializer;
import serializer.Types;

public class TuluArrayLong extends TuluArray{
	public TuluArrayLong(String name, long[] data){
		super(name);
		this.type = Types.LONG;
		this.data = new byte[Types.getTypeByteSize(Types.LONG) * data.length];
		DataSerializer.writeBytes(this.data, 0, data);
	}
}
