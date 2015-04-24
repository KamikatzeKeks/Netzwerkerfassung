/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netzwerkerfassung;

import java.util.Date;

/**
 *
 * @author Brian
 */
public class Komponente {

    public String getGebaeude() {
		return gebaeude;
	}

	public void setGebaeude(String gebaeude) {
		this.gebaeude = gebaeude;
	}

	public String getRaum() {
		return raum;
	}

	public void setRaum(String raum) {
		this.raum = raum;
	}

	private String bezeichnung;
    private int inventarNummer;
    private String beschreibung;
    private Date beschaffungsDatum = new Date();
    private Date wartungsDatum = new Date();
    private String gebaeude;
    private String raum;
    private String komponentenTyp;
    
    public Komponente(String bezeichnung)
    {
    	this.bezeichnung = bezeichnung;
    }
    
    public Komponente(String bezeichnung, String komponentenTyp, String gebaeude, String raum){
    	this.bezeichnung = bezeichnung;
    	this.komponentenTyp = komponentenTyp;
    	this.gebaeude = gebaeude;
    	this.raum = raum;
    	
    }

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public int getInventarNummer() {
		return inventarNummer;
	}

	public void setInventarNummer(int inventarNummer) {
		this.inventarNummer = inventarNummer;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

}
