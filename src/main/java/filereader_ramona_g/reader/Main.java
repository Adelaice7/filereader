package filereader_ramona_g.reader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	
	public static void printFileToConsole(String[] args) {
		String input_path = args[0];
		File inputFile = new File(input_path);
		String line = null;
		
		try (
				BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			) {
			
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("Wrong input file path given!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void copyFileToFile(String[] args) {
		String input_path = args[0];
		File inputFile = new File(input_path);
		String output_path = args[1];
		File outputFile = new File(output_path);
		String line = null;
		
		try (
				BufferedReader reader = new BufferedReader(new FileReader(inputFile));
				BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
			) {
			
			while ((line = reader.readLine()) != null) {
				if (args.length > 1) {
					writer.write(line);
					writer.newLine();
					
				} else {
					System.out.println(line);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		
		if (args.length > 0) {
			printFileToConsole(args);
			
			if (args.length > 1) {
				copyFileToFile(args);
			}			
			
		} else {
			System.out.println("No parameters entered.");
		}
	}
}
