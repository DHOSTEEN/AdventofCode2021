package day22;

import java.util.Arrays;
import java.util.List;

import InputReaders.Day22Reader;

public class TaskOneMain {	
	
	private static Day22Reader obj;
	//private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput21_data.txt";
	private static String filename = "test_data.txt";
	
	public static void main(String[] args){
		
		obj = new Day22Reader(TaskOneMain.class.getResource(filename).getFile());
		List<Integer[]> input = obj.getCuboidDimentions();
		Reactor reac = new Reactor();
		for(Integer[] ar : input) {
			System.out.println(Arrays.asList(ar));
			if(initailization(ar)) {
				//System.out.println("am hashing");
				//reac.inputCuboids(ar[0],ar[1], ar[2], ar[3], ar[4], ar[5], ar[6]);
			}
		}
		System.out.println(reac.numberOn());
		
		//on x=10..12,y=10..12,z=10..12
		//
		reac.inputCuboids(1, 10, 12, 10, 12, 10, 12);
		System.out.println(reac.numberOn());
		reac.inputCuboids(1, 11, 13, 11, 13, 11, 13);
		System.out.println(reac.numberOn());
		reac.inputCuboids(0, 9, 11, 9, 11, 9, 11);
		System.out.println(reac.numberOn());
		reac.inputCuboids(1, 10, 10, 10, 10, 10, 10);
		System.out.println(reac.numberOn());
		
		reac.inputSmartCuboids(1, 10, 12, 10, 12, 10, 12);
		reac.inputSmartCuboids(1, 11, 13, 11, 13, 11, 13);
		reac.inputSmartCuboids(0, 9, 11, 9, 11, 9, 11);
		reac.inputSmartCuboids(1, 10, 10, 10, 10, 10, 10);
		
	//	System.out.println("volume: "+ ( Math.abs(10 - (12+1)) * Math.abs(10 - (12+1)) * Math.abs(10 - (12+1))));
	}
	private static boolean initailization(Integer[] arr) {
		return (arr[1] >-51 && arr[1]<51);
		
	}

}
