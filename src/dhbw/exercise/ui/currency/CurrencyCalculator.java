package dhbw.exercise.ui.currency;

public class CurrencyCalculator {

	private double usdValue;
	private double eurValue;
	private double convRate;

	public CurrencyCalculator() {
		this(0.92);
	}

	public CurrencyCalculator(double convRate) {
		this.convRate = convRate;
	}

	public double getUsdValue() {
		return this.usdValue;
	}

	public void setUsdValue(double usdValue) {
		this.usdValue = usdValue;
	}

	public double getEurValue() {
		return this.eurValue;
	}

	public void setEurValue(double eurValue) {
		this.eurValue = eurValue;
	}

	public double getConvRate() {
		return this.convRate;
	}

	public void setConvRate(double convRate) {
		this.convRate = convRate;
	}

	public double convertToUSD() {
		return this.eurValue / this.convRate;
	}

	public double convertToEUR() {
		return this.usdValue * this.convRate;
	}

	public void parseAndConvert(String input) {
		if (input.contains("€")) {
			String value = input.split("€")[0];
			setEurValue(Double.parseDouble(value));
			setUsdValue(convertToUSD());
		}
		else if (input.contains("$")) {
			String value = input.split("\\$")[0];
			setUsdValue(Double.parseDouble(value));
			setEurValue(convertToEUR());
		}
	}

	public String getEuro() {
		return String.valueOf(Math.round(getEurValue() * 100.0) / 100.0) + " €";
	}

	public String getUSD() {
		return String.valueOf(Math.round(getUsdValue() * 100.0) / 100.0) + " $";
	}

}
