package dhbw.exercise.collections;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dhbw.exercise.collections.Library.SortCategories;

public class LibraryFrame extends JFrame implements ActionListener {

	private Library library = new Library();
	private String path = "lib.txt";
	private JButton saveBtn;
	private JTextField titleInput;
	private JTextField authorInput;
	private JTextField yearInput;
	private JTextField publisherInput;
	private JButton titleBtn;
	private JButton authorBtn;
	private JButton yearBtn;
	private JButton publisherBtn;

	public static void main(String[] args) {
		new LibraryFrame();
	}

	public LibraryFrame() {
		this.setTitle("Library");
		this.setSize(500, 180);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel top = new JPanel(new GridLayout(4, 2));
		JLabel titleLabel = new JLabel("Title");
		titleInput = new JTextField(12);
		JLabel authorLabel = new JLabel("Author");
		authorInput = new JTextField(12);
		JLabel yearLabel = new JLabel("Year");
		yearInput = new JTextField(12);
		JLabel publisherLabel = new JLabel("Publisher");
		publisherInput = new JTextField(12);
		top.add(titleLabel);
		top.add(titleInput);
		top.add(authorLabel);
		top.add(authorInput);
		top.add(yearLabel);
		top.add(yearInput);
		top.add(publisherLabel);
		top.add(publisherInput);
		this.add(top, BorderLayout.NORTH);
		JPanel bot = new JPanel();
		JLabel outLabel = new JLabel("ordered output:");
		titleBtn = new JButton("Title");
		authorBtn = new JButton("Author");
		yearBtn = new JButton("Year");
		publisherBtn = new JButton("Publisher");
		titleBtn.addActionListener(this);
		authorBtn.addActionListener(this);
		yearBtn.addActionListener(this);
		publisherBtn.addActionListener(this);

		bot.add(outLabel);
		bot.add(titleBtn);
		bot.add(authorBtn);
		bot.add(yearBtn);
		bot.add(publisherBtn);
		this.add(bot, BorderLayout.SOUTH);
		saveBtn = new JButton("save entry");
		saveBtn.addActionListener(this);
		this.add(saveBtn);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				library.saveToFile(path);
				System.exit(0);
			}
		});

		this.setVisible(true);
		this.library.loadFromFile(path);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == saveBtn) {
			try {
				library.add(new Book(titleInput.getText(), authorInput.getText(), yearInput.getText(),
						publisherInput.getText()));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == titleBtn) {
			JOptionPane.showMessageDialog(this, library.sort(SortCategories.Title));
		} else if (e.getSource() == authorBtn) {
			JOptionPane.showMessageDialog(this, library.sort(SortCategories.Author));
		} else if (e.getSource() == yearBtn) {
			JOptionPane.showMessageDialog(this, library.sort(SortCategories.Year));
		} else if (e.getSource() == publisherBtn) {
			JOptionPane.showMessageDialog(this, library.sort(SortCategories.Publisher));
		}
	}

}
