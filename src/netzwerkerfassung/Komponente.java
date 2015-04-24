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

    private String bezeichnung;
    private int inventarNummer;
    private String beschreibung;
    private Date beschaffungsDatum = new Date();
    private Date wartungsDatum = new Date();
    
    public Komponente(String bezeichnung)
    {
    	this.bezeichnung = bezeichnung;
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
