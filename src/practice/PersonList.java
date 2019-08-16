package practice;

import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListModel;

public class PersonList extends JFrame {

	private JList<Person> displayList = new JList<Person>();
	private List<Person> dataList = new LinkedList<Person>();
	

	public void addPerson(Person p) {
		dataList.add(p);
		DefaultListModel<Person> model = new DefaultListModel<Person>();
		for (int i = 0; i < dataList.size(); i++)
		{
		    model.addElement(dataList.get(i));
		}
		displayList.setModel(model);
	}
	

	public PersonList() {
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("Persons");
		this.add(displayList);
		this.setSize(800,800);
		this.setLocation(500,500);
	}
	
	
	
}
