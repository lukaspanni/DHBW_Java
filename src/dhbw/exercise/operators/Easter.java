package dhbw.exercise.operators;

public class Easter {

	public static void main(String[] args) {

		int jahr = 2019;
		int a, b, c, k, p, q, m, n, d, e, ostern;
		a = jahr % 19;
		b = jahr % 4;
		c = jahr % 7;
		k = jahr / 100;
		p = (8 * k + 13) / 25;
		q = k / 4;
		m = (15 + k - p - q) % 30;
		n = (4 + k - q) % 7;
		d = (19 * a + m) % 30;
		e = (2 * b + 4 * c + 6 * d + n) % 7;
		ostern = (22 + d + e);
		System.out.println("Ostern: " + ostern + " tage nach dem 1.März");
		String monat = "März";
		if (ostern > 31) {
			monat = "April";
			ostern -= 31;
		}
		System.out.println("Ostern ist " + jahr + " am " + ostern + "." + monat);

	}
}
