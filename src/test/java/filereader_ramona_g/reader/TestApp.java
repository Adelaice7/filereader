package filereader_ramona_g.reader;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
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
		
		ByteArrayOutputStream os = new  ByteArrayOutputStream();
		PrintStream testStream = new PrintStream(os);
		System.setOut(testStream);

		File inputFile = new File(inpath);

		String[] args = new String[1];
		args[0] = inpath;

		Main.main(args);
		
		try (
				BufferedReader reader = new BufferedReader(new FileReader(inputFile));
				ByteArrayInputStream in = new ByteArrayInputStream(os.toByteArray());
			) {

			Assertions.assertEquals(reader.read(), in.read());
		}
	}
	
	@Test
	@DisplayName("Test Copy To Another File Function")
	public void testMainCopyToFile() throws IOException {
		String inpath = "C:\\Users\\gotthard\\Documents\\valami.txt";
		String outpath = "C:\\Users\\gotthard\\Documents\\valami2.txt";
		File inputFile = new File(inpath);
		File outFile = new File(outpath);

		String[] args = new String[2];
		args[0] = inpath;
		args[1] = outpath;
		
		Main.main(args);
		
		try(
				BufferedReader reader = new BufferedReader(new FileReader(inputFile));
				BufferedReader testReader = new BufferedReader(new FileReader(outFile));
				) {
			
			Assertions.assertEquals(reader.read(), testReader.read());
		}
	}
}
