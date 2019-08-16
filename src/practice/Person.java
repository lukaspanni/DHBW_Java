package practice;

import java.awt.Color;

public class Person {

	private int age;
	private Gender gender;
	private String firstName;
	private String lastName;
	private String middleName;
	private double salary;
	private String department;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age >= 0) {
			this.age = age;
		}else {
			age = 0;
		}
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		if(salary >= 0) {
			this.salary = salary;
		}else {
			salary = 0;
		}
		
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Person() {
		
	}

	
	
	public Person(int age, Gender gender, String firstName, String lastName, String middleName, double salary,
			String department) {
		super();
		this.age = age;
		this.gender = gender;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.salary = salary;
		this.department = department;
	}

	@Override
	public String toString() {
		return firstName + " " + middleName + " " + lastName + " age:" + age + ", gender:" + gender + ", salary=" + salary + ", department=" + department;
	}



	enum Gender{
		MALE(Color.BLUE), FEMALE(Color.PINK), OTHER(Color.GRAY);
		
		private Color displayColor;

		public Color getDisplayColor() {
			return displayColor;
		}

		public void setDisplayColor(Color displayColor) {
			this.displayColor = displayColor;
		}
		
		Gender(Color c){
			displayColor = c;
		}
	}
	
}
