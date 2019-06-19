package info1.ueb;

public class Belegungsfunc {

	public static void main(String[] args) {
		// G, A, F, S, K, V, D
		boolean[] aussagen = new boolean[7];
		boolean[] formeln = new boolean[8];
		for (int i = 0; i < Math.pow(2, aussagen.length); i++) {
			String bin = Integer.toBinaryString(i);
			while (bin.length() < aussagen.length) {
				bin = "0" + bin;
			}
			char[] chars = bin.toCharArray();
			for (int j = 0; j < chars.length; j++) {
				aussagen[j] = chars[j] == '0' ? false : true;
			}
			// Formeln
			formeln[0] = !aussagen[0] || aussagen[1];
			formeln[1] = aussagen[0] || aussagen[2];
			formeln[2] = !aussagen[1] || aussagen[3];
			formeln[3] = !aussagen[2] || aussagen[4];
			formeln[4] = !aussagen[5];
			formeln[5] = !aussagen[6];
			formeln[6] = !(!aussagen[0] && (!aussagen[5] && !aussagen[6]));
			// S = !K
			formeln[7] = true;
			// formeln[7] = aussagen[3] && !aussagen[4]; // Teilaufgabe2

			boolean b = true;
			for (int j = 0; j < formeln.length; j++) {
				b = b && formeln[j];
			}
			if (b) {
				System.out.println(chars);
			}

		}

	}

}
