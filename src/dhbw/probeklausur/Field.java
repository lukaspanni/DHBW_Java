package dhbw.probeklausur;

public class Field {
	private String label;
	private int value;
	private boolean doubleField;

	public String getLabel() {
		return label;
	}

	public int getValue() {
		return value;
	}

	public boolean isDoubleField() {
		return doubleField;
	}

	public Field(String label, int value, boolean doubleField) {
		super();
		this.label = label;
		this.value = value;
		this.doubleField = doubleField;
	}

}
