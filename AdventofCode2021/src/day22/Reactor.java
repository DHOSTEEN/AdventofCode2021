package day22;

import java.util.ArrayList;
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
		ArrayList<String> removals = new ArrayList<>();
		
		boolean remove_other = false;
		boolean add_self = true;
		
		for(String other_key : smart_cubes.keySet()) {
			remove_other = false;
			Cuboid other = smart_cubes.get(other_key);
			if(cuboid.is_intersection(other) && other !=null && key != other_key) {
				//Cuboid other = smart_cubes.get(key);
				
				///need to accounmt for pure intersets turin ON
				add_self = false;
				long test =cuboid.getVolume(cuboid.intersets(other));
				System.out.println("TEST INTERSECT : " + test);
				System.out.println("TEST INTERSECT MATH: " + cuboid.getIntersectionVolume(other));
				
				if(cuboid.volume <0) {//ie is negative
					//cuboid.volume = cuboid.volume + (other).volume - cuboid.getVolume(cuboid.intersets(other));
					other.volume = other.volume - cuboid.getVolume(cuboid.intersets(other));
					System.out.println("testy vil: " +other.volume);
					//UPDATW VALS AS BELOW, DO NOT ADD KEY
					updateCuboid(other, cuboid);
				}
				else {
					System.out.println("me?");
					System.out.println("TESTING: " + ( cuboid.volume + (other).volume - cuboid.getVolume(cuboid.intersets(other))));
					System.out.println("VS: " + cuboid.volume);
					if(cuboid.volume + (other).volume - cuboid.getVolume(cuboid.intersets(other)) == cuboid.volume ||
							cuboid.volume + (other).volume - cuboid.getVolume(cuboid.intersets(other)) == other.volume) {
						other.volume = other.volume + cuboid.getVolume(cuboid.intersets(other));
						System.out.println("new vol other : " + other.volume );
						updateCuboid(other, cuboid);
						
					}
					else{
						System.out.println("in normal");
						cuboid.volume = cuboid.volume + (other).volume - cuboid.getVolume(cuboid.intersets(other));
						remove_other = true;
						updateCuboid(cuboid, other);
						smart_cubes.put(key, cuboid);
					}
					
				
				}
				//System.out.println("new vol: " + cuboid.volume );
			
				
				//updateCuboid(cuboid, other);
				if(remove_other) {
					removals.add(other_key);
				}
			}
			/*
			System.out.println("HI");
			long[] wibs = other.intersets(cuboid);
			System.out.println("interection: " + cuboid.is_intersection(other));
			System.out.println("VOLUME: " + other.getIntersectionVolume(cuboid));
			System.out.println("VOLUME_SIMPLE: " + other.getVolume(wibs));
			for(int i =0; i<wibs.length;i++) {
				System.out.println(wibs[i]);
			}*/
		}
		if(add_self && cuboid.volume>0) {
			System.out.println("I ADD");
			smart_cubes.put(key, cuboid);
		}
		for(String duplicate: removals) {
			smart_cubes.remove(duplicate);
		}
		
		
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
	public long smartOn() {
		long count = 0L;
		for(Cuboid cuboid : smart_cubes.values()) {
			System.out.println("i has?");
			if(cuboid.is_on) {
				count += cuboid.volume;
			}
		}
		return count;
	}
	
	private void updateCuboid(Cuboid cuboid, Cuboid other) {
		
		cuboid.begin_x = other.begin_x < cuboid.begin_x ? other.begin_x : cuboid.begin_x;
		cuboid.begin_y = other.begin_y < cuboid.begin_y ? other.begin_y : cuboid.begin_y;
		cuboid.begin_z = other.begin_z < cuboid.begin_z ? other.begin_z : cuboid.begin_z;
		
		cuboid.end_x = other.end_x > cuboid.end_x ? other.end_x : cuboid.end_x;
		cuboid.end_y = other.end_y > cuboid.end_y ? other.end_y : cuboid.end_y;
		cuboid.end_z = other.end_z > cuboid.end_z ? other.end_z : cuboid.end_z;
	}
	

}
