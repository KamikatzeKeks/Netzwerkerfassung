package netzwerkerfassung;

import java.util.ArrayList;
import java.util.List;

public class Gebaeude {

	String bezeichnung;
	String strasse;
	String plz;
	String ort;
	int  anz_raeume;
	List<Raum>raeume = new ArrayList<Raum>();
	List<Raum>list_raeume = new ArrayList<Raum>();
	//Raum[] array_raeume;
	public Gebaeude(String bezeichnung, String strasse, String plz, String ort, int anz_raeume) {

		this.bezeichnung = bezeichnung;
		this.strasse = strasse;
		this.plz = plz;
		this.ort = ort;
		this.anz_raeume = anz_raeume;
		int count = 100;
		
		for(int i = 0; i<anz_raeume; i++){
			raeume.add(new Raum(count));
			count = count+1;
		}

	}
	
	public Gebaeude(String bezeichnung, String strasse, String plz, String ort, List<Raum>list_raeume) {
		this.bezeichnung = bezeichnung;
		this.strasse = strasse;
		this.plz = plz;
		this.ort = ort;
		this.list_raeume = list_raeume;
		this.raeume = list_raeume;
	}
	
	public String getBezeichnung() {
		return bezeichnung;
	}
	public int getAnzRaeume() {
		return anz_raeume;
	}
	
	public String getStrasse() {
		return strasse;
	}
	
	public String getPlz() {
		return plz;
	}
	
	public String getOrt() {
		return ort;
	}
	
	public List<Raum> getRaeume() {
		return raeume;
	}
	public List<Raum> getListRaeume() {
		return list_raeume;
	}
	public void setBezeichnung (String bez) {
		this.bezeichnung = bez;
	}
	
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	
	}
	
	public void setPlz(String plz) {
		this.plz = plz;
	}
	
	public void setOrt(String ort) {
		this.ort = ort;
	}
	
	public void setAnzRaeume(int anz_raeume){
		this.anz_raeume = anz_raeume;
	}
	
	public void setRaeume(List<Raum>raeume) {
		this.raeume = raeume;
	}
	
	@Override
	public String toString() {
		
		
		return bezeichnung;
	}
	
}

	


