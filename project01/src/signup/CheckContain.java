package signup;

public class CheckContain {

	public int CheckContainAlpha(String pwd) {
		int result = 0;
		for (int i = 0; i < pwd.length(); ++i) {			
			if ((pwd.charAt(i) >= 'a' && pwd.charAt(i) <= 'z') || (pwd.charAt(i) >= 'A' && pwd.charAt(i) <= 'Z')) {
				result = 1;
			}
		}
		return result;
	}
	
	public int CheckContainNum(String pwd) {
		int result = 0;
		for (int i = 0; i < pwd.length(); ++i) {
			if (pwd.charAt(i) >= '0' && pwd.charAt(i) <= '9') {
				result = 1;
			}
		}
		
		return result;
	}
	
}
