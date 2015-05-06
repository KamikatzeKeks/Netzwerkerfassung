package netzwerkerfassung;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * 
 * @author Brian Korduan
 *
 */

public class GebaeudeBuilderDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel jLStrasse;
	private JLabel jLGebaeudeBezeichnung;
	private JLabel jLPlz;
	private JLabel jLOrt;
	private JLabel jLRaumanzahl;
	private JTextField jTfGebaeudeBezeichnung;
	private JTextField jTfStrasse;
	private JTextField jTFPostleitZahl;
	private JTextField jTFOrt;
	private JSpinner jSpiRaumAnzahl;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel buttonPane;
	private JButton jBtnGebaeudeHinzufuegen;
	private JButton jBtnOk;
	private JButton jBtnCancel;

	public GebaeudeBuilderDialog() {
		setBounds(100, 100, 400, 500);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 250, 0 };
		gbl_contentPanel.rowHeights = new int[] { 16, 22, 16, 22, 21, 0, 16,
				22, 16, 22, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			jLGebaeudeBezeichnung = new JLabel("Geb\u00E4ude Bezeichnung:");
			GridBagConstraints gbc_jLGebaeudeBezeichnung = new GridBagConstraints();
			gbc_jLGebaeudeBezeichnung.anchor = GridBagConstraints.NORTHWEST;
			gbc_jLGebaeudeBezeichnung.insets = new Insets(0, 0, 5, 0);
			gbc_jLGebaeudeBezeichnung.gridx = 0;
			gbc_jLGebaeudeBezeichnung.gridy = 0;
			contentPanel.add(jLGebaeudeBezeichnung, gbc_jLGebaeudeBezeichnung);
		}

		jTfGebaeudeBezeichnung = new JTextField();
		GridBagConstraints gbc_jTfGebaeudeBezeichnung = new GridBagConstraints();
		gbc_jTfGebaeudeBezeichnung.anchor = GridBagConstraints.NORTH;
		gbc_jTfGebaeudeBezeichnung.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTfGebaeudeBezeichnung.insets = new Insets(0, 0, 5, 0);
		gbc_jTfGebaeudeBezeichnung.gridx = 0;
		gbc_jTfGebaeudeBezeichnung.gridy = 1;
		contentPanel.add(jTfGebaeudeBezeichnung, gbc_jTfGebaeudeBezeichnung);
		jTfGebaeudeBezeichnung.setColumns(10);
		{
			jLStrasse = new JLabel("Stra\u00DFe + Nr:");
			GridBagConstraints gbc_jLStrasse = new GridBagConstraints();
			gbc_jLStrasse.anchor = GridBagConstraints.NORTH;
			gbc_jLStrasse.fill = GridBagConstraints.HORIZONTAL;
			gbc_jLStrasse.insets = new Insets(0, 0, 5, 0);
			gbc_jLStrasse.gridx = 0;
			gbc_jLStrasse.gridy = 2;
			contentPanel.add(jLStrasse, gbc_jLStrasse);
		}

		jTfStrasse = new JTextField();
		GridBagConstraints gbc_jTfStrasse = new GridBagConstraints();
		gbc_jTfStrasse.anchor = GridBagConstraints.NORTH;
		gbc_jTfStrasse.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTfStrasse.insets = new Insets(0, 0, 5, 0);
		gbc_jTfStrasse.gridx = 0;
		gbc_jTfStrasse.gridy = 3;
		contentPanel.add(jTfStrasse, gbc_jTfStrasse);
		jTfStrasse.setColumns(10);
		{
			jLPlz = new JLabel("PLZ: ");
			GridBagConstraints gbc_jLPlz = new GridBagConstraints();
			gbc_jLPlz.anchor = GridBagConstraints.NORTHWEST;
			gbc_jLPlz.insets = new Insets(0, 0, 5, 0);
			gbc_jLPlz.gridx = 0;
			gbc_jLPlz.gridy = 4;
			contentPanel.add(jLPlz, gbc_jLPlz);
		}

		jTFPostleitZahl = new JTextField();
		GridBagConstraints gbc_jTFPostleitZahl = new GridBagConstraints();
		gbc_jTFPostleitZahl.anchor = GridBagConstraints.SOUTH;
		gbc_jTFPostleitZahl.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTFPostleitZahl.insets = new Insets(0, 0, 5, 0);
		gbc_jTFPostleitZahl.gridx = 0;
		gbc_jTFPostleitZahl.gridy = 5;
		contentPanel.add(jTFPostleitZahl, gbc_jTFPostleitZahl);
		jTFPostleitZahl.setColumns(10);
		{
			jLOrt = new JLabel("Ort:");
			GridBagConstraints gbc_jLOrt = new GridBagConstraints();
			gbc_jLOrt.anchor = GridBagConstraints.NORTHWEST;
			gbc_jLOrt.insets = new Insets(0, 0, 5, 0);
			gbc_jLOrt.gridx = 0;
			gbc_jLOrt.gridy = 6;
			contentPanel.add(jLOrt, gbc_jLOrt);
		}
		{
			jTFOrt = new JTextField();
			GridBagConstraints gbc_jTFOrt = new GridBagConstraints();
			gbc_jTFOrt.anchor = GridBagConstraints.NORTH;
			gbc_jTFOrt.fill = GridBagConstraints.HORIZONTAL;
			gbc_jTFOrt.insets = new Insets(0, 0, 5, 0);
			gbc_jTFOrt.gridx = 0;
			gbc_jTFOrt.gridy = 7;
			contentPanel.add(jTFOrt, gbc_jTFOrt);
			jTFOrt.setColumns(10);
		}
		{
			jLRaumanzahl = new JLabel("Raumanzahl:");
			GridBagConstraints gbc_jLRaumanzahl = new GridBagConstraints();
			gbc_jLRaumanzahl.anchor = GridBagConstraints.NORTHWEST;
			gbc_jLRaumanzahl.insets = new Insets(0, 0, 5, 0);
			gbc_jLRaumanzahl.gridx = 0;
			gbc_jLRaumanzahl.gridy = 8;
			contentPanel.add(jLRaumanzahl, gbc_jLRaumanzahl);
		}
		{
			
		}
		{
			jSpiRaumAnzahl = new JSpinner();
			jSpiRaumAnzahl.setModel(new SpinnerNumberModel(1, 1,99999, 1));
			GridBagConstraints gbc_jSpiRaumAnzahl = new GridBagConstraints();
			gbc_jSpiRaumAnzahl.insets = new Insets(0, 0, 5, 0);
			gbc_jSpiRaumAnzahl.anchor = GridBagConstraints.NORTHWEST;
			gbc_jSpiRaumAnzahl.gridx = 0;
			gbc_jSpiRaumAnzahl.gridy = 9;
			contentPanel.add(jSpiRaumAnzahl, gbc_jSpiRaumAnzahl);
		}
		{
			scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 0;
			gbc_scrollPane.gridy = 10;
			contentPanel.add(scrollPane, gbc_scrollPane);
			{
				table = new JTable();
				scrollPane.setViewportView(table);
			}
		}
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				jBtnGebaeudeHinzufuegen = new JButton("Gebäude hinzufügen");
				jBtnGebaeudeHinzufuegen
						.addActionListener(e -> jBtnGebaeudeHinzufuegenActionPerformed(e));
				buttonPane.add(jBtnGebaeudeHinzufuegen);
			}
			{
				jBtnOk = new JButton("OK");
				jBtnOk.setActionCommand("OK");
				jBtnOk.addActionListener(e -> jBtnOkActionPerformed(e));
				buttonPane.add(jBtnOk);
				getRootPane().setDefaultButton(jBtnOk);
			}
			{
				jBtnCancel = new JButton("Cancel");
				jBtnCancel.setActionCommand("Cancel");
				jBtnCancel.addActionListener(e -> jBtnCancelActionPerformed(e));
				buttonPane.add(jBtnCancel);
			}
		}
	}

	private void jBtnGebaeudeHinzufuegenActionPerformed(ActionEvent e) {
		List<Gebaeude> gebaeudeListe = new ArrayList<>();
		try {

			gebaeudeListe = CSVReadWrite.readCSVGebaeude();

		} catch (Exception ex) {

			if (CSVReadWrite.doesFileExist("Gebaeude.csv") == true) {
				System.out.println("Gebaeude.csv existiert bereits");
			} else {
				CSVReadWrite.createFile("Gebaeude.csv");
			}

			// ex.printStackTrace();

		} finally {
			gebaeudeListe.add(new Gebaeude(jTfGebaeudeBezeichnung.getText(),
					jTfStrasse.getText(), jTFPostleitZahl.getText(), jTFOrt
							.getText(), (int) jSpiRaumAnzahl.getValue()));

			CSVReadWrite.writeCSVGebaeude(gebaeudeListe);
		}
	}

	private void jBtnOkActionPerformed(ActionEvent e) {

	}

	private void jBtnCancelActionPerformed(ActionEvent e) {

	}

	public void showDialog() {

		this.setVisible(true);

	}


}
