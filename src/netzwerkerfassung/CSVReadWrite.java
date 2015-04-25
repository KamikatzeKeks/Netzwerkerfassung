package netzwerkerfassung;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReadWrite {
	
	private static int count = 1;
	
	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE = "\n";
		
	//CSV file header
	private static final String FILE_HEADER = "Bezeichnung,KomponentenTyp,Geb‰ude,Raum";
	private static final String FILE_HEADER_BUILDING = "Bezeichnung, Straﬂe, Plz, Ort, R‰ume";

	public CSVReadWrite() {
		// TODO Auto-generated constructor stub
	}

//	main Methode zum testen.
//public static void main(String[] args) {
	
//	Gebaeude g1 = new Gebaeude("Gebaude1", "teststrasse", "64291", "Da", 3);
//	Gebaeude g2 = new Gebaeude("Gebaude2", "teststrasse2", "64291", "Dar", 4);
	
//	List<Gebaeude>gebaeude = new ArrayList<Gebaeude>();
//	gebaeude.add(g1);
//	gebaeude.add(g2);
	
//	writeCSVGebaeude(gebaeude);
	
//	for(Gebaeude g: gebaeude){
//		System.out.println(g.getBezeichnung() + " " + g.getStrasse() + " " + g.getPlz() + " " + g.getOrt());
//	}
	
//		// TODO Auto-generated method stub
//		
//		Komponente k1 = new PC("Acer PC", "PC", "103", "11111");
//		Komponente k2 = new Notebook("HP Pavilion", "Notebook", "103", "11111");
//		Komponente k3 = new Switch("Cisco C103", "Switch", "103", "11111");
//		Komponente k4 = new Server("Cisco S220", "Server", "103", "11111");
//		
//		List<Komponente> komponenten = new ArrayList<Komponente>();
//		komponenten.add(k1);
//		komponenten.add(k2);
//		komponenten.add(k3);
//		komponenten.add(k4);
//		
//		writeCSV(komponenten);
//		komponenten = readCSV();
//		
//		for (Komponente k : komponenten) 
//		{
//			System.out.println(k.getBezeichnung() + ", " + k.getKomponentenTyp() + ", " + k.getGebaeude() + ", " + k.getRaum());
//		}
//		
//}
	
	public static void writeCSV(List<Komponente> komponenten)
	{
		
		FileWriter fileWriter = null;
				
		try {
			fileWriter = new FileWriter("data.csv");

			//Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());
			
			//Add a new line separator after the header
			fileWriter.append(NEW_LINE);
			
			//Write a new student object list to the CSV file
			for (Komponente k : komponenten) 
			{
				fileWriter.append(String.valueOf(k.getBezeichnung()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(k.getKomponentenTyp()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(k.getGebaeude()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(k.getRaum()));
				fileWriter.append(NEW_LINE);
			}

			
			
			System.out.println("CSV file was created successfully !!!");
			
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
			}
			
		}
	}
	
	public static void writeCSVGebaeude(List<Gebaeude> gebaeude)
	{
		
		FileWriter fileWriter = null;
				
		try {
			fileWriter = new FileWriter("Gebaeude.csv");

			//Write the CSV file header
			fileWriter.append(FILE_HEADER_BUILDING.toString());
			
			//Add a new line separator after the header
			fileWriter.append(NEW_LINE);
			
	
			for (Gebaeude g : gebaeude) 
			{
				fileWriter.append(String.valueOf(g.getBezeichnung()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(g.getStrasse()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(g.getPlz()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(g.getOrt()));
				fileWriter.append(COMMA_DELIMITER);
				
				for(Raum r:g.getRaeume()) {
					fileWriter.append(String.valueOf(r));
					//System.out.println(r);
				}
				fileWriter.append(NEW_LINE);
			}

			
			
			System.out.println("CSV file was created successfully !!!");
			
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
			}
			
		}
	}
	public static List<Komponente> readCSV() 
	{
		BufferedReader br;
		List<ArrayList> data = new ArrayList<ArrayList>();
		String readline;
		String[] splittedLine;
		
		try
		{
			br = new BufferedReader(new FileReader("data.csv"));
			
			while ((readline = br.readLine()) != null)
			{
				List<String> lines = new ArrayList<String>();
				splittedLine = readline.split(",");
				for (int x = 0; x < splittedLine.length; x++)
				{
					lines.add(splittedLine[x]);
				}
				data.add((ArrayList) lines);
			}
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Komponente> komponenten = new ArrayList<Komponente>();
		
		for (ArrayList l : data) 
		{
			List<String> object = new ArrayList<String>();
			
			for (Object s : l) 
			{
				//System.out.print(s.toString() + ", ");
				object.add(s.toString());
			}
			//System.out.println();
			komponenten.add(new Komponente(object.get(0), object.get(1), object.get(2), object.get(3)));
		}
		
		return komponenten;
	}

	public static List<Gebaeude> readCSVGebaeude() 
	{
		BufferedReader br;
		List<ArrayList> data = new ArrayList<ArrayList>();
		String readline;
		String[] splittedLine;
		
		try
		{
			br = new BufferedReader(new FileReader("Gebaeude.csv"));
			
			while ((readline = br.readLine()) != null)
			{
				List<String> lines = new ArrayList<String>();
				splittedLine = readline.split(",");
				for (int x = 0; x < splittedLine.length; x++)
				{
					lines.add(splittedLine[x]);
				}
				data.add((ArrayList) lines);
			}
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Gebaeude> gebaeude = new ArrayList<Gebaeude>();
		
		for (ArrayList l : data) 
		{
			List<String> object = new ArrayList<String>();
			
			for (Object s : l) 
			{
				//System.out.print(s.toString() + ", ");
				object.add(s.toString());
			}
			//System.out.println();
			gebaeude.add(new Gebaeude(object.get(0), object.get(1), object.get(2), object.get(3), Integer.parseInt(object.get(4))));
		}
		
		return gebaeude;
	}

         
}
