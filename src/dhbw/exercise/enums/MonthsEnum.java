package dhbw.exercise.enums;

import java.util.Calendar;

public class MonthsEnum {

	enum Months {

		Januar(31, "Hartung, Eismond"), Februar(28, "Hornung, Schmelzmond, Taumond, Narrenmond, Rebmond, Hintester"),
		März(31, "Lenzing, Lenzmond"), April(30, "Launing, Ostermond"), Mai(31, "Winnemond*, Blumenmond"),
		Juni(30, "Brachet, Brachmond"), Juli(31, "Heuert, Heumond"), August(31, "Ernting, Erntemond, Bisemond"),
		September(30, "Scheiding, Herbstmond"), Oktober(31, "Gilbhart, Gilbhard, Weinmond"),
		November(30, "Nebelung, Windmond, Wintermond"), Dezember(31, "Julmond, Heilmond, Christmond, Dustermond");

		public int days;
		public String oldNames;

		Months(int days, String oldNames) {
			this.days = days;
			this.oldNames = oldNames;
		}
	}

	public static void main(String[] args) {
		Months month = Months.values()[Calendar.getInstance().get(Calendar.MONTH)];
		System.out.println(
				"Der " + month.toString() + " hat " + month.days + " Tage und hieß früher '" + month.oldNames + "'");
	}

}
