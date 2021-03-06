package serializer;
import java.io.UnsupportedEncodingException;
import static serializer.Types.CHARSET;

/**
 * Class responsible for writing and reading data into and out of byte arrays.
 * Static methods exist for all primitive types in java and Strings (which are simply
 * translated into a string of bytes and saved into the byte array)
 * 
 * @author Tyler
 *
 */
public class DataSerializer {
//	public static final int BITS_IN_SHORT = 	8 * 2;
//	public static final int BITS_IN_CHAR = 		8 * 2;
//	public static final int BITS_IN_BYTE = 		8 * 2;
//	public static final int BITS_IN_INT = 		8 * 4;
//	public static final int BITS_IN_LONG = 		8 * 8;
//	public static final int BITS_IN_FLOAT = 	8 * 4;
//	public static final int BITS_IN_DOUBLE = 	8 * 8;
	public static final int BYTE_SHIFT = 		8;
	
	

	/*
	 *  ~~~~~~~~~ Primitive Data Type writers ~~~~~~~~~
	 */
	
	// byte - one byte
	public static int writeBytes(byte[] dest , int index, byte data){
		dest[index++] = data;
		return index;
	}
	
	// boolean - one byte
	public static int writeBytes(byte[] dest, int index, boolean data){
		dest[index++] = (byte) ((data != false) ? 1 : 0);
		return index;
	}
	
	// short - two bytes
	public static int writeBytes(byte[] dest, int index, short data){
		for(int i = (Short.SIZE - BYTE_SHIFT) ; i >= 0 ; i-= BYTE_SHIFT){
			dest[index++] = (byte) ((data >> i) & 0xff);
		}
		return index;
	}
	
	
	// char - two bytes
	public static int writeBytes(byte[] dest, int index, char data){
		for(int i = (Character.SIZE - BYTE_SHIFT) ; i >= 0 ; i-= BYTE_SHIFT){
			dest[index++] = (byte) ((data >> i) & 0xff);
		}
		return index;
	}
	
	// int - four bytes
	public static int writeBytes(byte[] dest, int index, int data){
		for(int i = (Integer.SIZE - BYTE_SHIFT) ; i >= 0 ; i-= BYTE_SHIFT){
			dest[index++] = (byte) ((data >> i) & 0xff);
		}
		return index;
	}
	
	// long - eight bytes
	public static int writeBytes(byte[] dest, int index, long data){
		for(int i = (Long.SIZE - BYTE_SHIFT) ; i >= 0 ; i-= BYTE_SHIFT){
			dest[index++] = (byte) ((data >> i) & 0xff);
		}
		return index;
	}
	
	// float - 4 bytes
	public static int writeBytes(byte[] dest, int index, float data){
		int bits = Float.floatToIntBits(data);
		for(int i = (Float.SIZE - BYTE_SHIFT) ; i >= 0 ; i-= BYTE_SHIFT){
			dest[index++] = (byte) ((bits >> i) & 0xff);
		}
		return index;
	}
	
	// double
	public static int writeBytes(byte[] dest, int index, double data){
		long bits = Double.doubleToLongBits(data);
		for(int i = (Double.SIZE - BYTE_SHIFT) ; i >= 0 ; i-= BYTE_SHIFT){
			dest[index++] = (byte) ((bits >> i) & 0xff);
		}
		return index;
	}
	
	// String - variable bytes
	public static int writeBytes(byte[] dest, int index, String data) throws UnsupportedEncodingException{
		// write the length of the string
		short strLen = (short)data.length();
		index = writeBytes(dest, index, strLen);
		
		// byte array of string using UTF-16BE encoding
		byte[] bytes = data.getBytes(CHARSET);
		
		// write array of chars (as bytes) into destination byte array
		index = writeBytes(dest, index, bytes);
		
		// return the updated index
		return index;
	}
	
	
	/*
	 * ~~~~~~~~~ Primitive Data Type Array Data Writers ~~~~~~~~~
	 */
	
	// byte array
	public static int writeBytes(byte[] dest, int index, byte[] data){
		// write bytes in byte array
		for(int i = 0 ; i < data.length; i++){
			index = writeBytes(dest, index, data[i]);
		}
		return index;
	}
	
	// boolean array
	public static int writeBytes(byte[] dest, int index, boolean[] data){
		for(int i = 0 ; i < data.length ; i++){
			index = writeBytes(dest, index, data[i]);
		}
		return index;
	}
	
	// char array 
	public static int writeBytes(byte[] dest, int index, char[] data){
		// write bytes in byte array
		for(int i = 0 ; i < data.length ; i++){
			index = writeBytes(dest, index, data[i]);
		}
		return index;
	}
	
	// short array
	public static int writeBytes(byte[] dest, int index, short[] data){
		for(int i = 0 ; i < data.length ; i++){
			index = writeBytes(dest, index, data[i]);
		}
		return index;
	}
	
	
	// int array
	public static int writeBytes(byte[] dest, int index, int[] data){
		for(int i = 0 ; i < data.length ; i++){
			index = writeBytes(dest, index, data[i]);
		}
		return index;
	}
	
	// long array
	public static int writeBytes(byte[] dest, int index, long[] data){
		for(int i = 0 ; i < data.length ; i++){
			index = writeBytes(dest, index, data[i]);
		}
		return index;
	}
	
	// float array
	public static int writeBytes(byte[] dest, int index, float[] data){
		for(int i = 0 ; i < data.length ; i++){
			index = writeBytes(dest, index, data[i]);
		}
		return index;
	}
	
	// double array
	public static int writeBytes(byte[] dest, int index, double[] data){
		for(int i = 0 ; i < data.length ; i++){
			index = writeBytes(dest, index, data[i]);
		}
		return index;
	}
	
	// String array?
	// TODO
	
	
	
}
