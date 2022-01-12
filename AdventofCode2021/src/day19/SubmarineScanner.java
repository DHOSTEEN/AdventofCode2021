package day19;

import java.awt.event.FocusAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SubmarineScanner {
	
	
	private ArrayList<String> coordinates;
	private Map<String, String> absolute_distance;
	private Set<String> unique_points;
	
	public Set<String> getUniques(){return unique_points;}
	public Map<String, String> getHashDistance(){return absolute_distance;}
	
	public SubmarineScanner(ArrayList<String> coordinates) {
		absolute_distance = new HashMap<>();
		this.coordinates = coordinates;
		unique_points = new HashSet<>();
	}
	public void findAbsoulteDistanceSinglePointFocus() {
	
	for(int i =0; i< coordinates.size(); i++) {
		if(i +1 <coordinates.size()) {
			singlePointHelper(coordinates.get(i), coordinates.subList(i+1, coordinates.size()));
		}
	}
	
}
	private void singlePointHelper(String from_coords, List<String> list) {

		String[] raw_coord = from_coords.split(",");
		String set_input;
		String to_coords ="";
		for(int i =0; i<list.size(); i++) {
			set_input = "";
			if(!list.get(i).equals(from_coords)){
				to_coords = list.get(i);
				String[] compare_coord = list.get(i).split(",");
					for(int itr =0; itr<compare_coord.length; itr++) {
						
						int raw_input =  Math.subtractExact(Integer.parseInt(raw_coord[itr]), Integer.parseInt(compare_coord[itr]));
						set_input += raw_input + "|";
	
					}
			}
			if(!set_input.isEmpty()) {
				absolute_distance.put("(" + from_coords + "|" + to_coords +")", "("+ set_input+ ")");
			}

		}
	
	}
	
	public void findAbsoluteDistance() {
		for(int i =0; i<coordinates.size();i++) {
			System.out.println("CHAR TEST: ");
			System.out.println("IS: " + i);
			System.out.println("IS NOW: " + (char)(i+65));
			absoluteHelper(coordinates.get(i),(char)(i+65));
		}
	}
	private void absoluteHelper(String from_coords, Character ch) {
		
		String[] raw_coord = from_coords.split(",");

		String set_input;
		String to_coords ="";
		for(int i =0; i<coordinates.size(); i++) {
			set_input = "";
			if(!coordinates.get(i).equals(from_coords)){
				to_coords = coordinates.get(i);
				String[] compare_coord = coordinates.get(i).split(",");

					for(int itr =0; itr<compare_coord.length; itr++) {
						
						int raw_input =  Math.subtractExact(Integer.parseInt(raw_coord[itr]), Integer.parseInt(compare_coord[itr]));
						set_input += raw_input + ":";
	
					}
			}
			if(!set_input.isEmpty()) {
				String from_key = ch + from_coords;
				String to_key = (char)(i+65) + to_coords;
				absolute_distance.put("(" + from_key + ":" + to_key +")", "("+ set_input+ ")");
			}
		}
		
	}

}
