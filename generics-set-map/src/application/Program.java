package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		Map<String, Integer> mapVotes = new HashMap<String, Integer>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				int votesAmount = Integer.parseInt(fields[1]);
				
				if (mapVotes.containsKey(fields[0])) {
					votesAmount += mapVotes.get(fields[0]);
				}
				
				mapVotes.put(fields[0], votesAmount);
				
				line = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		for (String key : mapVotes.keySet()) {
			System.out.println(key + ": " + mapVotes.get(key));
		}
		
		sc.close();

	}

}
