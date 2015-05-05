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

	private JTextField jTfBezeichnung;
	private JLabel jLBezeichnung;
	private JLabel jLRaumNummer;
	private JLabel jLKomponente;
	private JLabel jLGebaeude;
	private JButton jBtnKomponenteHinzufuegen;
	private JComboBox jCBGebaeude;
	private JComboBox jCBKomponente;
	private JComboBox jCBRaumnummer;
	private CSVReadWrite csvReaderWriter = new CSVReadWrite();
	private List<Komponente> komponentenListe = new ArrayList<Komponente>();
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JButton jBtnAuswahlLoeschen;

	public MainForm() {

		this.komponentenListe = csvReaderWriter.readCSV();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 494);
		JPanel contentPane = new JPanel();
		contentPane.setSize(new Dimension(150, 60));
		contentPane.setMinimumSize(new Dimension(150, 10));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		jTfBezeichnung = new JTextField();
		jTfBezeichnung.setBounds(28, 29, 174, 22);
		contentPane.add(jTfBezeichnung);
		jTfBezeichnung.setColumns(10);

		jLBezeichnung = new JLabel("Bezeichnung");
		jLBezeichnung.setBounds(30, 13, 114, 16);
		contentPane.add(jLBezeichnung);

		jLRaumNummer = new JLabel("Raumnummer");
		jLRaumNummer.setBounds(214, 64, 116, 16);
		contentPane.add(jLRaumNummer);

		jCBKomponente = new JComboBox();
		jCBKomponente.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "Desktop PC", "Server", "Laptop", "Switch",
						"Router", "Anderes" }));

		jCBKomponente.setBounds(214, 29, 271, 22);
		contentPane.add(jCBKomponente);

		jLKomponente = new JLabel("Ger\u00E4tetyp");
		jLKomponente.setBounds(214, 13, 56, 16);
		contentPane.add(jLKomponente);

		jCBGebaeude = new JComboBox();
		jCBGebaeude.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				jCbGebaeudeItemChanged(e);
			}
		});
		readBuildings();
		
		jCBRaumnummer = new JComboBox();
		readRooms();

		jCBRaumnummer.setBounds(214, 81, 271, 22);
		contentPane.add(jCBRaumnummer);

		JLabel jLGebaeude = new JLabel("Geb\u00E4ude");
		jLGebaeude.setBounds(28, 64, 56, 16);
		contentPane.add(jLGebaeude);

//		jCBGebaeude = new JComboBox();
//		readBuildings();
//		jCBGebaeude.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
//				"G1", "G2", "G3" }));

		jCBGebaeude.setBounds(28, 81, 174, 22);
		contentPane.add(jCBGebaeude);
		jCBGebaeude.getSelectedIndex();

		jBtnKomponenteHinzufuegen = new JButton("Komponente hinzufügen");
		jBtnKomponenteHinzufuegen.setBounds(28, 116, 457, 25);
		contentPane.add(jBtnKomponenteHinzufuegen);
		jBtnKomponenteHinzufuegen.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				jBtnKomponenteHinzufuegenActionPerformed(e);
			}
		});

		Object col[] = { "Bezeichnung", "KomponentenTyp", "Gebäude", "Raum" };
		tableModel = new DefaultTableModel(col, 0);
		fillTable();

		table = new JTable(tableModel);
		table.setColumnSelectionAllowed(true);
		table.setBounds(28, 152, 457, 228);

		// contentPane.add(table);

		scrollPane_1 = new JScrollPane(table);
		scrollPane_1.setBounds(28, 152, 610, 239);
		contentPane.add(scrollPane_1);

		JButton jBtnAenderungenUebernehmen = new JButton(
				"Änderungen Übernehmen");
		jBtnAenderungenUebernehmen.setBounds(28, 401, 185, 23);
		contentPane.add(jBtnAenderungenUebernehmen);
		jBtnAenderungenUebernehmen.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				jBtnAenderungenUebernehmenActionPerformed(e);
			}
		});

		jBtnAuswahlLoeschen = new JButton(
				"Ausgew\u00E4hltes Objekt L\u00F6schen");
		jBtnAuswahlLoeschen.setBounds(228, 401, 230, 23);
		contentPane.add(jBtnAuswahlLoeschen);
		
		JButton jBtnGebaeudeBearbeiten = new JButton("Geb\u00E4ude Bearbeiten");
		jBtnGebaeudeBearbeiten.setBounds(470, 400, 168, 25);
		contentPane.add(jBtnGebaeudeBearbeiten);
		jBtnAuswahlLoeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jBtnAuswahlLoeschenActionPerformed(e);
			}
		});
		
		//Die Coole Version eines ActionListeners ab 1.8 lamda methoden
		//jBtnAuswahlLoeschen.addActionListener(e -> jBtnAuswahlLoeschenActionPerformed(e));

	}
	
	private void readBuildings(){
		Object[]  gebaeudeBezeichnungen = new Object[50];

		int i = 0;
		for (Gebaeude gebaeude : CSVReadWrite.readCSVGebaeude()) {
			
		
			gebaeudeBezeichnungen[i]= gebaeude;
			i++;
		}
		jCBGebaeude.setModel(new javax.swing.DefaultComboBoxModel(gebaeudeBezeichnungen));	
	}
	
	private void readRooms(){
		
		List<Raum> raumListe = new ArrayList<>();
		
		Gebaeude gebaeude =  (Gebaeude)jCBGebaeude.getSelectedItem();
		
			
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

			tableModel.addRow(data);
		}

	}

	private void jBtnAuswahlLoeschenActionPerformed(ActionEvent e) {

		deleteRow();
	}

	private void jBtnAenderungenUebernehmenActionPerformed(ActionEvent e) {
		aenderungenUebernehmen();

	}

	private void aenderungenUebernehmen() {
		String bezeichnung;
		String komponentenTyp;
		String gebaeude;
		String raum;

		File file = new File("data.csv");

		file.delete();

		komponentenListe.clear();

		for (int i = 0; i < tableModel.getRowCount(); i++) {
			System.out.println(tableModel.getRowCount());
			bezeichnung = tableModel.getValueAt(i, 0).toString();
			komponentenTyp = tableModel.getValueAt(i, 1).toString();
			gebaeude = tableModel.getValueAt(i, 2).toString();
			raum = tableModel.getValueAt(i, 3).toString();

			System.out.println(bezeichnung + komponentenTyp + gebaeude + raum);

			Komponente komponente = new Komponente(bezeichnung, komponentenTyp,
					gebaeude, raum);

			System.out.println("hinzugefügt: "
					+ komponentenListe.add(komponente));

		}

		CSVReadWrite.writeCsvGeraete(komponentenListe);
	}
	
	private void jCbGebaeudeItemChanged(ItemEvent e){
		readRooms();
	}

	private void jBtnKomponenteHinzufuegenActionPerformed(ActionEvent e) {
		generateObject();
		tableModel.setRowCount(0);
		fillTable();
	}

	private void deleteRow() {

		int[] selectedRows = table.getSelectedRows();
		if (selectedRows.length > 0) {
			for (int i = selectedRows.length - 1; i >= 0; i--) {
				tableModel.removeRow(selectedRows[i]);
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

		csvReaderWriter.writeCsvGeraete(komponentenListe);
	}
}
