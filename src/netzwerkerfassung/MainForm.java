package netzwerkerfassung;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

/**
 * Diese Klasse(und das restliche Programm) wurde aufgrund von Zeitmangel quick
 * and dirty geschrieben Besonders bei dieser Frame möchte ich darauf hinweisen,
 * dass uns bewusst ist, dass normalerweise gewisse Prozesse in eigene Klassen
 * ausgelagert werden. Da es sich noch um die frühste lauffähige Version handelt
 * ist dies noch nicht geschehen.
 * 
 * 
 * 
 * @author Brian Korduan
 *
 */

public class MainForm extends JFrame {

	private JLabel jLBezeichnung;
	private JLabel jLRaumNummer;
	private JLabel jLKomponente;
	private JLabel jLGebaeude;
	private JTextField jTfBezeichnung;
	private JButton jBtnAuswahlLoeschen;
	private JButton jBtnKomponenteHinzufuegen;
	private JComboBox<Gebaeude> jCBGebaeude;
	private JComboBox<Komponente> jCBKomponente;
	private JComboBox<Raum> jCBRaumnummer;
	private List<Komponente> komponentenListe = new ArrayList<Komponente>();
	private JTable jTableKomponentenListe;
	private DefaultTableModel jDefaultTableModel;
	private JScrollPane jScPaTableView;

	public MainForm() {

		this.komponentenListe = CSVReadWrite.readCSV();
		{
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 689, 494);
			JPanel contentPane = new JPanel();
			contentPane.setSize(new Dimension(150, 60));
			contentPane.setMinimumSize(new Dimension(150, 10));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
		
			jLGebaeude = new JLabel("Geb\u00E4ude");
			jLGebaeude.setBounds(28, 64, 56, 16);
			contentPane.add(jLGebaeude);
			
			jLBezeichnung = new JLabel("Bezeichnung");
			jLBezeichnung.setBounds(30, 13, 114, 16);
			contentPane.add(jLBezeichnung);
			
			jLRaumNummer = new JLabel("Raumnummer");
			jLRaumNummer.setBounds(214, 64, 116, 16);
			contentPane.add(jLRaumNummer);
			
			jLKomponente = new JLabel("Ger\u00E4tetyp");
			jLKomponente.setBounds(214, 13, 56, 16);
			contentPane.add(jLKomponente);
		
			jTfBezeichnung = new JTextField();
			jTfBezeichnung.setBounds(28, 29, 174, 22);
			contentPane.add(jTfBezeichnung);
			jTfBezeichnung.setColumns(10);
	
			
			jCBKomponente = new JComboBox<>();
			jCBKomponente.setBounds(214, 29, 271, 22);
			jCBKomponente.setModel(new javax.swing.DefaultComboBoxModel(
					new String[] { "Desktop PC", "Server", "Laptop", "Switch",
							"Router", "Anderes" }));
			contentPane.add(jCBKomponente);
		
		
			jCBGebaeude = new JComboBox<>();
			readBuildings();
			jCBGebaeude.addItemListener(e -> jCbGebaeudeItemChanged(e));


			jCBRaumnummer = new JComboBox<>();
			readRooms();
			jCBRaumnummer.setBounds(214, 81, 271, 22);
			contentPane.add(jCBRaumnummer);
		
		
			jCBGebaeude.setBounds(28, 81, 174, 22);
			contentPane.add(jCBGebaeude);
			jCBGebaeude.getSelectedIndex();
			
			JButton jBtnAenderungenUebernehmen = new JButton("Änderungen Übernehmen");
			jBtnAenderungenUebernehmen.setBounds(28, 401, 185, 23);
			contentPane.add(jBtnAenderungenUebernehmen);
			jBtnAenderungenUebernehmen.addActionListener(e-> jBtnAenderungenUebernehmenActionPerformed(e));
	
		
			jBtnKomponenteHinzufuegen = new JButton("Komponente hinzufügen");
			jBtnKomponenteHinzufuegen.setBounds(28, 116, 457, 25);
			contentPane.add(jBtnKomponenteHinzufuegen);
			jBtnKomponenteHinzufuegen.addActionListener(e -> jBtnKomponenteHinzufuegenActionPerformed(e));

			
			jBtnAuswahlLoeschen = new JButton("Ausgewähltes Objekt löschen");
			jBtnAuswahlLoeschen.setBounds(228, 401, 230, 23);
			contentPane.add(jBtnAuswahlLoeschen);
			jBtnAuswahlLoeschen.addActionListener(e -> jBtnAuswahlLoeschenActionPerformed(e));

			
			JButton jBtnGebaeudeBearbeiten = new JButton(
					"Geb\u00E4ude Bearbeiten");
			jBtnGebaeudeBearbeiten.setBounds(470, 400, 168, 25);
			contentPane.add(jBtnGebaeudeBearbeiten);
			
		
		
			Object col[] = { "Bezeichnung", "KomponentenTyp", "Gebäude", "Raum" };
			jDefaultTableModel = new DefaultTableModel(col, 0);
			fillTable();

			jTableKomponentenListe = new JTable(jDefaultTableModel);
			jTableKomponentenListe.setColumnSelectionAllowed(true);
			jTableKomponentenListe.setBounds(28, 152, 457, 228);
		
		
			jScPaTableView = new JScrollPane(jTableKomponentenListe);
			jScPaTableView.setBounds(28, 152, 610, 239);
			contentPane.add(jScPaTableView);
		
		}
	}

	private void readBuildings() {
		Object[] gebaeudeBezeichnungen = new Object[50];

		int i = 0;
		for (Gebaeude gebaeude : CSVReadWrite.readCSVGebaeude()) {

			gebaeudeBezeichnungen[i] = gebaeude;
			i++;
		}
		jCBGebaeude.setModel(new javax.swing.DefaultComboBoxModel(
				gebaeudeBezeichnungen));
	}

	private void readRooms() {

		List<Raum> raumListe = new ArrayList<>();

		Gebaeude gebaeude = (Gebaeude) jCBGebaeude.getSelectedItem();

		raumListe = gebaeude.getListRaeume();

		jCBRaumnummer.setModel(new javax.swing.DefaultComboBoxModel(raumListe.toArray()));

	}

	private void fillTable() {

		for (Komponente komponente : CSVReadWrite.readCSV()) {

			String bezeichnung = komponente.getBezeichnung();
			String komponentenTyp = komponente.getKomponentenTyp();
			String gebaeude = komponente.getGebaeude();
			String raum = komponente.getRaum();

			Object[] data = { bezeichnung, komponentenTyp, gebaeude, raum };

			jDefaultTableModel.addRow(data);
		}

	}

	private void jBtnAuswahlLoeschenActionPerformed(ActionEvent e) {

		deleteRow();
	}

	private void jBtnAenderungenUebernehmenActionPerformed(ActionEvent e) {
		aenderungenUebernehmen();

	}
	
	private void jBtnKomponenteHinzufuegenActionPerformed(ActionEvent e) {
		generateObject();
		jDefaultTableModel.setRowCount(0);
		fillTable();
	}
	
	private void jCbGebaeudeItemChanged(ItemEvent e) {
		readRooms();
	}

	private void aenderungenUebernehmen() {
		String bezeichnung;
		String komponentenTyp;
		String gebaeude;
		String raum;

		File file = new File("data.csv");

		file.delete();

		komponentenListe.clear();

		for (int i = 0; i < jDefaultTableModel.getRowCount(); i++) {
			System.out.println(jDefaultTableModel.getRowCount());
			bezeichnung = jDefaultTableModel.getValueAt(i, 0).toString();
			komponentenTyp = jDefaultTableModel.getValueAt(i, 1).toString();
			gebaeude = jDefaultTableModel.getValueAt(i, 2).toString();
			raum = jDefaultTableModel.getValueAt(i, 3).toString();

			System.out.println(bezeichnung + komponentenTyp + gebaeude + raum);

			Komponente komponente = new Komponente(bezeichnung, komponentenTyp,
					gebaeude, raum);

			System.out.println("hinzugefügt: "
					+ komponentenListe.add(komponente));

		}

		CSVReadWrite.writeCsvGeraete(komponentenListe);
	}

	private void deleteRow() {

		int[] selectedRows = jTableKomponentenListe.getSelectedRows();
		if (selectedRows.length > 0) {
			for (int i = selectedRows.length - 1; i >= 0; i--) {
				jDefaultTableModel.removeRow(selectedRows[i]);
			}
		}

		aenderungenUebernehmen();

	}

	private void generateObject() {

		String bezeichnung = jTfBezeichnung.getText();
		String komponentenTyp = jCBKomponente.getSelectedItem().toString();
		String gebaeude = jCBGebaeude.getSelectedItem().toString();
		String raum = jCBRaumnummer.getSelectedItem().toString();
		Komponente komponente = new Komponente(bezeichnung, komponentenTyp,
				gebaeude, raum);

		System.out.println("hinzugefügt: " + komponentenListe.add(komponente));

		CSVReadWrite.writeCsvGeraete(komponentenListe);
	}
	
	
}
