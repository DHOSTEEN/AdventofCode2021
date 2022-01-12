package InputReaders;

import java.util.ArrayList;

public class SubmarineScannerReader extends AdventInputReader{
	
	public SubmarineScannerReader(String file_path) {
		super(file_path);
	}
	
	public ArrayList<ArrayList<String>> scannerCoords() {
		String line = obj_Reader.nextLine();//skips header
		ArrayList<ArrayList<String>> all_coords = new ArrayList<>();
		ArrayList<String> coords = new ArrayList<>();
		while(obj_Reader.hasNextLine()) {		
			
			line = obj_Reader.nextLine();
			
			if(line.isEmpty()) {

				all_coords.add(coords);
				coords = new ArrayList<>();
				obj_Reader.nextLine();//skips header
			}
			else{coords.add(line);}
			
		}
		all_coords.add(coords);
		return all_coords;
	}

}
