package InputReaders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MyUtils {
	
	private  List<String> inputLines;
	private  String bufferedInputFileName;

	    public void readInput(String filename) {
	        try {
	            inputLines = Files.readAllLines(Paths.get(filename));
	            bufferedInputFileName = filename;
	        } catch(IOException e) {
	            e.printStackTrace();
	        }
	    }

}
