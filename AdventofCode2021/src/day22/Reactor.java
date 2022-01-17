package day22;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reactor {
	
	private Map<String, Boolean> cubes;
	
	public Map<String, Boolean> getCuboid(){return cubes;}
	
	public Reactor() {
		
		cubes = new HashMap<>();
		
	}
	
	private void inputCuboids(int x_begin, int x_end, int y_begin, int y_end, int z_begin, int z_end) {
		
		for(int x = x_begin; x<x_end; x++) {
			for(int y = y_begin; y<y_end; y++) {
				for(int z = z_begin; z<z_end; z++) {
					System.out.print(x + "," + y + "," + z);
				}
			}
		}
	}
	

}
