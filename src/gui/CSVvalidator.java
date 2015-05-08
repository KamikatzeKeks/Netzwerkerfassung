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
		List<Komponente> neueKomponentenListe = new ArrayList<>();

		komponentenListe = CSVReadWrite.readCSV();
		gebaeudeListe = CSVReadWrite.readCSVGebaeude();

		for (Komponente komponente : komponentenListe) {
			for (Gebaeude gebaeude : gebaeudeListe) {
				if (komponente.getGebaeude().equals(gebaeude.getBezeichnung())) {

					neueKomponentenListe.add(komponente);

				} else {
				}
			}
		}
		CSVReadWrite.writeCsvGeraete(neueKomponentenListe);
	}

}
