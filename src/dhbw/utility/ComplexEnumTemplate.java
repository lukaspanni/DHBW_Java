package dhbw.utility;

public enum ComplexEnumTemplate {
	ENTRY_1(0,"Entry 1"), ENTRY_2(1,"Entry 2"); //...
	
	private int id;
	private String text;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	private ComplexEnumTemplate(int id, String text) {
		this.id = id;
		this.text = text;
	}
	
	
}
