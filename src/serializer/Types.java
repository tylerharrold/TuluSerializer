package serializer;

public class Types {
	public static final byte BYTE = 1;
	public static final byte BOOLEAN = 2;
	public static final byte SHORT = 3;
	public static final byte CHAR = 4;
	public static final byte INTEGER = 5;
	public static final byte LONG = 6;
	public static final byte FLOAT = 7;
	public static final byte DOUBLE = 8;
	
	private final static int BITS_PER_BYTE = 8;
	public static final String CHARSET = "UTF-16BE";
	
	
	public static int getTypeByteSize(int type){
		switch(type){
			case BYTE: return Byte.SIZE / BITS_PER_BYTE;
			case BOOLEAN: return Byte.SIZE / BITS_PER_BYTE;
			case SHORT: return Short.SIZE / BITS_PER_BYTE;
			case CHAR: return Character.SIZE / BITS_PER_BYTE;
			case INTEGER: return Integer.SIZE / BITS_PER_BYTE;
			case LONG: return Long.SIZE / BITS_PER_BYTE;
			case FLOAT: return Float.SIZE / BITS_PER_BYTE;
			case DOUBLE: return Double.SIZE / BITS_PER_BYTE;
		}
		assert(false);
		return 0;
	}
}
