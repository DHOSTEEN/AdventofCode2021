/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day17;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Daniel
 */
public class Probe {

private long min_x;
private long max_x;
private long min_y;
private long max_y;

private Map<Long, String> greatest_y;

    public Map<String, String> getAll_success() {
        return all_success;
    }
private Map<String, String> all_success;


public Probe(long min_x, long max_x, long min_y, long max_y){
 
    this.min_x = min_x;
    this.min_y = min_y;

    this.max_x = max_x;
    this.max_y = max_y;
    greatest_y = new HashMap<>();
    all_success = new HashMap<>();
}
/*The probe's x,y position starts at 0,0. Then, it will follow some trajectory by moving in steps. On each step, these changes occur in the following order:

The probe's x position increases by its x velocity.
The probe's y position increases by its y velocity.
Due to drag, the probe's x velocity changes by 1 toward the value 0; that is, it decreases by 1 if it is greater than 0, increases by 1 if it is less than 0,
 or does not change if it is already 0.
Due to gravity, the probe's y velocity decreases by 1.*/

public long step(long initial_x_velocity, long initial_y_velocity){

long x_coord = 0L;
long y_coord = 0L;

long x_begins = initial_x_velocity;
long y_begins = initial_y_velocity;
long highest_y = Long.MIN_VALUE;

    while(true){

        if(withinRange(x_coord, y_coord)){
            String key = "(" + x_begins + "," + y_begins + ")";
            String val = "(" + initial_x_velocity + "," + initial_y_velocity + ")";
            all_success.put(key, val);
            if(!greatest_y.containsKey(highest_y)){
                greatest_y.put(highest_y, ("(" + x_begins + "," + y_begins + ")"));
            }
            break;}

        x_coord += initial_x_velocity;
        y_coord += initial_y_velocity;

        if(y_coord < min_y || x_coord>max_x){
            highest_y = Long.MIN_VALUE;
            break;
        }
        if(highest_y<y_coord){highest_y = y_coord;}

        if(initial_x_velocity>0){
            initial_x_velocity--;
        }
        else if(initial_x_velocity<0){
            initial_x_velocity++;
        }
        initial_y_velocity--;//goes down
    }
    //System.out.println("bool test: " + withinRange(x_coord, y_coord));
if(highest_y == Long.MIN_VALUE){
    }
    return highest_y;
}
public String higestStep(){

long result = Long.MIN_VALUE;
long x_coord = 0L;
long y_coord = 10000;//ie IS not negative....?
while(x_coord<=max_x+1){//ie we dont overshoot instantly

    while(y_coord>=min_y-1){
        long test = step(x_coord, y_coord);
        if(result<test){result = test;}
        y_coord --;
    }
    y_coord = 10000;//DIRTY
    x_coord++;
}
//loop, get highest y
    return result + " is highest with " + greatest_y.get(result) + " as initial input";
}
private boolean withinRange(long x, long y){
    /*System.out.println("bools:  X-" + x + " Y-" +y );
    System.out.println("bools:  min X-" + min_x + " min Y-" +min_y );
    System.out.println("bools: max X-" + max_x + "  max Y-" + max_y);
    System.out.println("min x bool: " + (x>=min_x));
    System.out.println("min y bool: " + (y>=min_y));
    System.out.println("max x bool: " + (x<= max_x));
    System.out.println("max y bool: " + (y<=max_y));*/
    return (x>=min_x && x<=max_x) && (y >= min_y && y<= max_y);}
    
}
