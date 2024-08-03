package m2j.ds.string;

public class CharCountSequence {
	public static void main(String[] args) {
		//aabcc=2a1b2c
		String input = "moorlee";
		System.out.println(encode(input));
	}

	private static String encode(String input) {
		if(input == null || input.length() == 0)
			return "";
		
		StringBuilder encoderBldr = new StringBuilder();
		
		char[] charInput = input.toCharArray();
		char preChar = 0;
		int counter = 0;
		
		for (char c : charInput) {
			if(c == preChar) {
				counter++;
			}else {
				if(preChar != 0)
					encoderBldr.append(counter).append(preChar);
				
				preChar=c;
				counter=1;
			}
		}

		encoderBldr.append(counter).append(preChar);

		return encoderBldr.toString();
	}

}
