package dhbw.exercise.classes;

public class Radio {
	private boolean on;
	private int volume;
	private double frequency;

	public Radio() {
		super();
		this.on = false;
		this.volume = 5;
		this.frequency = 85.0;
	}

	public Radio(boolean on, int volume, double frequency) {
		super();
		this.on = on;
		this.volume = volume;
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return "Radio " + (on == true ? "an: " : "aus: ") + "Freq=" + frequency + ", Laut=" + volume;
	}

	public void incVolume() {
		if (on) {
			if (this.volume <= 9) {
				this.volume++;
			}
		}
	}

	public void decVolume() {
		if (on) {
			if (this.volume >= 1) {
				this.volume--;
			}
		}
	}

	public void turnOn() {
		on = true;
	}

	public void turnOff() {
		on = false;
	}

	public void setFrequency(double frequency) {
		if (frequency >= 85.0 && frequency <= 110.0) {
			this.frequency = frequency;
		} else {
			this.frequency = 99.9;
		}
	}

}
