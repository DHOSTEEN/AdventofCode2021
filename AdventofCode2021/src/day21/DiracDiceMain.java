package day21;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DiracDiceMain {
	
	public static void main(String[] args) {
		
		try {		
			List<String> list = Files.readAllLines(Path.of(DiracDiceMain.class.getResource("/input.txt").getPath()));
		}catch(IOException e) {}
	}


}