package login;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {
	
	public String encryptionPwd(String pwd) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		pwd += "happy";
		md.update(pwd.getBytes());
		String result = String.format("%064x", new BigInteger(1, md.digest()));
		
		return result;
	}
	
}
