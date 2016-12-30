/**
 * Class responsible for writing and reading data into and out of byte arrays.
 * Static methods exist for all primitive types in java and Strings (which are simply
 * translated into a string of bytes and saved into the byte array)
 * @author Tyler
 *
 */
public class DataSerializer {

	// Methods to read data into a given char array
	
	// byte
	public static int writeBytes(byte[] dest , int index, byte data){
		dest[index++] = data;
		return index;
	}
	
	// boolean
	public static int writeBytes(byte[] dest, int index, boolean data){
		dest[index++] = (byte) ((data != false) ? 1 : 0);
		return index;
	}
	
	// short
	public static int writeBytes(byte[] dest, int index, short data){
		dest[index++] = (byte) ((data & 0xFF00) >> 8);
		dest[index++] = (byte) ((data & 0xFF));
		return index;
	}
	
	
	// char
	
	// int 
	
	// long
	
	// float
	
	// double
	
}
