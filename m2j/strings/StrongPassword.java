package m2j.strings;

public class StrongPassword {
	public static void main(String[] args) {
		String pwd = "Ab1";
		int isPasswordStrong = isPasswordStrong(pwd, 3);
		System.out.println(isPasswordStrong);
	}

	private static int isPasswordStrong(String password, int n) {
		
		if(password == null) return n;
		
		int requiredLength = 0;
		
		boolean hasLowerCase = false, hasUpperCase = false, hasDigit = false, hasSpecialChar=false;
		int charNeeded = 0;

		for (char c: password.toCharArray()) {
			if(c >= 48 && c <= 57){
				hasDigit = true;
			}
			
			if(c >= 97 && c <= 122){
				hasLowerCase = true;
			}
			
			if(c >= 65 && c <= 90){
				hasUpperCase = true;
			}
			
			//special_characters = "!@#$%^&*()-+"
			
			if(c >= 35 && c <= 38){//4
				hasSpecialChar = true;
			}
			//1+4+
			if(c == 33 || (c >= 40 && c <= 43) || c <= 45 || c == 64 ||c == 94){
				hasSpecialChar = true;
			}
			
			requiredLength++;
		}
		
		if(hasDigit && hasLowerCase && hasSpecialChar && hasUpperCase){
			return charNeeded;
		}
		
		if(!hasDigit){
			++charNeeded;
		}
		
		if(!hasLowerCase){
			++charNeeded;
		}
		
		if(!hasSpecialChar){
			++charNeeded;
		}
		
		if(!hasUpperCase){
			++charNeeded;
		}
		
		if((requiredLength+charNeeded)<6){
			charNeeded += 6 - charNeeded - requiredLength;
		}
		
		return charNeeded;
	}

}
