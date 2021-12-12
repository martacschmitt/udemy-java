package application;

import java.util.LinkedHashSet;
import java.util.Set;

public class Program {

	public static void main(String[] args) {
		
		// Set<String> set = new HashSet<String>(); // não importa a ordem
		// Set<String> set = new TreeSet<String>(); // ordena os dados
		Set<String> set = new LinkedHashSet<String>(); // mantem a ordem em que foi inserido
		
		set.add("TV");
		set.add("Notebook");
		set.add("Tablet");
		
		set.removeIf(x -> x.charAt(0) == 'T');
		
		for (String string : set) {
			System.out.println(string);
		}
		
	}
	
}
