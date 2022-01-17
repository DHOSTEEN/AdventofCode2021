package day22;

import java.util.Map;

public class Cuboid {
	
	private Map<String, Boolean> cubes;
	
	public long begin_x;
	public long begin_y;
	public long begin_z;
	
	public long end_x;
	public long end_y;
	public long end_z;
	
	public boolean is_on;
	
	public long volume;
	
	public Cuboid(boolean is_on, long begin_x, long end_x, long beging_y, long end_y, long begin_z, long end_z) {
		
		this.is_on = is_on;
		
		this.begin_x = begin_x;
		this.begin_y = beging_y;
		this.begin_z = begin_z;
		
		this.end_x = end_x;
		this.end_y = end_y;
		this.end_z = end_z;
		
		 volume = Math.abs(begin_x - (end_x+1)) * Math.abs(begin_y - (end_y+1)) * Math.abs(begin_z - (end_z+1));// ie number on/off
		 if(!is_on) {
			 volume = 0;
		 }
	}
	
	public long getNum() {return volume;}
	
	/*Stackoverflow Antti Huima VOLUME OF OVERLAP

	The overlap of two non-rotated cubes is still a 'box'. If two corner points of box A are (x,y,z) and (x',y',z') (x'>x,y'>y,z'>z)
	 and two corner points of box B are (a,b,c) and (a',b',c') (a'>a,b'>b,c'>c) then the volume of the overlap is

	max(min(a',x')-max(a,x),0)	* max(min(b',y')-max(b,y),0)	* max(min(c',z')-max(c,z),0) 
	* 
	* 
	*/
	
	public long getIntersectionVolume(Cuboid other) {
		
		long volume = Math.max(Math.min(other.end_x, end_x) - Math.max(other.begin_x, begin_x),0)
					* Math.max(Math.min(other.end_y, end_y) - Math.max(other.begin_y, begin_y),0)
					* Math.max(Math.min(other.end_z, end_z) - Math.max(other.begin_z, begin_z),0);
		return volume;
	}
	
	
	/* 
	* 
	* XminInt;
if ( Xmin1 > Xmax2 )
{
    // no intersection
}
else if ( Xmin1 >= Xmin2 )
{
    // possible cube intersection
    XminInt = Xmin1;
}
else if ( Xmin2 <= Xmax1 )
{
    // possible cube intersection
    XminInt = Xmin2;
}
	* */
	public long getVolume(long[] coords) {

		long count = 0L;
		for(long x = coords[0]; x<coords[1]+1; x++) {
			for(long y = coords[2]; y<coords[3]+1; y++) {
				for(long z = coords[4]; z<coords[5]+1; z++) {
					//System.out.print(x + "," + y + "," + z + "\n");
				count++;
				}
				//System.out.println();
			}
			//System.out.println();
		}
		return count;
	}
	
	public long[] intersets(Cuboid other) {

		long[] intersections = new long[6];
		if(begin_x > other.end_x) {
			intersections[0] = -1;
			intersections[1] = -1;
		}
		else if(begin_x >= other.begin_x) {
			intersections[0] = begin_x;//begins
			if(end_x >= other.end_x) {
				intersections[1] = other.end_x;
			}
			else {
				intersections[1] = end_x;
			}
		}
		else if(other.begin_x<= end_x) {
			intersections[0] = other.begin_x;
			if(end_x >= other.end_x) {
				intersections[1] = other.end_x;
			}
			else {
				intersections[1] = end_x;
			}
		}
		if(begin_y > other.end_y) {
			intersections[2] = -1;
		}
		else if(begin_y >= other.begin_y) {
			intersections[2] = begin_y;
			if(end_y >= other.end_y) {
				intersections[3] = other.end_y;
			}
			else {
				intersections[3] = end_y;
			}
		}
		else if(other.begin_y <= end_y) {
			intersections[2] = other.begin_y;
			if(end_y >= other.end_y) {
				intersections[3] = other.end_y;
			}
			else {
				intersections[3] = end_y;
			}
		}
		if(begin_z > other.end_z) {
			intersections[4] = -1;
		}
		else if(begin_z >= other.begin_z) {
			intersections[4] = begin_z;
			if(end_z >= other.end_z) {
				intersections[5] = other.end_z;
			}
			else {
				intersections[5] = end_z;
			}
		}
		else if(other.begin_z <= end_z) {
			intersections[4] = other.begin_z;
			if(end_z >= other.end_z) {
				intersections[5] = other.end_z;
			}
			else {
				intersections[5] = end_z;
			}
		}
		return intersections;
	}
	public boolean is_intersection(Cuboid other) {
		if(begin_x > other.end_x) {
			return false;
		}
		
		if(begin_y > other.end_y) {
			return false;
		}
	
		if(begin_z > other.end_z) {
			return false;
		}
		return true;
	}
	

}
