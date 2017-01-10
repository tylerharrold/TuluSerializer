package serializer;
import static serializer.Types.*;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/**
 * Class for reading types from a byte array
 * @author Tyler
 *
 */
public class DataReader {
	
	// byte reader
	public static byte readByte(byte[] data, int pointer){
		return ByteBuffer.wrap(data, pointer, getTypeByteSize(BYTE)).get();
	}
	
	// boolean reader
	public static boolean readBoolean(byte[] data, int pointer){
		return ByteBuffer.wrap(data, pointer, getTypeByteSize(BOOLEAN)).get() == 1;
	}
	
	// short reader
	public static short readShort(byte[] data, int pointer){
		return ByteBuffer.wrap(data, pointer, getTypeByteSize(SHORT)).getShort();
	}
	
	// char reader
	public static char readChar(byte[] data, int pointer){
		return ByteBuffer.wrap(data, pointer, getTypeByteSize(CHAR)).getChar();
	}
	
	// int 
	public static int readInt(byte[] data, int pointer){
		return ByteBuffer.wrap(data, pointer, getTypeByteSize(INTEGER)).getInt();
	}
	
	// long reader
	public static long readLong(byte[] data, int pointer){
		return ByteBuffer.wrap(data, pointer, getTypeByteSize(LONG)).getLong();
	}
	
	
	// float reader
	public static float readFloat(byte[] data, int pointer){
		return ByteBuffer.wrap(data, pointer, getTypeByteSize(FLOAT)).getFloat();
	}
	
	// double reader
	public static double readDouble(byte[] data, int pointer){
		return ByteBuffer.wrap(data, pointer, getTypeByteSize(DOUBLE)).getDouble();
	}
	
	// String
	public static String readString(byte[] data, int pointer) throws UnsupportedEncodingException{
		short length = readShort(data, pointer);
		pointer+=2; // advance for short
		
		return new String(data, pointer, length * getTypeByteSize(CHAR) , CHARSET);
	}
	
}
