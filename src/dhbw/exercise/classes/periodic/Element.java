package dhbw.exercise.classes.periodic;

public class Element {

	private String name;
	private String symbol;
	private int ordinal;
	private char shell;
	private int phase;
	private boolean mainGroup;

	public String getName() {
		return name;
	}

	public String getSymbol() {
		return symbol;
	}

	public int getOrdinal() {
		return ordinal;
	}

	public char getShell() {
		return shell;
	}

	public int getPhase() {
		return phase;
	}

	public boolean isMainGroup() {
		return mainGroup;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public void setOrdinal(int ordinal) {
		if (ordinal >= 1) {
			this.ordinal = ordinal;
		}
	}

	public void setShell(char shell) {
		this.shell = shell;
	}

	public void setPhase(int phase) {
		if (phase >= 1 && phase <= 3) {
			this.phase = phase;
		}
	}

	public void setMainGroup(boolean mainGroup) {
		this.mainGroup = mainGroup;
	}

	public Element(String name, String symbol, int ordinal) {
		super();
		this.name = name;
		this.symbol = symbol;
		this.setOrdinal(ordinal);
	}

	public Element(String name, String symbol, int ordinal, char shell, int phase, boolean mainGroup) {
		super();
		this.name = name;
		this.symbol = symbol;
		this.setOrdinal(ordinal);
		this.shell = shell;
		this.setPhase(phase);
		this.mainGroup = mainGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Element) {
			if (this.ordinal == ((Element) o).ordinal) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return name + "(" + symbol + ", " + ordinal + ") Schale " + shell + ", "
				+ (phase == 1 ? "fest" : (phase == 2 ? "flüssig" : "gasförmig")) + " Gruppe: "
				+ (mainGroup ? "Hauptgruppe" : "Nebengruppe");
	}

}
