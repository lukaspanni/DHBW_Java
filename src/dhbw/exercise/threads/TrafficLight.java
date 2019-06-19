package dhbw.exercise.threads;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TrafficLight extends JFrame {

	public TrafficLight() {
		this.setSize(600, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		TrafficLightComponent tlc = new TrafficLightComponent();
		this.add(tlc);
		new Thread(tlc).start();
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new TrafficLight();
	}

}
