package filereader_ramona_g.reader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestApp {
	
	@Test
	@DisplayName("Test Print To Console Function")
	public void testMainPrintToConsole() throws IOException {
		String inpath = "C:\\Users\\gotthard\\Documents\\valami.txt";
		String testFilePath = "C:\\\\Users\\\\gotthard\\\\Documents\\\\test.txt";
		
		File testOutFile = new File(testFilePath);

		PrintStream testStream = new PrintStream(testOutFile);
		System.setOut(testStream);

		File inputFile = new File(inpath);
		
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedReader testReader = new BufferedReader(new FileReader(testOutFile));
		
		String[] args = new String[1];
		args[0] = inpath;
		
		Main.main(args);
		
		Assertions.assertEquals(reader.read(), testReader.read());
		
		reader.close();
		testReader.close();
		
		if (testOutFile.exists()) {
			testOutFile.delete();
		}
	}
	
	@Test
	@DisplayName("Test Copy To Another File Function")
	public void testMainCopyToFile() throws IOException {
		String inpath = "C:\\Users\\gotthard\\Documents\\valami.txt";
		String outpath = "C:\\Users\\gotthard\\Documents\\valami2.txt";
		File inputFile = new File(inpath);
		File outFile = new File(outpath);

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedReader testReader = new BufferedReader(new FileReader(outFile));

		String[] args = new String[2];
		args[0] = inpath;
		args[1] = outpath;
		
		Main.main(args);
		
		Assertions.assertEquals(reader.read(), testReader.read());
		
		reader.close();
		testReader.close();
	}
	
}
