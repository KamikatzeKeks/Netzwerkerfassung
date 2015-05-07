package netzwerkerfassung;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
* Klasse zum lesen/schreiben einer JSON Datei.
*
* @author Davis Fröse
*/

public class JSONReadWrite 
{

	public JSONReadWrite() 
	{
		
	}

	public static void main(String[] args) 
	{
		
	}
	
	/**
	 * Überprüft ob eine Datei existiert
	 * 
	 * @param String fileName
	 * @return boolean
	 */
	public static boolean doesFileExist(String fileName)
	{
		File JSONFile = new File(fileName);
		
		if(JSONFile.exists() == true )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void createFile(String fileName)
	{
		new File(fileName);
	}
	
	
	/**
	 * Schreibt die JSON Datei
	 * 
	 * @param List<Gebaeude> fileName
	 * @return void
	 */
	@SuppressWarnings("unchecked")
	public void writeJSON(List<Gebaeude> gebaeude)
	{
		
		String filepath = "data.json";
		
		JSONObject obj = new JSONObject();
		JSONArray gebaeudeObjekte = new JSONArray();
		
		int count = 1;
		 
		for (Gebaeude g : gebaeude) 
		{
			JSONObject geb = new JSONObject();
			geb.put("Bezeichnung", g.getBezeichnung());
			geb.put("Strasse", g.getStrasse());
			geb.put("Plz", g.getPlz());
			geb.put("Ort", g.getOrt());
			
			JSONArray raeume = new JSONArray();
			for(Raum r : g.getRaeume()) 
			{
				JSONObject raum = new JSONObject();
				raum.put("raumnummer", r.getRaumnummer());
				
				JSONArray komponenten = new JSONArray();
				for(Komponente k : r.getKomponenten()) 
				{
					JSONObject komponente = new JSONObject();
					komponente.put("bezeichnung", k.getBezeichnung());
					komponente.put("komponentenTyp", k.getKomponentenTyp());
					
					komponenten.add(komponente);
				}
				raum.put("Komponenten", komponenten);
				
				raeume.add(raum);
			}
			geb.put("Raeume", raeume);
			
			gebaeudeObjekte.add(geb);
			obj.put("gebaeude", gebaeudeObjekte);
			
		}
		 
		try 
		{
			 FileWriter file = new FileWriter(filepath);
			 file.write(obj.toJSONString());
			 file.flush();
			 file.close();
			 System.out.println("JSON file was created successfully !!!");
		 
		} 
		catch (IOException e) 
		{
			 System.out.println("Error in JSON Filewriter !!!");
			 e.printStackTrace();
		}
		 
		//System.out.print(obj);
	}
	
	
	/**
	 * liest die JSON Datei und return eine Liste von Gebäuden.
	 * 
	 * @return List<Gebaeude>
	 */
	@SuppressWarnings("unchecked")
	public List<Gebaeude> readJSON()
	{
		List<Gebaeude> gebaeudeListe = new ArrayList<Gebaeude>();
		
		
		JSONParser parser = new JSONParser();
		 
		try 
		{
		 
			Object obj = parser.parse(new FileReader("data.json"));
		 
			JSONObject jsonObject = (JSONObject) obj;
			
			JSONArray gebaeude = (JSONArray) jsonObject.get("gebaeude");
			Iterator<JSONObject> i = gebaeude.iterator();
			while (i.hasNext()) 
			{
				List<Raum> raeumeListe = new ArrayList<Raum>();
				
				JSONObject geb = (JSONObject) i.next();
				
				String bezeichnung = (String) geb.get("Bezeichnung");
				String strasse = (String) geb.get("Strasse");
				String plz = (String) geb.get("Plz");
				String ort = (String) geb.get("Ort");
				 
				JSONArray raeume = (JSONArray) jsonObject.get("Raeume");
				Iterator<JSONObject> i2 = gebaeude.iterator();
				while (i2.hasNext()) 
				{
					List<Komponente> komponentenListe = new ArrayList<Komponente>();
					
					JSONObject raum = (JSONObject) i2.next();
					
					int raumnummer = Integer.parseInt((String) raum.get("raumnummer"));
					
					JSONArray komponenten = (JSONArray) jsonObject.get("Komponenten");
					Iterator<JSONObject> i3 = gebaeude.iterator();
					while (i3.hasNext()) 
					{
						JSONObject komponente = (JSONObject) i3.next();
						
						String kBezeichnung = (String) raum.get("bezeichnung");
						String komponentenTyp = (String) raum.get("komponentenTyp");
						
						Komponente k = new Komponente(kBezeichnung,komponentenTyp);
						komponentenListe.add(k);
					}
					
					Raum r = new Raum(raumnummer, komponentenListe);
					raeumeListe.add(r);
				}	
				
				Gebaeude g = new Gebaeude(bezeichnung, strasse, plz, ort, raeumeListe);
				gebaeudeListe.add(g);
					
			}
			 
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		
		
		
		return gebaeudeListe;
	}
	

}
