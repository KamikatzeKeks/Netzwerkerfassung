package readerWriter;

/**
*
* @author Marco und Davis
*/

import gebaeude.Gebaeude;
import gebaeude.Raum;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import komponenten.Komponente;

public class CSVReadWrite {
	
	private static int count = 1;
	
	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
		
	//CSV file header
//	private static final String FILE_HEADER = "Bezeichnung,KomponentenTyp,Gebäude,Raum";
//	private static final String FILE_HEADER_BUILDING = "Bezeichnung, Straße, Plz, Ort, Räume";

	public CSVReadWrite()
	{
		
	}
	
	/**
	 * Überprüft ob eine Datei existiert
	 * 
	 * @author Brian Korduan
	 * @param String fileName
	 * @return boolean
	 */
	public static boolean doesFileExist(String fileName)
	{
		File csvFile = new File(fileName);
		
		if(csvFile.exists() == true ){
			return true;
		}else{
			return false;
		}
		
	}
	

	/**
	 * erstellt eine Datei
	 * 
	 * @author Brian Korduan
	 * @param String fileName
	 * @return void
	 */
	public static void createFile(String fileName){
		new File(fileName);
		

	}
	
	public static void deleteFile(String fileName){
		File file = new File(fileName);
		file.delete();
	}
	
	public static void writeCsvGeraete(List<Komponente> komponenten)
	{
		
		FileWriter fileWriter = null;
				
		try {
			fileWriter = new FileWriter("data.csv");

				
//			
//			//Write the CSV file header
//			fileWriter.append(FILE_HEADER.toString());
//			
//			//Add a new line separator after the header
//			

			for (Komponente k : komponenten) 
			{
				fileWriter.append(String.valueOf(k.getBezeichnung()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(k.getKomponentenTyp()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(k.getGebaeude()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(k.getRaum()));
				fileWriter.append(System.lineSeparator());
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
				
				int count = 0;
				for(Raum r:g.getRaeume()) {
					System.out.println(g.getAnzRaeume());
					if(count == 0) {
						fileWriter.append("[");
					}
					count ++;
					
					fileWriter.append(String.valueOf(r.getRaumnummer()));
					fileWriter.append(COMMA_DELIMITER);
					
				
					//System.out.println(r);
				}
				fileWriter.append("]");
				fileWriter.append(System.lineSeparator());
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
				List<Raum>raeume = new ArrayList<Raum>();
				//splittedLine = readline.split(",");
				
				splittedLine = readline.split(",");
				//int anz_raeume = 0;
				
				if(readline.contains("[")) {
				
					String countraeume = readline.substring(readline.indexOf("[")+1, readline.indexOf("]"));

					//Anzahl der Räume zahlen
					//for (int i=0;i<countraeume.length();i++) {
						//if (countraeume.charAt(i) == ',') {
							//anz_raeume ++;
						 //}
					//}
					
					String[] split_raeume = countraeume.split(",");
					
					for(int i = 0; i<split_raeume.length; i++) {
						raeume.add(new Raum(Integer.parseInt(split_raeume[i])));
					}
					
					/*for(int i=0; i<raeume.size(); i++){
						
						System.out.println(raeume.get(i).getRaumnummer());
					}*/
					
					
				}

				for (int x = 0; x <= 3; x++)
				{
					lines.add(splittedLine[x]);
				}
				//System.out.println(count_raeume.toString());
				for(int y = 0; y<raeume.size(); y++) {
					Integer intRaeume = new Integer(raeume.get(y).getRaumnummer());
					lines.add(intRaeume.toString());
				}
				//lines.add(count_raeume.toString());
				
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
			List<Raum>list_raeume = new ArrayList<Raum>();
			for(int c = 4; c<object.size(); c++) {
				Raum raum = new Raum(Integer.parseInt(object.get(c)));
				list_raeume.add(raum);
				boolean test =true;
			}
			gebaeude.add(new Gebaeude(object.get(0), object.get(1), object.get(2), object.get(3), list_raeume));
		
		}
		
		return gebaeude;
	}

         
}
