package serializer.arrays;

import serializer.DataSerializer;
import serializer.Types;

public class TuluArrayByte extends TuluArray{
	public TuluArrayByte(String name, byte[] data){
		super(name);
		this.type = Types.BYTE;
		this.data = new byte[Types.getTypeByteSize(Types.BYTE) * data.length];
		DataSerializer.writeBytes(this.data, 0, data);
	}
}
