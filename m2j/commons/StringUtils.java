package m2j.commons;

import java.lang.reflect.Field;
import java.util.Arrays;

public class StringUtils {
	private StringUtils() {
		throw new RuntimeException("You can create an instance of StringUtils class.");
	}
	
	public static void main(String[] args) {
		String str = " M u r l i M J h a   ";
		str = deleteWhitespace(str);
		System.out.println(str);
	}

	public static String deleteWhitespace(final String str) {
		if (isEmpty(str)) {
			return str;
		}
		final int sz = str.length();
		final char[] chs = new char[sz];
		int count = 0;
		for (int i = 0; i < sz; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				chs[count++] = str.charAt(i);
			}
		}
		if (count == sz) {
			return str;
		}
		return new String(chs, 0, count);
	}

	public static boolean isEmpty(final CharSequence cs) {
		return cs == null || cs.length() == 0;
	}

	public static boolean containsIgnoreCaseInArray(String[] array, String value) {
		return Arrays.stream(array).anyMatch(value::equalsIgnoreCase);
	}

	public static boolean containsIgnoreCaseClassic(String[] array, String value) {
		for (String str : array) {
			if (value == null && str == null)
				return true;
			if (value != null && value.equalsIgnoreCase(str))
				return true;
		}
		return false;
	}

	public static boolean isNonEmptyResponse(Object object) {
		if (object == null)
			return false;
		boolean informationFound = false;

		for (Field f : object.getClass().getDeclaredFields()) {
			f.setAccessible(true);
			try {
				if (f.get(object) != null) {
					informationFound = true;
					break;
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return informationFound;
	}
}
