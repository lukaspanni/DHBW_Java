package dhbw.exercise.ui.paint;

import java.awt.Color;

public class Party implements Comparable<Party> {

	private double percent;
	private String name;
	private Color color;

	public double getPercent() {
		return percent;
	}

	public String getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Party(String name, double percent, Color color) {
		super();
		this.name = name;
		this.percent = percent;
		this.color = color;
	}

	@Override
	public int compareTo(Party o) {
		return (int) (o.percent - this.percent);
	}

}
