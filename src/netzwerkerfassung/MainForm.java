package netzwerkerfassung;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

public class MainForm extends JFrame {
	private JTextField jTfBezeichnung;
	private JLabel jLBezeichnung;
	private JLabel jLRaumNummer;
	private JButton jBtnKomponentenlisteAnzeigenBearbeiten;
	private JLabel jLKomponente;
	private JLabel jLGebaeude;
	private JButton jBtnKomponenteHinzufuegen;
	private JComboBox jCBGebaeude;
	private JComboBox jCBKomponente;
	private JComboBox jCBRaumnummer ;
	private CSVReadWrite csvReaderWriter = new CSVReadWrite();
	private List<Komponente> komponentenListe = new ArrayList<Komponente>();
	
	public MainForm() {
		
		this.komponentenListe = csvReaderWriter.readCSV();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 220);
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
	        jCBKomponente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "C100", "C101", "C102", "C103","C104","C105"}));

		jCBKomponente.setBounds(214, 29, 271, 22);
		contentPane.add(jCBKomponente);
		
		 jLKomponente = new JLabel("Ger\u00E4tetyp");
		jLKomponente.setBounds(214, 13, 56, 16);
		contentPane.add(jLKomponente);
		
		 jCBRaumnummer = new JComboBox() ;	
        jCBRaumnummer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "C100", "C101", "C102", "C103","C104","C105"}));

		jCBRaumnummer.setBounds(214, 81, 271, 22);
		contentPane.add(jCBRaumnummer);
		
		JLabel jLGebaeude = new JLabel("Geb\u00E4ude");
		jLGebaeude.setBounds(28, 64, 56, 16);
		contentPane.add(jLGebaeude);
		
		 jCBGebaeude = new JComboBox();
	        jCBGebaeude.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "C100", "C101", "C102", "C103","C104","C105"}));

		jCBGebaeude.setBounds(28, 81, 174, 22);
		contentPane.add(jCBGebaeude);
		jCBGebaeude.getSelectedIndex();
		
		jBtnKomponenteHinzufuegen = new JButton("Komponente hinzufügen");
		jBtnKomponenteHinzufuegen.setBounds(28, 116, 174, 25);
		contentPane.add(jBtnKomponenteHinzufuegen);
		jBtnKomponenteHinzufuegen.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				jBtnKomponenteHinzufuegenActionPerformed(e);
			}
		});
		jBtnKomponentenlisteAnzeigenBearbeiten = new JButton("Liste Anzeigen/Bearbeiten");
		jBtnKomponentenlisteAnzeigenBearbeiten.setBounds(214, 116, 271, 25);
		contentPane.add(jBtnKomponentenlisteAnzeigenBearbeiten);
		
		jBtnKomponentenlisteAnzeigenBearbeiten = new JButton("Komponentenliste anzeigen/bearbeiten");
		jBtnKomponentenlisteAnzeigenBearbeiten.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jBtnKomponentenlisteAnzeigenbearbeitenActionPerformed(e);
			}
		});
		jBtnKomponentenlisteAnzeigenBearbeiten.setBounds(214, 116, 271, 25);
		contentPane.add(jBtnKomponentenlisteAnzeigenBearbeiten);
	}
	
	private void  jBtnKomponentenlisteAnzeigenbearbeitenActionPerformed(ActionEvent e){
		BearbeitenDialog dialog = new BearbeitenDialog();
		dialog.setVisible(true);
		
	}
	
	private void jBtnKomponenteHinzufuegenActionPerformed(ActionEvent e){
		generateObject();
	}
	
	private void generateObject(){
		
	String bezeichnung = 	jTfBezeichnung.getText();
	String komponentenTyp = jCBKomponente.getSelectedItem().toString();
	String gebaeude = jCBGebaeude.getSelectedItem().toString();
	String raum = jCBRaumnummer.getSelectedItem().toString();
		
	
	Komponente komponente = new Komponente(bezeichnung,  komponentenTyp,  gebaeude,  raum);
	
	System.out.println(komponentenListe.add(komponente));
	
	csvReaderWriter.writeCsvGeraete(komponentenListe);
	}
}
