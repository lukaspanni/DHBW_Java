package info1.ueb;

import java.security.SecureRandom;
import java.util.Scanner;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Quersumme {

	public static void main(String[] args) {
		/*Scanner sc = new Scanner(System.in);
		System.out.print("Zahl eingeben: ");
		int n = sc.nextInt();
		System.out.print("Quersumme von " + n + " ist: ");
		System.out.println(quersumme(n));
		sc.close();*/
		System.out.println(hashPassword("123"));
	}

	private static String hashPassword(String password) {
		try {
			char[] pw=password.toCharArray();
			
			byte[] salz=new byte[16];
			int iterationCount=1000;
			
			SecureRandom sr=new SecureRandom();
			sr.nextBytes(salz);
			
			SecretKeyFactory fac=SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
			PBEKeySpec pbeks=new PBEKeySpec(pw, salz, iterationCount, 512);
			
			byte[] hash=fac.generateSecret(pbeks).getEncoded();
			
			String output=iterationCount+"/";
			
			for(byte b:salz) {
				int i=b&0xff;
				output+=Integer.toHexString(i)+"-";
			}
			
			output=output.substring(0, output.length()-1);
			output+="/";
			
			for(byte b:hash) {
				int i=b&0xff;
				output+=Integer.toHexString(i);
			}
			
			return output;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	private static int quersumme(int n) {
		if (n / 10 < 1) {
			return n;
		}
		return quersumme(n % 10 + quersumme(n / 10));
	}

}
