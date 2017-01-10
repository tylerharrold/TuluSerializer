package serializer.arrays;

import serializer.DataSerializer;
import serializer.Types;

public class TuluArrayInt extends TuluArray{
	public TuluArrayInt(String name, int[] data){
		super(name);
		this.type = Types.INTEGER;
		this.data = new byte[Types.getTypeByteSize(Types.INTEGER) * data.length];
		DataSerializer.writeBytes(this.data, 0, data);
	}
}
