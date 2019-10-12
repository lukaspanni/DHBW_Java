package dhbw.utility;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JFrame;

public class TestClass {

	public static void main(String[] args) {
		System.out.println("Test");
		JFrame f = new JFrame();
		f.setSize(150, 150);
		f.setVisible(true);
		AtomicInteger counter = new AtomicInteger(0);
		Timer t = new Timer();
		f.setTitle(String.valueOf(counter.get()));
		t.schedule(new TimerTask() {

			@Override
			public void run() {
				f.setTitle(String.valueOf(counter.getAndIncrement()));
			}
		}, 0, 1000);

	}

}
