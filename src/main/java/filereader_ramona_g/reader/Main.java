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
			
			BufferedReader reader;
			BufferedWriter writer;
			try {
				reader = new BufferedReader(new FileReader(file));

				String line;
				
				List<String> text = new ArrayList<String>();
				
				while ((line = reader.readLine()) != null) {
					text.add(line);
					System.out.println(line);
				}
				reader.close();

				if (args.length > 1 && args[1] != null) {
					String output_path = args[1];
					writer = new BufferedWriter(new FileWriter(output_path));

					for (int i = 0; i < text.size(); i++) {
						String l = text.get(i);
						writer.write(l);

						if (i != text.size()-1) {
							writer.newLine();
						}
					}
					writer.close();
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
