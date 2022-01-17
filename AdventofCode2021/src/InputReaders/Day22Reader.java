package InputReaders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day22Reader extends AdventInputReader{
	
	public Day22Reader(String file) {
		super(file);
	}
	
	public List<Integer[]> getCuboidDimentions(){
		
		List<Integer[]> list = new ArrayList<>();

		while(obj_Reader.hasNext()) {
			
			Integer[] dimentions = new Integer[7];
			String raw_line = obj_Reader.nextLine();
			//System.out.println(raw_line);
			String[] raws = raw_line.split(" ");
			//System.out.println(raws[0] + " - " + raws[1] + " LENGHT: " +raws.length);
			dimentions[0] = raws[0].equals("on") ? 1 : 0;//is on/off
			String[] raw_boundries = raws[1].split(",");
			//x = , y = etc...
			String vals = "";
			int dim_pos = 1;
			for(String str : raw_boundries) {
				//System.out.println(str);
				vals = str.substring(2);
				//System.out.println("IS NOW: " + vals);
				String[] upper_lower = vals.split("\\..");
				//System.out.println("LENGTH OF VALS: " + upper_lower.length);
				for(int i =0; i<upper_lower.length; i++) {
					//System.out.println("INDIVIDUAL: " + upper_lower[i]);
					dimentions[dim_pos] = Integer.parseInt(upper_lower[i]);
					dim_pos++;
				}
				
			}

			//System.out.println("ARRAY: ");
			//Arrays.asList(dimentions).forEach(i -> {System.out.println("is: " + i);});
			list.add(dimentions);			
			
		}
		return list;
	}
}
