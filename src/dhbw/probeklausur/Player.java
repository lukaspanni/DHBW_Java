package dhbw.probeklausur;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Player {

	private String name;
	private int countDartsThrown;
	private Visit[] visits;
	private int visitsLeft;

	private int remainingPoints;

	public String getName() {
		return this.name;
	}

	public int getVisitsLeft() {
		return this.visitsLeft;
	}

	public int getCountDartsThrown() {
		return this.countDartsThrown;
	}

	public Player(String name) {
		if (name != null) {
			this.name = name;
		}
		this.visits = new Visit[10];
		this.visitsLeft = 10;
		this.remainingPoints = 501;
		this.countDartsThrown = 0;
	}

	public int getRemainingPoints() {
		return this.remainingPoints;
	}

	public boolean addVisit(Visit visit) {
		if (visit != null) {
			int pointsAfterVisit = this.remainingPoints - visit.getValue();
			if (pointsAfterVisit < 0 || pointsAfterVisit == 1) {
				countDartsThrown += visit.getFields().length;
				visitsLeft--;
				return false;
			} else {
				if (visitsLeft > 0) {
					if (pointsAfterVisit == 0) {
						if (visit.getLastField().isDoubleField()) {
							visits[10 - visitsLeft] = visit;
							visitsLeft--;
							this.remainingPoints = pointsAfterVisit;
							countDartsThrown += visit.getFields().length;
							return true;
						} else {
							visitsLeft--;
							countDartsThrown += visit.getFields().length;
							return false;
						}

					} else {
						visits[10 - visitsLeft] = visit;
						visitsLeft--;
						this.remainingPoints = pointsAfterVisit;
						countDartsThrown += visit.getFields().length;
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public String toString() {
		String ret = "Player " + name + ", remaining Points: " + remainingPoints + " " + visitsLeft + " visits Left\n";
		if (remainingPoints <= 170) {
			ret += findPossibleCheckout() == null ? "" : "Possible Checkout: " + findPossibleCheckout();
		}
		return ret;
	}

	private String findPossibleCheckout() {
		File ch = new File("checkouts.txt");
		if (ch.exists()) {
			try (BufferedReader br = new BufferedReader(new FileReader(ch))) {
				String line = br.readLine();
				int lineCounter = 1;
				while (br.ready()) {
					if (lineCounter == this.remainingPoints) {
						if (line.contains("-")) {
							return null;
						} else {
							return line;
						}
					}
					line = br.readLine();
					lineCounter++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
