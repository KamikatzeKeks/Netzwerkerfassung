package gebaeude;

import java.util.ArrayList;
import java.util.List;

/*
 * Klasse Gebäude
 * @author Marco D'Addona
 * 
 */
public class Gebaeude {

	private String bezeichnung;
	private String strasse;
	private String plz;
	private String ort;
	private int  anz_raeume;
	private List<Raum>raeume = new ArrayList<Raum>();
	private List<Raum>list_raeume = new ArrayList<Raum>();
	public int getAnz_raeume() {
		return anz_raeume;
	}

	public void setAnz_raeume(int anz_raeume) {
		this.anz_raeume = anz_raeume;
	}

	public List<Raum> getList_raeume() {
		return list_raeume;
	}

	public void setList_raeume(List<Raum> list_raeume) {
		this.list_raeume = list_raeume;
	}

	//Raum[] array_raeume;
	public Gebaeude(String bezeichnung, String strasse, String plz, String ort, int anz_raeume) {

		this.bezeichnung = bezeichnung;
		this.strasse = strasse;
		this.plz = plz;
		this.ort = ort;
		this.anz_raeume = anz_raeume;
		int count = 1;
		
		//Raumnummern werden aus der Anzahl der Räume generiert
		for(int i = 0; i<anz_raeume; i++){
			raeume.add(new Raum(count));
			count++;
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

	


