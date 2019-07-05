package dhbw.exercise.threads.buffer;

import java.util.LinkedList;

class MyBuffer {
	private final int MAXSIZE = 3;
	private LinkedList<Integer> values = new LinkedList<>();

	public synchronized void put(int v) {
		if (this.values.size() >= MAXSIZE) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}

		this.values.add(v);
		this.notify();
		System.out.println("Put: " + v);
		System.out.println("FillState: " + this.values.size());
	}

	public synchronized int get() {
		int v = 0;
		if (this.values.size() < 1) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		if (this.values.size() >= 1) {
			v = this.values.removeFirst();
			this.notify();
		}
		System.out.println("Get:" + v);
		System.out.println("FillState: " + this.values.size());
		return v;
	}

	public static void main(String[] args) {
		MyBuffer b = new MyBuffer();
		new ProducerThread(b).start();
		new ConsumerThread(b).start();
	}

}

class ProducerThread extends Thread {
	MyBuffer buf;

	public ProducerThread(MyBuffer b) {
		this.buf = b;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			this.buf.put(i);
			try {
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ConsumerThread extends Thread {
	MyBuffer buf;

	public ConsumerThread(MyBuffer b) {
		this.buf = b;
	}

	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			this.buf.get();
			try {
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}