package dhbw.exercise.classes.periodic;

public class Metal extends Element {

	private boolean metalloid;
	private double conductivity;

	public boolean isMetalloid() {
		return metalloid;
	}

	public double getConductivity() {
		return conductivity;
	}

	public void setMetalloid(boolean metalloid) {
		this.metalloid = metalloid;
	}

	public void setConductivity(double conductivity) {
		this.conductivity = conductivity;
	}

	public Metal(String name, String symbol, int ordinal, boolean metalloid, double conductivity) {
		super(name, symbol, ordinal);
		this.metalloid = metalloid;
		this.conductivity = conductivity;
	}

	public Metal(String name, String symbol, int ordinal, char shell, int phase, boolean mainGroup, boolean metalloid,
			double conductivity) {
		super(name, symbol, ordinal, shell, phase, mainGroup);
		this.metalloid = metalloid;
		this.conductivity = conductivity;
	}

	@Override
	public String toString() {
		return super.toString() + " \u03C3: " + conductivity + (metalloid ? " Halbmetall" : " Metall");
	}

}
