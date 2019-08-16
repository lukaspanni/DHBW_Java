package practice;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.Clock;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener {

	public static void main(String[] args) {
		new MainFrame();
	}
	
	private JTextField input;
	
	public MainFrame() {
		super();
		this.setTitle("MainWindow");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowClosed(WindowEvent e) {
				
			}

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				File f = new File("test.txt");
				f.delete();				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		
		});
		JPanel top = new JPanel();
		JButton btn1 = new JButton("Yes");
		btn1.setActionCommand("Yes");
		btn1.addActionListener(this);
		JButton btn2 = new JButton("No");
		btn2.setActionCommand("No");
		btn2.addActionListener(this);
		JButton btn3 = new JButton("Cancel");
		btn3.setActionCommand("Cancel");
		btn3.addActionListener(this);
		top.add(btn1);
		top.add(btn2);
		top.add(btn3);
		this.add(top,BorderLayout.NORTH);
		JPanel bot = new JPanel(new BorderLayout());
		input = new JTextField();
		JLabel inputLabel = new JLabel();
		JButton okbtn = new JButton("OK");
		okbtn.setActionCommand("OK");
		okbtn.addActionListener(this);
		bot.add(inputLabel,BorderLayout.NORTH);
		bot.add(input,BorderLayout.NORTH);
		bot.add(okbtn,BorderLayout.SOUTH);
		this.add(bot,BorderLayout.SOUTH);
		Timer t = new Timer();
		t.setTarget(this);
		Thread th = new Thread(t);
		th.start();
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch (command) {
		case "Yes":
			JOptionPane.showMessageDialog(this, "Yes");
			break;
		case "No":
			JOptionPane.showMessageDialog(this, "No");
			break;
		case "Cancel":
			JOptionPane.showMessageDialog(this, "Cancel");
			break;
		case "OK":
			saveText();
			break;
		}
	}

	private void saveText() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt", true))) {
			bw.write(this.getTitle() + " - " + input.getText() + "\n");
			input.setText("");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		StringBuilder sb = new StringBuilder("Alte Texte: \n");
		try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
			String line = br.readLine();
			while (line != null) {
				sb.append(line+"\n");
				line = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(this, sb.toString());
	}

}
