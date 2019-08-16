package dhbw.utility;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class GridFrameTemplate extends JFrame implements ActionListener{

	private int x = 10;
	private int y = 10;
	private String title = "";
	
	public GridFrameTemplate() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle(title);
		this.setLayout(new GridLayout(x, y));
		
		this.pack();
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
