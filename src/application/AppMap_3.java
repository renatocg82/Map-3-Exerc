package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AppMap_3 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner scStr = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter file full path: ");
		String path = scStr.nextLine();

		Map<String, Integer> votes = new TreeMap<>();

		try (FileReader fr = new FileReader(path); BufferedReader br = new BufferedReader(fr)) {

			String line;
			line = br.readLine();

			while (line != null) {

				String[] lineSpl = line.split(" - ");

				String tempCand = lineSpl[0];
				Integer tempVote = Integer.parseInt(lineSpl[1]);
				int voteSoFar = 0;

				if (votes.containsKey(tempCand)) {

					voteSoFar = votes.get(tempCand) + tempVote;
					votes.put(tempCand, voteSoFar);
					
					line = br.readLine();

				}
				
				else {
					votes.put(tempCand,  tempVote);
					line = br.readLine();
				}

			}
			
			System.out.println("----------------");
			
			for (String cand : votes.keySet()) {
				System.out.println(cand + " - " + votes.get(cand));
			}
			
		}
		
		catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		}

		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		scStr.close();
		sc.close();
	}

}
