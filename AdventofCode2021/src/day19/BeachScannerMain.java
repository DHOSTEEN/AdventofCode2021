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
	
	private static Set<Character> same = new HashSet<>();
	private static Set<String> in_two_pairs = new HashSet<>();
    
    private static final int DIMENTION = 2;
    
    public static final String RED = "\033[0;31m";
    public static final String RESET = "\033[0m";  // Text Reset
	
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
	
		
		int count = 0;
		System.out.println("All scanners: " + all_scanners.size());
		for(int i =0; i<all_scanners.size(); i++) {
			System.out.println("I AM SCANNER: " + i + " bool: " + ((i+1)<all_scanners.size()));
			if((i+1)<all_scanners.size()) {
				
				compareAbsoluteDistances(all_scanners.get(i), all_scanners.get(i+1));
				System.out.println("FOUND: " + same.toString());
				same = new HashSet<>();
			}
		}
		
		System.out.println("CONVERT: " + converter.toString());
		System.out.println("FOUND PAIRS: " + in_two_pairs);
		System.out.println("SIZE: " + in_two_pairs.size());
		
		
	}
	public static void compareAbsoluteDistances(SubmarineScanner first, SubmarineScanner second) {
		
		
		int count = 0;
		Map<String, String> temp_map = new HashMap<>();
		ArrayList<String[]> compare = new ArrayList<>();
		//System.out.println("THE HASH: " +first.getHashDistance());
		//System.out.println("SECOND HASH:  " + second.getHashDistance());
		for(String key: first.getHashDistance().keySet()) {
			String val = first.getHashDistance().get(key);
			
			for(String other_key: second.getHashDistance().keySet()) {
			//	System.out.println("on: " + other_key);
				String other_val = second.getHashDistance().get(other_key);
				if(val.equals(other_val)) {
					
					String[] pair = new String[DIMENTION];
					pair[0] = key;
					pair[1] = other_key;
					compare.add(pair);
					System.out.println("THE SAME: " + key + " - " + other_key);
					//System.out.println("THE VAL: " + val);
					temp_map.put(key + "|" + other_key, val);
					
					
				}
			}
		}
		System.out.println("count: " + count);
		System.out.println("map size: " + temp_map.size());
		//forceNoDuplicates(compare);
		findPairs(compare);
		findWithKey(compare);
		//findOther(compare);
		
	}
	
	private static void forceNoDuplicates(ArrayList<String[]> pairs) {
		for(int i =0; i<pairs.size();i++) {
					
			noDuplicates(pairs.get(i));
		}
	}
	private static void noDuplicates(String[] pair) {
		
		String first_key = pair[0];
		first_key = first_key.substring(1,first_key.length()-1);//trim ()
		String[] first_key_IDs = first_key.split(":");//into 3 eventually
		
		String second_key = pair[1];
		second_key = second_key.substring(1, second_key.length()-1);
		String[] second_key_IDs = second_key.split(":");
		
		System.out.println("FIRST PAIR: " + Arrays.toString(first_key_IDs) + " lenght; " + first_key_IDs.length);
		System.out.println("SECOND PAIR: " + Arrays.toString(second_key_IDs));

		Set<Integer> pos_skip = new HashSet<>();
		for(int i =0; i<first_key_IDs.length; i++) {
			
			char first_ID = first_key_IDs[i].charAt(0);
			char second_ID = second_key_IDs[i].charAt(0);
			System.out.println("the chars: " + first_ID + " - " + second_ID);
			if(first_ID == second_ID) {

				System.out.println("SUCCESS!!" + Arrays.toString(pair));
				same.add(first_ID);
			}
		}
		
	}
	private static void findPairs(ArrayList<String[]> pairs) {
		for(int i =0; i<pairs.size();i++) {
			
			pairHelper(pairs.get(i));
		}
	}
	private static void pairHelper(String[] pair) {		
		

			String first_key = pair[0];
			first_key = first_key.substring(1,first_key.length()-1);//trim ()
			String[] first_key_IDs = first_key.split(":");//into 3 eventually
			
			String second_key = pair[1];
			second_key = second_key.substring(1, second_key.length()-1);
			String[] second_key_IDs = second_key.split(":");
			
			System.out.println("FIRST PAIR: " + Arrays.toString(first_key_IDs) + " lenght; " + first_key_IDs.length);
			System.out.println("SECOND PAIR: " + Arrays.toString(second_key_IDs));

			Set<Integer> pos_skip = new HashSet<>();
			for(int i =0; i<first_key_IDs.length; i++) {
				
				char first_ID = first_key_IDs[i].charAt(0);
				char second_ID = second_key_IDs[i].charAt(0);
				System.out.println("the chars: " + first_ID + " - " + second_ID);
				if(first_ID == second_ID) {

					System.out.println("SUCCESS!!" + Arrays.toString(pair));

					pos_skip.add(i);
					for(int itr =0; itr<first_key_IDs.length; itr++) {
						
						if(!pos_skip.contains(itr)) {
							
							if(!same.contains(first_ID)) {
								first_ID = first_key_IDs[itr].charAt(0);
								second_ID = second_key_IDs[itr].charAt(0);	
								System.out.println("MAKING CONV KEY: " + second_ID + " - " + first_ID);
								converter.put(second_ID, first_ID);
							}
						}
					}
				}
			}
	}

	private static void findWithKey(ArrayList<String[]> pairs) {
		for(int i =0; i<pairs.size();i++) {
			
			keyHelper(pairs.get(i));
		}
	}
	
	private static void keyHelper(String[] pair) {
		
		String first_key = pair[0];
		first_key = first_key.substring(1,first_key.length()-1);//trim ()
		String[] first_key_IDs = first_key.split(":");//into 3 eventually
		
		String second_key = pair[1];
		second_key = second_key.substring(1, second_key.length()-1);
		String[] second_key_IDs = second_key.split(":");
		
		System.out.println("CONVERTER: " + converter);
		System.out.println("FIRST PAIR CONV: " + Arrays.toString(first_key_IDs) + " lenght; " + first_key_IDs.length);
		System.out.println("SECOND PAIR CONV: " + Arrays.toString(second_key_IDs));
		
		
		Set<Integer> pos_skip = new HashSet<>();
		int count =0;
		for(int i =0; i<first_key_IDs.length; i++) {
			
			char first_ID = first_key_IDs[i].charAt(0);
			char second_ID = second_key_IDs[i].charAt(0);
			System.out.println("CONV: " + first_ID + " - " + second_ID);
			if(converter.containsKey(second_ID)) {
				System.out.println("AM COVERTING: " + second_ID + " to " + converter.get(second_ID));
				System.out.println("second: " + second_ID);
				second_ID = converter.get(second_ID);
				System.out.println("second now: " + second_ID);
			}
			if(first_ID == second_ID) {
				count++;
				if(count == 2) {
					
				}
			}
		}
		if(count ==2) {
			//SHOULD MEAN HAVE FOUND SHARED
			String temp = Arrays.toString(pair);
			in_two_pairs.add(temp);
		}
	}
		
	
	
	
	private static void findOther(ArrayList<String[]> pairs) {
		for(int i =0; i<pairs.size();i++) {
			
			otherHelper(pairs.get(i));
		}
	}
	private static void otherHelper(String[] pair) {
		
		String first_key = pair[0];
		first_key = first_key.substring(1,first_key.length()-1);//trim ()
		String[] first_key_IDs = first_key.split(":");//into 3 eventually
		
		String second_key = pair[1];
		second_key = second_key.substring(1, second_key.length()-1);
		String[] second_key_IDs = second_key.split(":");
		
		Set<Integer> pos_skip = new HashSet<>();
		System.out.println("BEFORE CONTAINS " +  Arrays.toString(pair));

		boolean success = false;
		int count = 0;
		for(int i =0; i<first_key_IDs.length; i++) {
			
			char first_ID = first_key_IDs[i].charAt(0);
			char second_ID = second_key_IDs[i].charAt(0);

			if(first_ID == second_ID){

					pos_skip.add(i);
					success = true;
					System.out.println("Proof of concept");

			}
		}
		for(int i =0; i<first_key_IDs.length; i++) {
			if(!pos_skip.contains(i) && success) {
				
				char first_ID = first_key_IDs[i].charAt(0);
				char second_ID = second_key_IDs[i].charAt(0);					
				converter.put(first_ID, second_ID);
			}
		}
		
	}
}
