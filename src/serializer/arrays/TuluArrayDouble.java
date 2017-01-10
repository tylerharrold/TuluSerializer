package serializer.arrays;

import serializer.DataSerializer;
import serializer.Types;

public class TuluArrayDouble extends TuluArray{
	public TuluArrayDouble(String name, double[] data){
		super(name);
		this.type = Types.DOUBLE;
		this.data = new byte[Types.getTypeByteSize(Types.DOUBLE) * data.length];
		DataSerializer.writeBytes(this.data, 0, data);
	}
}
