package dhbw.probeklausur;

public class Board {

	private Field[] fields;

	public Board() {
		fields = new Field[63];
		int fCounter = 0;
		for (int i = 1; i <= 20; i++) {
			fields[fCounter++] = new Field(String.valueOf(i), i, false);
			fields[fCounter++] = new Field("D" + String.valueOf(i), i * 2, true);
			fields[fCounter++] = new Field("T" + String.valueOf(i), i * 3, false);
		}
		fields[fCounter++] = new Field("25", 25, true);
		fields[fCounter++] = new Field("BULL", 50, false);
		fields[fCounter++] = new Field("x", 0, false);
	}

	public Field parseField(String label) {
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].getLabel().compareToIgnoreCase(label) == 0) {
				return fields[i];
			}
		}
		return null;
	}

	public Field[] parseMultipleFields(String[] labels) {
		Field[] ret = new Field[labels.length];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = this.parseField(labels[i]);
		}
		return ret;
	}

}
