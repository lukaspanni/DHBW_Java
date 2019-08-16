package practice;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PersonCreator extends JFrame implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "OK":
			createPerson();
			break;
		case "Cancel":
			resetForm();
			break;
		}
	}

	private void resetForm() {
		ageInput.setText("");
		firstNameInput.setText("");
		middleNameInput.setText("");
		lastNameInput.setText("");
		salaryInput.setText("");
		departmentInput.setText("");
		genderInput.setSelectedIndex(0);
	}

	private void createPerson() {
		Person p = new Person();
		if (!ageInput.getText().equals("")) {
			p.setAge(Integer.parseInt(ageInput.getText()));
		}else{
			p.setAge(0);
		}
		p.setFirstName(firstNameInput.getText());
		p.setMiddleName(middleNameInput.getText());
		p.setLastName(lastNameInput.getText());
		p.setDepartment(departmentInput.getText());
		p.setGender((Person.Gender)genderInput.getSelectedItem());
		if (!salaryInput.getText().equals("")) {
			p.setSalary(Double.parseDouble(salaryInput.getText()));
		}else {
			p.setSalary(0);
		}
		if(listView == null) {
			listView = new PersonList();
		}
		else {
			listView.setState(NORMAL);
			listView.setVisible(true);
		}
		listView.addPerson(p);
		resetForm();
	}

	public static void main(String[] args) {
		new PersonCreator();
	}

	private JTextField ageInput;
	private JTextField firstNameInput;
	private JTextField middleNameInput;
	private JTextField lastNameInput;
	private JTextField salaryInput;
	private JTextField departmentInput;
	private JComboBox<Person.Gender> genderInput;
	private PersonList listView;

	public PersonCreator() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("Create Person");
		this.setLayout(new GridLayout(9, 2));
		this.add(new JLabel("FirstName: "));
		this.add(firstNameInput = new JTextField());
		this.add(new JLabel("MiddleName: "));
		this.add(middleNameInput = new JTextField());
		this.add(new JLabel("LastName: "));
		this.add(lastNameInput = new JTextField());
		this.add(new JLabel("Age: "));
		this.add(ageInput = new JTextField());
		this.add(new JLabel("Gender: "));
		this.add(genderInput = new JComboBox<Person.Gender>());
		genderInput.addItem(Person.Gender.MALE);
		genderInput.addItem(Person.Gender.FEMALE);
		genderInput.addItem(Person.Gender.OTHER);
		genderInput.setSelectedIndex(0);
		this.add(new JLabel("Salary: "));
		this.add(salaryInput = new JTextField());
		this.add(new JLabel("Department: "));
		this.add(departmentInput = new JTextField());
		JButton createButton = new JButton("OK");
		createButton.setActionCommand("OK");
		createButton.addActionListener(this);
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		cancelButton.addActionListener(this);
		this.add(createButton);
		this.add(cancelButton);
		this.setSize(500, 300);

	}

}
