package day19;


import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import InputReaders.SubmarineScannerReader;

public class BeachScannerMain {	

    private static SubmarineScannerReader obj;
    private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput19_testdata.txt";
    
    private static ArrayList<SubmarineScanner> all_scanners;
    private static Map<Character, Character> converter = new HashMap<>();
    
    private static final int DIMENTION = 2;
	
	public static void main(String[] args) {
		
		obj = new SubmarineScannerReader(file_location);
		all_scanners = new ArrayList<>();
		ArrayList<ArrayList<String>> all_coords = obj.scannerCoords();
		ArrayList<Set<String>> all_sets = new ArrayList<>();
		ArrayList<Map<String,String>> all_distances = new ArrayList<>();
		
		SubmarineScanner a_scanner;
		for(ArrayList<String> list : all_coords) {
			System.out.println("RAW: " + list.toString());
		}
		
		for(ArrayList<String> list : all_coords) {
			
			a_scanner = new SubmarineScanner(list);
			a_scanner.findAbsoluteDistance();
			all_distances.add(a_scanner.getHashDistance());			
			all_scanners.add(a_scanner);
		}
		System.out.println(all_distances.get(0).toString());
		System.out.println("COMPARE");
		System.out.println(all_distances.get(1).toString());
		
		
		int count = 0;
		for(int i =0; i<all_scanners.size(); i++) {
			if(i+1<all_scanners.size()) {
				
				compareAbsoluteDistances(all_scanners.get(i), all_scanners.get(i+1));
			}
		}
		
		System.out.println("CONVERT: " + converter.toString());
		
	}
	public static void compareAbsoluteDistances(SubmarineScanner first, SubmarineScanner second) {
		
		int count = 0;
		Map<String, String> temp_map = new HashMap<>();
		ArrayList<String[]> compare = new ArrayList<>();
		
		for(String key: first.getHashDistance().keySet()) {
			String val = first.getHashDistance().get(key);
			//System.out.println("Testing: " + key);
			for(String other_key: second.getHashDistance().keySet()) {
			//	System.out.println("on: " + other_key);
				String other_val = second.getHashDistance().get(other_key);
				if(val.equals(other_val)) {
					
					String[] pair = new String[DIMENTION];
					pair[0] = key;
					pair[1] = other_key;
					compare.add(pair);
					System.out.println("THE SAME: " + key + " - " + other_key);
					System.out.println("THE VAL: " + val);
					temp_map.put(key + "|" + other_key, val);
					
					
				}
			}
		}
		System.out.println("count: " + count);
		System.out.println("map size: " + temp_map.size());
		findPairs(compare);
		
	}
	private static void findPairs(ArrayList<String[]> pairs) {
		for(int i =0; i<pairs.size();i++) {
			
			pairHelper(pairs.get(i));
		}
	}
	private static void pairHelper(String[] pair) {
		
			
			Set<Character> same = new HashSet<>();

			String first_key = pair[0];
			first_key = first_key.substring(1,first_key.length()-1);//trim ()
			String[] first_key_IDs = first_key.split(":");//into 3 eventually
			
			String second_key = pair[1];
			second_key = second_key.substring(1, second_key.length()-1);
			String[] second_key_IDs = second_key.split(":");
			
			System.out.println("FIRST PAIR: " + Arrays.toString(first_key_IDs) + " lenght; " + first_key_IDs.length);
			System.out.println("SECOND PAIR: " + Arrays.toString(second_key_IDs));
			
			
			
			for(int i =0; i<first_key_IDs.length; i++) {
				
				char first_ID = first_key_IDs[i].charAt(0);
				char second_ID = second_key_IDs[i].charAt(0);
			System.out.println("the chars: " + first_ID + " - " + second_ID);
				if(first_ID == second_ID) {
					System.out.println("SUCCESS!!");
					System.err.println(Arrays.toString(pair));
					same.add(first_ID);
				}
			}

			int count =0;
			Set<Integer> pos_skip = new HashSet<>();
			for(int i =0; i<first_key_IDs.length; i++) {
					char first_ID = first_key_IDs[i].charAt(0);
					char second_ID = second_key_IDs[i].charAt(0);
					
					if(first_ID == second_ID && same.contains(first_ID)){
						
						count++;
						pos_skip.add(i);
						if(count == first_key_IDs.length) {
							System.out.println("Proof of concept");
							
						}
					}
			}
			//end of contains loop
			for(int i =0; i<first_key_IDs.length; i++) {
				if(!pos_skip.contains(i)) {
					
					char first_ID = first_key_IDs[i].charAt(0);
					char second_ID = second_key_IDs[i].charAt(0);					
					converter.put(first_ID, second_ID);
				}
			}
			System.out.println("Skip Arr" + pos_skip.toString());
	}

}
