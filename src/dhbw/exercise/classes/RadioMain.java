package dhbw.exercise.classes;

public class RadioMain {
	public static void main(String[] args) {
		Radio radio = new Radio(false, 7, 93.5);
		System.out.println(radio);
		radio.turnOn();
		System.out.println(radio);
		radio.incVolume();
		radio.incVolume();
		System.out.println(radio);
		radio.incVolume();
		radio.incVolume();
		System.out.println(radio);
		radio.decVolume();
		System.out.println(radio);
		radio.setFrequency(97.8);
		System.out.println(radio);
		radio.setFrequency(112.7);
		System.out.println(radio);
		radio.turnOff();
		System.out.println(radio);
	}
}
