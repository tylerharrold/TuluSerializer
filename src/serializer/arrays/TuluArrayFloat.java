package serializer.arrays;

import serializer.DataSerializer;
import serializer.Types;

public class TuluArrayFloat extends TuluArray{
	public TuluArrayFloat(String name, float[] data){
		super(name);
		this.type = Types.FLOAT;
		this.data = new byte[Types.getTypeByteSize(Types.FLOAT) * data.length];
		DataSerializer.writeBytes(this.data, 0, data);
	}
}
