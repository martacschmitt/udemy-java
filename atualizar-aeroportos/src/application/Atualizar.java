package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class Atualizar {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("c:\\temp\\aeroportos.csv"));
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("c:\\temp\\novosAeroportos.json"));
		
		String line = br.readLine();
		while (line != null) {
			String[] fields = line.split(" - ");
			
			BufferedReader brJson = new BufferedReader(new FileReader("c:\\temp\\aeroportos.json"));
			String jsonString = brJson.readLine();
			
			JSONObject jsonAeroportos = new JSONObject(jsonString);
			
			String listaAeroportos = jsonAeroportos.get("aeroportos").toString(); 
			
			JSONArray arrayAeroportos = new JSONArray(listaAeroportos);
			
			for (int i = 0; i < arrayAeroportos.length(); i++) {
				JSONObject aeroporto = arrayAeroportos.getJSONObject(i);
				if (aeroporto.get("codigo").toString().equalsIgnoreCase(fields[0])) {
					JSONObject novoAeroporto = new JSONObject();
					novoAeroporto.put("codigo", aeroporto.get("codigo"));
					novoAeroporto.put("nome", aeroporto.get("nome"));
					bw.write("," + novoAeroporto.toString());
					break;
				}
			}
			
			brJson.close();
			
			line = br.readLine();
		}
		
		br.close();
		bw.close();
		
	}
	
}
