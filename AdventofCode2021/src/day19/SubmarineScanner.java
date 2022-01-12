package day19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubmarineScanner {
	
	
	ArrayList<String> coordinates;
	private Map<String, Integer> absolute_distance;
	private Set<String> set_distance;
	
	public Set<String> getDistances(){return set_distance;}
	public Map<String, Integer> getHashDistance(){return absolute_distance;}
	
	public SubmarineScanner(ArrayList<String> coordinates) {
		absolute_distance = new HashMap<>();
		this.coordinates = coordinates;
		set_distance = new HashSet<>();
	}

	public void findAbsoluteDistance() {
		for(int i =0; i<coordinates.size();i++) {
			absoluteHelper(coordinates.get(i));
		}
	}
	private void absoluteHelper(String coords) {
		
		String[] raw_coord = coords.split(",");
		String set_input;
		for(int i =0; i<coordinates.size(); i++) {
			set_input = "";
			if(!coordinates.get(i).equals(coords)){
				String[] compare_coord = coordinates.get(i).split(",");
				for(int itr =0; itr<compare_coord.length; itr++) {
					
					int raw_input =  Math.subtractExact(Integer.parseInt(raw_coord[itr]), Integer.parseInt(compare_coord[itr]));
					System.out.println("ABS: " + raw_input);
					set_input += raw_input + "|";
					/*if(itr+1>=compare_coord.length) {
						set_input += raw_input + ")";
					}
					else{set_input += raw_input + ",";}
					*/
				}
			}
			if(!set_input.isEmpty()) {
				absolute_distance.put(set_input, 0);
				set_distance.add(set_input);
			}
		}
		
	}

}
