package m2j.strings;

public class NonRepititiveCharacterInString {


	static char count[] = new char[256];

	public static void main(String[] args) {

		String str = "States";
		int response = findFirstNonRepetitiveChar(str);

		if (response < 0)
			System.out.println("not found");

		System.out.println(response + "  Character is - " + str.charAt(response));
	}

	static void getCharCountArray(String str) {
		for (int i = 0; i < str.length(); i++){
			count[str.charAt(i)]++;
			//i++;
		}
//			count[str.charAt(i)]++;
	}

	private static int findFirstNonRepetitiveChar(String str) {

		if (null == str) return -1;

		str = str.toLowerCase();

		getCharCountArray(str);

		int index = -1, i;

		for (i = 0; i < str.length(); i++) {
			if (count[str.charAt(i)] == 1) {
				index = i;
				break;
			}
		}

		return index;
	}

}
