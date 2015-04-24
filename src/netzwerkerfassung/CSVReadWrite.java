package netzwerkerfassung;

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
	private static final String FILE_HEADER = "id,bezeichnung,Geb�ude,Raum";
	

	public CSVReadWrite() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Komponente k1 = new PC("Acer PC", "PC", "103", "11111");
		Komponente k2 = new Notebook("HP Pavilion", "Notebook", "103", "11111");
		Komponente k3 = new Switch("Cisco C103", "Switch", "103", "11111");
		Komponente k4 = new Server("Cisco S220", "Server", "103", "11111");
		
		List<Komponente> komponenten = new ArrayList<Komponente>();
		komponenten.add(k1);
		komponenten.add(k2);
		komponenten.add(k3);
		komponenten.add(k4);
		
		writeCSV(komponenten);
	}
	
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
				fileWriter.append(String.valueOf(count++));
				fileWriter.append(COMMA_DELIMITER);
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

}
