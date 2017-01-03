package serializer;

public class Types {
	public static final byte BYTE = 1;
	public static final byte BOOLEAN = 2;
	public static final byte SHORT = 3;
	public static final byte CHAR = 4;
	public static final byte INT = 5;
	public static final byte LONG = 6;
	public static final byte FLOAT = 7;
	public static final byte DOUBLE = 8;
	
	
	public static int getTypeByteSize(int type){
		switch(type){
			case BYTE: return 1;
			case BOOLEAN: return 1;
			case SHORT: return 2;
			case CHAR: return 2;
			case INT: return 4;
			case LONG: return 8;
			case FLOAT: return 4;
			case DOUBLE: return 8;
		}
		assert(false);
		return 0;
	}
}
