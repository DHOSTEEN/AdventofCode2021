package day22;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Reactor {
	
	private Map<String, Boolean> cubes;
	private Map<String, Cuboid> smart_cubes;
	private String lower;
	private String upper;
	
	public Map<String, Boolean> getCuboid(){return cubes;}
	
	public Reactor() {
		
		cubes = new HashMap<>();
		smart_cubes = new HashMap<>();
		
	}
	
	public void inputCuboids(int bools, int x_begin, int x_end, int y_begin, int y_end, int z_begin, int z_end) {
		
		boolean is_on = bools == 1;
		//String[] lower_vals = lower.split(":");
		//String[] upper_vals = upper.split(":");
		
		String key = x_begin + ":" + x_begin + ":" + x_begin;

		for(int x = x_begin; x<x_end+1; x++) {
			for(int y = y_begin; y<y_end+1; y++) {
				for(int z = z_begin; z<z_end+1; z++) {
					//System.out.print(x + "," + y + "," + z + "\n");
				key = x + ":" + y + ":" + z;
				//System.out.println("key: " + key);
				cubes.put(key, is_on);
				
				}
				//System.out.println();
			}
			//System.out.println();
		}
		//System.out.println("is_on: " + is_on);
	}
	//know own boundries
	//remove duplicate boundries
	
	//AUB = A+B - (ANB)
	public void inputSmartCuboids(int bools, int x_begin, int x_end, int y_begin, int y_end, int z_begin, int z_end) {
		
		String key = x_begin + ":" + x_end + ":" + y_begin + ":" + y_end + ":" + z_begin + ":" + z_end; 
		Cuboid cuboid = new Cuboid(bools == 1, x_begin, x_end, y_begin, y_end, z_begin, z_end);
		System.out.println("vol: " + cuboid.volume);
		System.out.println("Smart cube size: " + smart_cubes.size());
		
		for(String other_key : smart_cubes.keySet()) {
			
			if(cuboid.is_intersection(smart_cubes.get(other_key))) {
				//Cuboid other = smart_cubes.get(key);
				
				///need to accounmt for pure intersets turin ON
				
				long test =cuboid.getVolume(cuboid.intersets(smart_cubes.get(other_key)));
				System.out.println("TEST INTERSECT : " + test);
				
				cuboid.volume = cuboid.volume + (smart_cubes.get(other_key)).volume - cuboid.getVolume(cuboid.intersets(smart_cubes.get(other_key)));
				System.out.println("new vol: " + cuboid.volume );
				
				
				cuboid.begin_x = smart_cubes.get(other_key).begin_x < x_begin ? smart_cubes.get(other_key).begin_x : cuboid.begin_x;
				cuboid.begin_y = smart_cubes.get(other_key).begin_y < x_begin ? smart_cubes.get(other_key).begin_y : cuboid.begin_y;
				cuboid.begin_z = smart_cubes.get(other_key).begin_z < x_begin ? smart_cubes.get(other_key).begin_z : cuboid.begin_z;
				
				cuboid.end_x = smart_cubes.get(other_key).end_x < x_begin ? smart_cubes.get(other_key).end_x : cuboid.end_x;
				cuboid.end_y = smart_cubes.get(other_key).end_y < x_begin ? smart_cubes.get(other_key).end_y : cuboid.end_y;
				cuboid.end_z = smart_cubes.get(other_key).end_z < x_begin ? smart_cubes.get(other_key).end_z : cuboid.end_z;
				
				smart_cubes.remove(other_key);
			}
			/*
			System.out.println("HI");
			long[] wibs = smart_cubes.get(other_key).intersets(cuboid);
			System.out.println("interection: " + cuboid.is_intersection(smart_cubes.get(other_key)));
			System.out.println("VOLUME: " + smart_cubes.get(other_key).getIntersectionVolume(cuboid));
			System.out.println("VOLUME_SIMPLE: " + smart_cubes.get(other_key).getVolume(wibs));
			for(int i =0; i<wibs.length;i++) {
				System.out.println(wibs[i]);
			}*/
		}
		smart_cubes.put(key, cuboid);
		
	}
	
	public long numberOn() {
		long count = 0L;
		for(Boolean is_on : cubes.values()) {
			if(is_on) {
				count++;
			}
		}
		return count;
	}
	

}
