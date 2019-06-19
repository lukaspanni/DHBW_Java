package dhbw.exercise.ui;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class EditorSimple extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new EditorSimple();
	}

	public EditorSimple() {
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Editor");
		this.setSize(500, 300);

		JMenuBar mbar = new JMenuBar();
		JMenu fileMenu = new JMenu("Datei");
		fileMenu.setMnemonic('D');
		fileMenu.add(new JMenuItem("Neu"));
		fileMenu.add(new JMenuItem("Öffnen"));
		fileMenu.addSeparator();
		fileMenu.add(new JMenuItem("Schließen"));
		fileMenu.addSeparator();
		fileMenu.add(new JMenuItem("Speichern"));
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
		fileMenu.add(new JMenuItem("Beenden"));

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

		this.setVisible(true);
	}

}
