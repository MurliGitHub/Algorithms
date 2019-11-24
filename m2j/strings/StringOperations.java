package m2j.strings;

public class StringOperations {

	public String revertString(String text) {

		int lengthOfText = text.length();

		StringBuilder reversedString = new StringBuilder();

		for (int index = lengthOfText - 1; index >= 0; index--) {
			reversedString.append(text.charAt(index));

		}

		return reversedString.toString();
	}

}
