package gui;

import gebaeude.Gebaeude;
import gebaeude.Raum;

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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.SwingConstants;

import readerWriter.CSVReadWrite;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import komponenten.Komponente;

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
	private JButton jBtnAenderungenUebernehmen;
	private JComboBox<Gebaeude> jCBGebaeude;
	private JComboBox<Komponente> jCBKomponente;
	private JComboBox<Raum> jCBRaumnummer;
	private JTable jTableKomponentenListe;
	private JScrollPane jScPaTableView;
	private JButton jBtnGebaeudeVerwalten;
	private Object col[] = { "Bezeichnung", "KomponentenTyp", "Gebäude", "Raum" };
	private DefaultTableModel jDefaultTableModel = new DefaultTableModel(col, 0);

	public MainForm() {

		{
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 690, 536);
			setMinimumSize(new Dimension(690, 500));
			JPanel contentPane = new JPanel();
			contentPane.setSize(new Dimension(150, 60));
			contentPane.setMinimumSize(new Dimension(150, 10));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			GridBagLayout gbl_contentPane = new GridBagLayout();
			gbl_contentPane.columnWidths = new int[] { 191, 250, 179, 0 };
			gbl_contentPane.rowHeights = new int[] { 16, 20, 16, 20, 16, 20,
					16, 20, 23, 230, 23, 0 };
			gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0,
					Double.MIN_VALUE };
			gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
					0.0, 0.0, 0.0, 0.0, 0.0, 5.0, 0.0, Double.MIN_VALUE };
			contentPane.setLayout(gbl_contentPane);

			jLBezeichnung = new JLabel("Bezeichnung");
			jLBezeichnung.setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints gbc_jLBezeichnung = new GridBagConstraints();
			gbc_jLBezeichnung.anchor = GridBagConstraints.NORTHWEST;
			gbc_jLBezeichnung.insets = new Insets(0, 0, 5, 5);
			gbc_jLBezeichnung.gridx = 0;
			gbc_jLBezeichnung.gridy = 0;
			contentPane.add(jLBezeichnung, gbc_jLBezeichnung);

			jTfBezeichnung = new JTextField();
			GridBagConstraints gbc_jTfBezeichnung = new GridBagConstraints();
			gbc_jTfBezeichnung.fill = GridBagConstraints.BOTH;
			gbc_jTfBezeichnung.insets = new Insets(0, 0, 5, 0);
			gbc_jTfBezeichnung.gridwidth = 3;
			gbc_jTfBezeichnung.gridx = 0;
			gbc_jTfBezeichnung.gridy = 1;
			contentPane.add(jTfBezeichnung, gbc_jTfBezeichnung);
			jTfBezeichnung.setColumns(10);

			jLKomponente = new JLabel("Gerätetyp");
			GridBagConstraints gbc_jLKomponente = new GridBagConstraints();
			gbc_jLKomponente.anchor = GridBagConstraints.NORTHWEST;
			gbc_jLKomponente.insets = new Insets(0, 0, 5, 5);
			gbc_jLKomponente.gridx = 0;
			gbc_jLKomponente.gridy = 2;
			contentPane.add(jLKomponente, gbc_jLKomponente);

			jCBKomponente = new JComboBox<>();
			jCBKomponente.setModel(new javax.swing.DefaultComboBoxModel(
					new String[] { "Desktop PC", "Server", "Laptop", "Switch",
							"Router", "Anderes" }));
			GridBagConstraints gbc_jCBKomponente = new GridBagConstraints();
			gbc_jCBKomponente.fill = GridBagConstraints.BOTH;
			gbc_jCBKomponente.insets = new Insets(0, 0, 5, 0);
			gbc_jCBKomponente.gridwidth = 3;
			gbc_jCBKomponente.gridx = 0;
			gbc_jCBKomponente.gridy = 3;
			contentPane.add(jCBKomponente, gbc_jCBKomponente);

			jLGebaeude = new JLabel("Geb\u00E4ude");
			GridBagConstraints gbc_jLGebaeude = new GridBagConstraints();
			gbc_jLGebaeude.anchor = GridBagConstraints.NORTHWEST;
			gbc_jLGebaeude.insets = new Insets(0, 0, 5, 5);
			gbc_jLGebaeude.gridx = 0;
			gbc_jLGebaeude.gridy = 4;
			contentPane.add(jLGebaeude, gbc_jLGebaeude);

			jCBGebaeude = new JComboBox<>();
			jCBGebaeude.addItemListener(e -> jCbGebaeudeItemChanged(e));
			GridBagConstraints gbc_jCBGebaeude = new GridBagConstraints();
			gbc_jCBGebaeude.fill = GridBagConstraints.BOTH;
			gbc_jCBGebaeude.insets = new Insets(0, 0, 5, 0);
			gbc_jCBGebaeude.gridwidth = 3;
			gbc_jCBGebaeude.gridx = 0;
			gbc_jCBGebaeude.gridy = 5;
			contentPane.add(jCBGebaeude, gbc_jCBGebaeude);
			jCBGebaeude.getSelectedIndex();

			jLRaumNummer = new JLabel("Raumnummer");
			GridBagConstraints gbc_jLRaumNummer = new GridBagConstraints();
			gbc_jLRaumNummer.anchor = GridBagConstraints.NORTHWEST;
			gbc_jLRaumNummer.insets = new Insets(0, 0, 5, 5);
			gbc_jLRaumNummer.gridx = 0;
			gbc_jLRaumNummer.gridy = 6;
			contentPane.add(jLRaumNummer, gbc_jLRaumNummer);

			jCBRaumnummer = new JComboBox<>();
			GridBagConstraints gbc_jCBRaumnummer = new GridBagConstraints();
			gbc_jCBRaumnummer.fill = GridBagConstraints.BOTH;
			gbc_jCBRaumnummer.insets = new Insets(0, 0, 5, 0);
			gbc_jCBRaumnummer.gridwidth = 3;
			gbc_jCBRaumnummer.gridx = 0;
			gbc_jCBRaumnummer.gridy = 7;
			contentPane.add(jCBRaumnummer, gbc_jCBRaumnummer);

			jBtnKomponenteHinzufuegen = new JButton("Komponente hinzufügen");
			GridBagConstraints gbc_jBtnKomponenteHinzufuegen = new GridBagConstraints();
			gbc_jBtnKomponenteHinzufuegen.fill = GridBagConstraints.BOTH;
			gbc_jBtnKomponenteHinzufuegen.insets = new Insets(0, 0, 5, 0);
			gbc_jBtnKomponenteHinzufuegen.gridwidth = 3;
			gbc_jBtnKomponenteHinzufuegen.gridx = 0;
			gbc_jBtnKomponenteHinzufuegen.gridy = 8;
			contentPane.add(jBtnKomponenteHinzufuegen,
					gbc_jBtnKomponenteHinzufuegen);
			jBtnKomponenteHinzufuegen
					.addActionListener(e -> jBtnKomponenteHinzufuegenActionPerformed(e));

			jTableKomponentenListe = new JTable(jDefaultTableModel);
			jTableKomponentenListe.setColumnSelectionAllowed(false);
			jTableKomponentenListe.setDragEnabled(false);
			fillTable();

			jScPaTableView = new JScrollPane(jTableKomponentenListe);
			GridBagConstraints gbc_jScPaTableView = new GridBagConstraints();
			gbc_jScPaTableView.fill = GridBagConstraints.BOTH;
			gbc_jScPaTableView.insets = new Insets(0, 0, 5, 0);
			gbc_jScPaTableView.gridwidth = 3;
			gbc_jScPaTableView.gridx = 0;
			gbc_jScPaTableView.gridy = 9;
			contentPane.add(jScPaTableView, gbc_jScPaTableView);

			jBtnAenderungenUebernehmen = new JButton("Änderungen Übernehmen");
			GridBagConstraints gbc_jBtnAenderungenUebernehmen = new GridBagConstraints();
			gbc_jBtnAenderungenUebernehmen.anchor = GridBagConstraints.SOUTH;
			gbc_jBtnAenderungenUebernehmen.fill = GridBagConstraints.HORIZONTAL;
			gbc_jBtnAenderungenUebernehmen.insets = new Insets(0, 0, 0, 5);
			gbc_jBtnAenderungenUebernehmen.gridx = 0;
			gbc_jBtnAenderungenUebernehmen.gridy = 10;
			gbc_jBtnAenderungenUebernehmen.weightx = 1;
			contentPane.add(jBtnAenderungenUebernehmen,
					gbc_jBtnAenderungenUebernehmen);
			jBtnAenderungenUebernehmen
					.addActionListener(e -> jBtnAenderungenUebernehmenActionPerformed(e));

			jBtnAuswahlLoeschen = new JButton("Ausgewähltes Objekt löschen");
			GridBagConstraints gbc_jBtnAuswahlLoeschen = new GridBagConstraints();
			gbc_jBtnAuswahlLoeschen.anchor = GridBagConstraints.SOUTH;
			gbc_jBtnAuswahlLoeschen.fill = GridBagConstraints.HORIZONTAL;
			gbc_jBtnAuswahlLoeschen.insets = new Insets(0, 0, 0, 5);
			gbc_jBtnAuswahlLoeschen.gridx = 1;
			gbc_jBtnAuswahlLoeschen.gridy = 10;
			gbc_jBtnAuswahlLoeschen.weightx = 1;
			contentPane.add(jBtnAuswahlLoeschen, gbc_jBtnAuswahlLoeschen);
			jBtnAuswahlLoeschen
					.addActionListener(e -> jBtnAuswahlLoeschenActionPerformed(e));

			jBtnGebaeudeVerwalten = new JButton("Geb\u00E4ude verwalten");
			jBtnGebaeudeVerwalten
					.addActionListener(e -> jBtnGebaeudeVerwaltenActionPerformed(e));
			GridBagConstraints gbc_jBtnGebaeudeVerwalten = new GridBagConstraints();
			gbc_jBtnGebaeudeVerwalten.anchor = GridBagConstraints.SOUTH;
			gbc_jBtnGebaeudeVerwalten.fill = GridBagConstraints.HORIZONTAL;
			gbc_jBtnGebaeudeVerwalten.gridx = 2;
			gbc_jBtnGebaeudeVerwalten.gridy = 10;
			gbc_jBtnGebaeudeVerwalten.weightx = 1;
			contentPane.add(jBtnGebaeudeVerwalten, gbc_jBtnGebaeudeVerwalten);

			readBuildings();
			readRooms();

		}
	}
	
	
	private void jBtnGebaeudeVerwaltenActionPerformed(ActionEvent e) {
		GebaeudeBuilderDialog dialog = new GebaeudeBuilderDialog();
		dialog.showDialog();
		CSVvalidator.checkGebaeudeKomponenteAssociation();
		readBuildings();
		readRooms();
		fillTable();

	}

	private void jBtnAuswahlLoeschenActionPerformed(ActionEvent e) {
		int[] selectedRows = jTableKomponentenListe.getSelectedRows();
		if (selectedRows.length > 0) {
			for (int i = selectedRows.length - 1; i >= 0; i--) {
				jDefaultTableModel.removeRow(selectedRows[i]);
			}
		}
		aenderungenUebernehmen();
	}

	private void jBtnAenderungenUebernehmenActionPerformed(ActionEvent e) {
		aenderungenUebernehmen();

	}

	private void jBtnKomponenteHinzufuegenActionPerformed(ActionEvent e) {
		addKomponenteToList();
		jDefaultTableModel.setRowCount(0);
		fillTable();
	}

	private void jCbGebaeudeItemChanged(ItemEvent e) {
		readRooms();
	}
	
	/**
	 * Liest alle EInträge aus der Tabelle und speichert sie in der CSV 
	 * 
	 */

	private void aenderungenUebernehmen() {
		List<Komponente> liste = new ArrayList<>();

		for (int i = 0; i < jDefaultTableModel.getRowCount(); i++) {

			liste.add(new Komponente(jDefaultTableModel.getValueAt(i, 0)
					.toString(),
					jDefaultTableModel.getValueAt(i, 1).toString(),
					jDefaultTableModel.getValueAt(i, 2).toString(),
					jDefaultTableModel.getValueAt(i, 3).toString()));
		}

		CSVReadWrite.writeCsvGeraete(liste);
	}
	
	private void addKomponenteToList() {

		List<Komponente> komponentenListe = new ArrayList<>();
		komponentenListe = CSVReadWrite.readCSV();
		komponentenListe.add(new Komponente(jTfBezeichnung.getText(),
				jCBKomponente.getSelectedItem().toString(), jCBGebaeude
						.getSelectedItem().toString(), jCBRaumnummer
						.getSelectedItem().toString()));

		CSVReadWrite.writeCsvGeraete(komponentenListe);
	}

	/**
	 * Liest die Gebäude und speichert die Objekte in der ComboBox
	 * 
	 */
	
	private void readBuildings() {
		List<Object> gebaeudeBezeichnungen = new ArrayList<>();
		try {
			for (Gebaeude gebaeude : CSVReadWrite.readCSVGebaeude()) {
				gebaeudeBezeichnungen.add(gebaeude);
			}
		} catch (Exception e) {
			System.out.println("fehler beim lesen der Gebäude");
		} finally {
			jCBGebaeude.setModel(new javax.swing.DefaultComboBoxModel(
					gebaeudeBezeichnungen.toArray()));
		}
	}

	/**
	 * Liest die Räume und speichert die Objekte in der ComboBox
	 * 
	 */
	
	private void readRooms() {

		List<Raum> raumListe = new ArrayList<>();
		try {
			Gebaeude gebaeude = (Gebaeude) jCBGebaeude.getSelectedItem();

			raumListe = gebaeude.getListRaeume();

		} catch (Exception e) {
				System.out.println("Keine Räume vorhanden");
		} finally {
			jCBRaumnummer.setModel(new javax.swing.DefaultComboBoxModel(
					raumListe.toArray()));
		}
	}
	
	/**
	 * Aktualisiert die Tabellenansicht
	 * 
	 * 
	 */
	private void fillTable() {
		jDefaultTableModel.setRowCount(0);
		for (Komponente komponente : CSVReadWrite.readCSV()) {

			Object[] data = { komponente.getBezeichnung(),
					komponente.getKomponentenTyp(), komponente.getGebaeude(),
					komponente.getRaum() };

			jDefaultTableModel.addRow(data);

		}

	}

}
