package dhbw.utility;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BorderLayoutFrameTemplate extends JFrame implements ActionListener{

	private String title = "";

	public BorderLayoutFrameTemplate() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(this.title);
		setLayout(new BorderLayout());

		JPanel topPanel = new JPanel();
		this.add(topPanel, BorderLayout.NORTH);

		JPanel botPanel = new JPanel();
		this.add(botPanel, BorderLayout.SOUTH);

		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}



}