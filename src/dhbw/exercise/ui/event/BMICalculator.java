package dhbw.exercise.ui.event;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class BMICalculator extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new BMICalculator();
	}

	private JTextField weightField;
	private JTextField heightField;
	private JRadioButton maleBtn;
	private JRadioButton femaleBtn;
	private JButton btn;
	private JTextField bmiField;
	private JTextField resultField;

	public BMICalculator() {
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(350, 400);
		this.setTitle("BMI Calculator");
		this.setLayout(new FlowLayout());
		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("Weight [kg]"));
		panel1.add(weightField = new JTextField(12));
		this.add(panel1);
		JPanel panel2 = new JPanel();
		panel2.add(new JLabel("Height [m]"));
		panel2.add(heightField = new JTextField(12));
		this.add(panel2);
		JPanel panel3 = new JPanel();
		ButtonGroup bg = new ButtonGroup();
		bg.add(maleBtn = new JRadioButton("Male"));
		maleBtn.setSelected(true);
		panel3.add(maleBtn);
		bg.add(femaleBtn = new JRadioButton("Female"));
		panel3.add(femaleBtn);
		this.add(panel3);
		this.add(btn = new JButton("Calculate"));
		JPanel panel4 = new JPanel();
		panel4.add(new JLabel("BMI:"));
		panel4.add(bmiField = new JTextField(12));
		this.add(panel4);
		this.add(resultField = new JTextField(12));

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				double weight = 0, height = 0;
				try {
					weight = Double.parseDouble(weightField.getText());
					height = Double.parseDouble(heightField.getText());
				} catch (Exception e2) {

				}
				double bmi = weight / (height * height);
				bmiField.setText(String.valueOf(bmi));
				if ((maleBtn.isSelected() && bmi < 20) || (femaleBtn.isSelected() && bmi < 19)) {
					resultField.setText("Short Weight");
				} else if ((maleBtn.isSelected() && bmi < 25) || (femaleBtn.isSelected() && bmi < 24)) {
					resultField.setText("Normal Weight");
				} else if ((maleBtn.isSelected() && bmi < 30) || (femaleBtn.isSelected() && bmi < 30)) {
					resultField.setText("Overweight");
				} else if ((maleBtn.isSelected() && bmi < 40) || (femaleBtn.isSelected() && bmi < 40)) {
					resultField.setText("Adiposity");
				} else {
					resultField.setText("Massive Adiposity");
				}
			}
		});

		this.setVisible(true);
	}

}
