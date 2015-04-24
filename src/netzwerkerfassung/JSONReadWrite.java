package netzwerkerfassung;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.*;
import org.json.simple.parser.*;

public class JSONReadWrite {

	public JSONReadWrite() {
		// TODO Auto-generated constructor stub 
	}

	public static void main(String[] args) {

		List<Gebaeude>gebaeude = new ArrayList<Gebaeude>();
		gebaeude.add(new Gebaeude("101", "Musterstrasse", "64380", "Musterstadt", 5));
		gebaeude.add(new Gebaeude("102", "Musterstrasse", "64380", "Musterstadt", 10));

		createJSON();
	}
	
	public static void createJSON()
	{
		JSONObject obj = new JSONObject();
		
		
		obj.put("name", "mkyong.com");
		obj.put("age", new Integer(100));
	 
		JSONArray list = new JSONArray();
		list.add("msg 1");
		list.add("msg 2");
		list.add("msg 3");
	 
		obj.put("messages", list);
	 
		try {
	 
			FileWriter file = new FileWriter("C:\\Users\\Davis\\git\\Netzwerkerfassung\\data");
			file.write(obj.toJSONString());
			file.flush();
			file.close();
	 
		} catch (IOException e) {
			e.printStackTrace();
		}
	 
		System.out.print(obj);
	 
	}

}


