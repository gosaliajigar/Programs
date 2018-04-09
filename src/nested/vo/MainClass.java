package nested.vo;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

/**
 * Recursively create nested composite objects using Reflection.
 * 
 * @author "Jigar Gosalia"
 *
 */
public class MainClass {

	private static List<String> PRIMITIVE_TYPE = new LinkedList<String>();

	static {
		PRIMITIVE_TYPE.add(String.class.getName());
		PRIMITIVE_TYPE.add(byte.class.getName());
		PRIMITIVE_TYPE.add(short.class.getName());
		PRIMITIVE_TYPE.add(int.class.getName());
		PRIMITIVE_TYPE.add(long.class.getName());
		PRIMITIVE_TYPE.add(float.class.getName());
		PRIMITIVE_TYPE.add(double.class.getName());
		PRIMITIVE_TYPE.add(boolean.class.getName());
		PRIMITIVE_TYPE.add(char.class.getName());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BankVO parentObject = (BankVO) createObject(BankVO.class.getName(), "");
		System.out.println();
		System.out.println(parentObject);
	}

	/**
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public static Object createObject(String vo, String tabs) throws Exception {

		Object object = Class.forName(vo).newInstance();

		System.out.println(tabs + "Creating Object : " + object.getClass());

		tabs += "-";

		if (object.getClass().getDeclaredFields().length > 0) {
			for (Field field : object.getClass().getDeclaredFields()) {
				if (!isPrimitive(field)) {
					field.setAccessible(true);
					field.set(object, createObject(field.getType().getName(), tabs));
				} else {
					System.out.println(tabs + "Skipping primitive type: " + field.getType().getName());
				}
			}
		}
		return object;
	}

	/**
	 * TODO: too naive, need to improve
	 * 
	 * @param field
	 * @return
	 */
	private static boolean isPrimitive(Field field) {
		String fieldType = field.getType().getName();
		if (PRIMITIVE_TYPE.contains(fieldType)) {
			return true;
		}
		return false;
	}
}
