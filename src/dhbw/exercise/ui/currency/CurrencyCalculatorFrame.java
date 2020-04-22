package dhbw.exercise.ui.currency;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CurrencyCalculatorFrame extends JFrame implements ActionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private CurrencyCalculator currencyCalculator = new CurrencyCalculator();

	public static void main(String[] args) {
		new CurrencyCalculatorFrame();
	}

	private JTextField valueField = new JTextField();
	private JTextField convRateField = new JTextField();
	private JPanel lblPanel = new JPanel();
	private JButton btn1;
	private JButton btn3;
	private JLabel eurLabel;
	private JLabel usdLabel;

	public CurrencyCalculatorFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Currency Converter");
		setLayout(new GridLayout(4, 2));

		this.add(new JLabel("Conversion Rate:"));
		this.add(this.convRateField);

		this.add(new JLabel("Value: "));
		this.add(this.valueField);

		this.add(new JLabel("Result: "));
		this.lblPanel.setLayout(new GridLayout(1, 2));
		this.lblPanel.add(this.eurLabel = new JLabel("EUR"));
		this.lblPanel.add(this.usdLabel = new JLabel("USD"));
		this.add(this.lblPanel);

		this.add(this.btn1 = new JButton("Convert"));
		this.add(this.btn3 = new JButton("Cancel"));
		this.btn1.addActionListener(this);
		this.btn3.addActionListener(this);

		setSize(300, 200);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.valueField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Keine Eingabe!");
		} else {
			if (e.getSource() == this.btn1) {
				if (!this.convRateField.getText().isEmpty()) {
					try {
						this.currencyCalculator.setConvRate(Double.parseDouble(this.convRateField.getText()));
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Fehlerhafte Eingabe!");
					}
				}
				try {
					this.currencyCalculator.parseAndConvert(this.valueField.getText());
					this.eurLabel.setText(this.currencyCalculator.getEuro());
					this.usdLabel.setText(this.currencyCalculator.getUSD());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Fehlerhafte Eingabe!");
				}
			} else if (e.getSource() == this.btn3) {
				this.valueField.setText("");
				this.eurLabel.setText("EUR");
				this.usdLabel.setText("USD");
			}
		}
	}

}
