package dhbw.probeklausur;

public class Visit {

	private Field[] fields;

	public Visit(Field[] fields) throws IllegalArgumentException {
		if (fields.length > 3) {
			throw new IllegalArgumentException();
		} else {
			this.fields = fields;
		}
	}

	public Field[] getFields() {
		return fields;
	}

	public int getValue() {
		int sum = 0;
		for (int i = 0; i < fields.length; i++) {
			if (fields[i] != null) {
				sum += fields[i].getValue();
			}
		}
		return sum;
	}

	public Field getLastField() {
		if (fields != null) {
			return fields[fields.length - 1];
		}
		return null;
	}
}
