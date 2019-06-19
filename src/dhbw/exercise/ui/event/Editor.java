package dhbw.exercise.ui.event;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileFilter;

public class Editor extends JFrame implements ActionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new Editor();
	}

	JTextPane editorPane;
	JMenuItem newMI = new JMenuItem("Neu");
	JMenuItem openMI = new JMenuItem("Öffnen");
	JMenuItem saveMI = new JMenuItem("Speichern");
	JMenuItem closeMI = new JMenuItem("Beenden");
	File openFile;

	public Editor() {
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Editor");
		this.setLayout(new GridLayout(1, 1));
		this.setSize(640, 480);

		JMenuBar mbar = new JMenuBar();
		JMenu fileMenu = new JMenu("Datei");
		fileMenu.setMnemonic('D');
		fileMenu.add(newMI);
		newMI.addActionListener(this);
		fileMenu.add(openMI);
		openMI.addActionListener(this);
		fileMenu.addSeparator();
		fileMenu.add(new JMenuItem("Schließen"));
		fileMenu.addSeparator();
		fileMenu.add(saveMI);
		saveMI.addActionListener(this);
		saveMI.setEnabled(false);
		fileMenu.add(new JMenuItem("Speichern unter..."));
		fileMenu.add(new JMenuItem("Als Webseite speichern"));
		fileMenu.add(new JMenuItem("Suchen"));
		fileMenu.addSeparator();
		fileMenu.add(new JMenuItem("Versionen"));
		fileMenu.addSeparator();
		fileMenu.add(new JMenuItem("Webseitenvorschau"));
		fileMenu.addSeparator();
		fileMenu.add(new JMenuItem("Seite einrichten..."));
		fileMenu.add(new JMenuItem("Seitenansicht"));
		fileMenu.add(new JMenuItem("Drucken"));
		fileMenu.addSeparator();

		JMenu m = new JMenu("Senden an");
		m.setMnemonic('S');
		m.add(new JMenuItem("E-Mail-Empfänger"));
		m.add(new JMenuItem("E-Mail-Empfänger (zur Überarbeitung)"));
		m.add(new JMenuItem("E-Mail-Empfänger (als Anlage)"));
		m.addSeparator();
		m.add(new JMenuItem("Verteilerempfänger..."));
		m.add(new JMenuItem("Onlinebesprechungsteilnehmer"));
		m.add(new JMenuItem("Exchange-Ordner"));
		m.add(new JMenuItem("Fax-Empfänger..."));
		m.addSeparator();
		m.add(new JMenuItem("Microsoft PowerPoint"));
		fileMenu.add(m);

		fileMenu.add(new JMenuItem("Eigenschaften"));
		fileMenu.addSeparator();
		fileMenu.add(new JMenuItem(""));
		fileMenu.add(new JMenuItem(""));
		fileMenu.add(new JMenuItem(""));
		fileMenu.addSeparator();
		fileMenu.add(closeMI);
		closeMI.addActionListener(this);

		JMenu editMenu = new JMenu("Bearbeiten");
		editMenu.setMnemonic('B');
		editMenu.add(new JMenuItem("Rückgängig"));
		editMenu.add(new JMenuItem("Wiederholen"));
		editMenu.addSeparator();
		editMenu.add(new JMenuItem("Ausschneiden"));
		editMenu.add(new JMenuItem("Kopieren"));
		editMenu.add(new JMenuItem("Office-Zwischenablage"));
		editMenu.add(new JMenuItem("Einfügen"));
		editMenu.add(new JMenuItem("Inhalte einfügen"));
		editMenu.add(new JMenuItem("Als Hyperlink einfügen"));
		editMenu.addSeparator();
		editMenu.add(new JMenuItem("Löschen"));
		editMenu.add(new JMenuItem("Alles markieren"));
		editMenu.addSeparator();
		editMenu.add(new JMenuItem("Suchen..."));
		editMenu.add(new JMenuItem("Ersetzen..."));
		editMenu.add(new JMenuItem("Gehe zu..."));
		editMenu.addSeparator();
		editMenu.add(new JMenuItem("Verknüpfungen..."));
		editMenu.add(new JMenuItem("Objekt"));

		mbar.add(fileMenu);
		mbar.add(editMenu);
		this.setJMenuBar(mbar);

		editorPane = new JTextPane();
		this.add(new JScrollPane(editorPane));

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newMI) {
			this.editorPane.setText("");
		} else if (e.getSource() == openMI) {
			JFileChooser fileDialog = new JFileChooser();
			fileDialog.setFileFilter(new FileFilter() {
				@Override
				public boolean accept(File f) {
					return f.isDirectory() || f.getName().toLowerCase().endsWith(".txt");
				}

				@Override
				public String getDescription() {
					return "Text Files";
				}
			});
			if (fileDialog.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				openFile = fileDialog.getSelectedFile();
				saveMI.setEnabled(true);
				try {
					FileInputStream fis = new FileInputStream(openFile);
					byte[] data = new byte[(int) openFile.length()];
					fis.read(data);
					fis.close();

					editorPane.setText(new String(data, "UTF-8"));
				} catch (Exception e2) {

				}
			}
		} else if (e.getSource() == saveMI) {
			try (FileWriter fw = new FileWriter(openFile)) {
				fw.write(editorPane.getText());
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (e.getSource() == closeMI) {
			int opt = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
			if (opt == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}

}
