package netzwerkerfassung;

import java.util.ArrayList;
import java.util.List;

public class Raum {

	int raumnummer;
	private List<Komponente>komponenten = new ArrayList<Komponente>();
	
	public Raum(int raumnummer ) {
		// TODO Auto-generated constructor stub
		this.raumnummer = raumnummer;
		
	}
	
	public Raum(int raumnummer, List<Komponente> komponenten) {
		// TODO Auto-generated constructor stub
		this.raumnummer = raumnummer;
		this.komponenten = komponenten;
	}	
	
	public List<Komponente> getKomponenten() {
		return komponenten;
	}

	public void setKomponenten(List<Komponente> komponenten) {
		this.komponenten = komponenten;
	}

	public void setRaumnummer(int raumnummer) {
		this.raumnummer = raumnummer;
	}

	public void addKomponente(Komponente k)
	{
		komponenten.add(k);
	}
	
	public int getRaumnummer() {
		return raumnummer;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(raumnummer);
	}

}
