package netzwerkerfassung;

import java.util.ArrayList;
import java.util.List;

public class Gebaeude {

	String stra�e;
	String plz;
	String ort;
	int  anz_r�ume;
	List<Raum>raeume = new ArrayList<Raum>();
	
	public Gebaeude(String stra�e, String plz, String ort, int anz_raeume) {
		// TODO Auto-generated constructor stub
		this.stra�e = stra�e;
		this.plz = plz;
		this.ort = ort;
		
		int count = 100;
		
		for(int i = 0; i<=anz_raeume; i++){
			Raum raum = new Raum(count);
			raeume.add(raum);
			count++;
		}
	}
	

}
