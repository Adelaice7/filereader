package filereader_ramona_g.reader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		if (args.length > 0) {
			String input_path = args[0];
			File file = new File(input_path);
			String output_path = null;
			String line = null;
			
			if (args.length > 1) {
				output_path = args[1];
			}
			
			try (
					BufferedReader reader = new BufferedReader(new FileReader(file));
					BufferedWriter writer = new BufferedWriter(new FileWriter(output_path));
				) 
			{
			
				while ((line = reader.readLine()) != null) {
					if (args.length > 1) {
						writer.write(line);
						writer.newLine();
						
					} else {
						System.out.println(line);
					}
				}
				
			} catch (FileNotFoundException e) {
				System.out.println("Wrong input file path given!");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("No parameters entered.");
		}
	}
}
