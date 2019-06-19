package dhbw.exercise.classes.periodic;

public class PeriodicTable {
	private Element[] pTable = new Element[119];

	public void addElement(Element e) {
		if (pTable[e.getOrdinal()] == null) {
			pTable[e.getOrdinal()] = e;
		}
	}

	public boolean hasElement(int o) {
		if (pTable[o] != null) {
			return true;
		}
		return false;
	}

	public Element getElement(int o) {
		return pTable[o];
	}

	public Element[] getMetals() {
		Element[] metals = new Element[91];
		int metalIndex = 0;
		for (int i = 0; i < pTable.length; i++) {
			if (pTable[i] instanceof Metal) {
				metals[metalIndex++] = pTable[i];
			}
		}
		return metals;
	}

	public void output() {
		for (int i = 0; i < pTable.length; i++) {
			if (pTable[i] == null) {
				continue;
			}
			System.out.println(pTable[i]);
		}
	}

	public static void main(String[] args) {
		PeriodicTable p = new PeriodicTable();
		p.addElement(new Element("Wasserstoff", "H", 1, 'K', 3, true));
		p.addElement(new Element("Helium", "He", 2, 'K', 3, true));
		p.addElement(new Metal("Natrium", "Na", 11, 'M', 1, true, false, 21E6));
		p.addElement(new Metal("Eisen", "Fe", 26, 'N', 1, false, false, 10.02E6));
		p.addElement(new Metal("Germanium", "Ge", 32, 'N', 1, false, true, 1.45));
		p.addElement(new Element("Brom", "Br", 35, 'N', 2, true));
		p.addElement(new Metal("Tellur", "Te", 52, 'O', 1, true, true, 0.005));
		p.addElement(new Metal("Gold", "Au", 79, 'P', 1, false, false, 44E6));

		p.output();

		System.out.println("\n\nMetalle:");
		Element[] metals = p.getMetals();
		for (int i = 0; i < metals.length; i++) {
			if (metals[i] == null) {
				break;
			}
			System.out.println(metals[i]);
		}
		System.out.println("\nElement 79:");
		System.out.println(p.getElement(79));

	}
}
