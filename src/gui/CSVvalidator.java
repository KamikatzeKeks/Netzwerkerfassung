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
	 * Überprüft ob eine Komponente sich in einem nicht mehr existierenden Gebäude befindet
	 * und entfernt die Komponenten, falls dieser Fall eintritt.
	 * 
	 * @author Brian Korduan
	 * @return void
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
