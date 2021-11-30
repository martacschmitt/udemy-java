package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import entities.Produto;

public class Exercicio {

	public static void main(String[] args) {

		String rootPath = "c:\\temp\\";
		
		try (BufferedReader br = new BufferedReader(new FileReader(rootPath + "itens.csv"))) {

			String line = br.readLine();

			while (line != null) {

				String[] lineSplited = line.split(",");

				Produto item = new Produto(lineSplited[0], Double.parseDouble(lineSplited[1]), Integer.parseInt(lineSplited[2]));

				File path = new File(rootPath + "\\out");
				
				if (!path.exists()) {
					new File(path.getPath()).mkdir();
				}
				
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(rootPath + "out\\summary.csv", true))) {
					bw.write(item.getNome() + "," + item.getValorTotal());
					bw.newLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
