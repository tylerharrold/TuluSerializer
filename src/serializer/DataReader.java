package serializer;
import static serializer.Types.*;

import java.nio.ByteBuffer;

/**
 * Class for reading types from a byte array
 * @author Tyler
 *
 */
public class DataReader {
	
	// byte
	public static Byte readByte(byte[] data, int pointer){
		return ByteBuffer.wrap(data, pointer, getTypeByteSize(BYTE)).get();
	}
	
	// boolean
	
	// short
	public static Short readShort(byte[] data, int pointer){
		return ByteBuffer.wrap(data, pointer, 2).getShort();
	}
	
	// int 
	
	// long
	
	// float
	
	// double
	
	// String
//	public static String readString(byte[] data, int pointer){
//		short 
//	}
	
}
