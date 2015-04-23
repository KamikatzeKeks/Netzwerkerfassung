package netzwerkerfassung;

import java.util.ArrayList;
import java.util.List;

public class Raum {

	int raumnummer;
	List<Komponente>komponenten = new ArrayList<Komponente>();
	
	public Raum(int raumnummer ) {
		// TODO Auto-generated constructor stub
		this.raumnummer = raumnummer;
		
	}
	
	public void addKomponente(Komponente k)
	{
		komponenten.add(k);
	}

}
