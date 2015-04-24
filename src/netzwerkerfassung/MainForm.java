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

public class MainForm extends JFrame {
	private JTextField jTfBezeichnung;
	private JLabel jLBezeichnung;
	private JLabel jLRaumNummer;
	private JButton btnKomponentenlisteAnzeigenbearbeiten;
	private JLabel jLKomponente;
	JLabel jLGebaeude;
	JButton jBtnKomponenteHinzufuegen;
	JComboBox jCBGebaeude;
	JComboBox jCBKomponente;
	JComboBox jCBRaumnummer ;
	/**
	 * Launch the application.
	 */
	


	/**
	 * Create the frame.
	 */
	public MainForm() {
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
		jCBGebaeude.setBounds(28, 81, 174, 22);
		contentPane.add(jCBGebaeude);
		jCBGebaeude.getSelectedIndex();
		
		jBtnKomponenteHinzufuegen = new JButton();
		jBtnKomponenteHinzufuegen.setBounds(28, 116, 174, 25);
		contentPane.add(jBtnKomponenteHinzufuegen);
		jBtnKomponenteHinzufuegen.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				jBtnKomponenteHinzufuegenActionPerformed(e);
			}
		});
		btnKomponentenlisteAnzeigenbearbeiten = new JButton();
		btnKomponentenlisteAnzeigenbearbeiten.setBounds(214, 116, 271, 25);
		contentPane.add(btnKomponentenlisteAnzeigenbearbeiten);
		
		btnKomponentenlisteAnzeigenbearbeiten = new JButton("Komponentenliste anzeigen/bearbeiten");
		btnKomponentenlisteAnzeigenbearbeiten.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jBtnKomponentenlisteAnzeigenbearbeitenActionPerformed(e);
			}
		});
		btnKomponentenlisteAnzeigenbearbeiten.setBounds(214, 116, 271, 25);
		contentPane.add(btnKomponentenlisteAnzeigenbearbeiten);
	}
	
	private void  jBtnKomponentenlisteAnzeigenbearbeitenActionPerformed(ActionEvent e){
		
		
	}
	
	private void jBtnKomponenteHinzufuegenActionPerformed(ActionEvent e){
		System.out.println("test");
		System.out.println(jCBRaumnummer.getSelectedItem().toString());
	}
	
	private void generateObject(){
		
	String bezeichnung = 	jTfBezeichnung.getText();
	String komponentenTyp = jCBGebaeude.getSelectedItem().toString();
	String gebaeude;
	String raum; 
		
		//Komponente komponente = new Komponente(String bezeichnung, String komponentenTyp, String gebaeude, String raum);
		
		
	}
}
