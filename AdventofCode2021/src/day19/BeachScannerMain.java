package day19;


import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import InputReaders.SubmarineScannerReader;

public class BeachScannerMain {	

    private static SubmarineScannerReader obj;
    private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput19_testdata.txt";
	
	public static void main(String[] args) {
		
		obj = new SubmarineScannerReader(file_location);
		ArrayList<ArrayList<String>> all_coords = obj.scannerCoords();
		ArrayList<Set<String>> all_sets = new ArrayList<>();
		ArrayList<Map<String,Integer>> all_distances = new ArrayList<>();
		
		SubmarineScanner a_scanner;
		
		for(ArrayList<String> list : all_coords) {
			
			a_scanner = new SubmarineScanner(list);
			a_scanner.findAbsoluteDistance();
			all_distances.add(a_scanner.getHashDistance());			
		}
		System.out.println(all_distances.get(0).toString());
		System.out.println("COMPARE");
		System.out.println(all_distances.get(1).toString());
	}

}
