package serializer.arrays;

import serializer.DataSerializer;
import serializer.Types;

public class TuluArrayShort extends TuluArray{
	public TuluArrayShort(String name, short[] data){
		super(name);
		this.type = Types.SHORT;
		this.data = new byte[Types.getTypeByteSize(Types.SHORT) * data.length];
		DataSerializer.writeBytes(this.data, 0, data);
	}
}
