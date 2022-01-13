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
    private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput19_simple.txt";
    
    private static ArrayList<SubmarineScanner> all_scanners;
    private static Map<Character, Character> converter = new HashMap<>();
	
	private static Set<Character> same = new HashSet<>();
	private static Set<String> in_two_pairs = new HashSet<>();
    
    private static final int DIMENTION = 2;
    
    /*The algorithm is:

    For each scanner, find the square distance between each pair of beacons.

    Compare these distances between scanners. That tells you which scanners overlap.

    For each of these overlapping scanners (s1 and s2, say), use a pair of beacons to find the correct rotation of beacons in s2 so that they align to beacons in s1. 
    As part of finding the rotation, the location of the scanner (relative to the first scanner) pops out.*/
	
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
			a_scanner.findAbsoulteDistanceSinglePointFocus();
			all_distances.add(a_scanner.getHashDistance());			
			all_scanners.add(a_scanner);
		}
	
		System.out.println(all_scanners.get(0).getHashDistance());
		System.out.println(all_scanners.get(1).getHashDistance());
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
					System.out.println("THE VAL: " + val);
					temp_map.put(val, key + ":" + other_key);
					count++;
					
					
				}
			}
		}
		System.out.println("count: " + count);
		System.out.println("map size: " + temp_map.size());
		System.out.println("MAP: " + temp_map);
		
		if(count == 66) {
			//rotateScanner(first, second);
		}
		
	}
	
}