package gui;
/*
 * @autor Brian Korduan
 */
import gebaeude.Gebaeude;

import java.util.ArrayList;
import java.util.List;

import readerWriter.CSVReadWrite;
import komponenten.Komponente;

public class CSVvalidator {

	/**
	 * Überprüft ob in der KomponentenCSV Komponenten mit nicht mehr vorhandenen
	 * Gebäuden gespeichert sind und entfernt diese
	 * 
	 * @author Brian Korduan
	 * @return List<Komponente>
	 */
	public static void checkGebaeudeKomponenteAssociation() {

		List<Komponente> komponentenListe = new ArrayList<>();
		List<Gebaeude> gebaeudeListe = new ArrayList<>();

		komponentenListe = CSVReadWrite.readCSV();
		gebaeudeListe = CSVReadWrite.readCSVGebaeude();

		System.out.println(komponentenListe.size());
		int[] indesliste = new int[100];
		try {

			int i = 0;
			for (Komponente komponente : komponentenListe) {
				i=0;
				for (Gebaeude gebaeude : gebaeudeListe) {
					if (komponente.getGebaeude().equals(gebaeude.getBezeichnung())) {
						i++;

					} else {
						indesliste[i] = i;
 					//	komponentenListe.remove(i);
						i++;

					}
				}
			}
			
			for(int e : indesliste){
				komponentenListe.remove(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CSVReadWrite.writeCsvGeraete(komponentenListe);
		}
	}

}
