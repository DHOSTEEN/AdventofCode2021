/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InputReaders;

import Day13.TuppleCharacterInteger;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Daniel
 */
public class Transparent_Origami_Reader extends AdventInputReader{

public Transparent_Origami_Reader(String file_path){
    super(file_path);
}
    private int[] getXY(String raw){
        //System.out.println("In RAW: " + raw);
        String[] raw_coords = raw.split(",");
        int[] coords = new int[2];
        coords[1] = Integer.parseInt(raw_coords[0]);
        coords[0] = Integer.parseInt(raw_coords[1]);
        return coords;
    }
    public ArrayList<int[]> getCoordinates(){
        ArrayList<int[]> all_coords = new ArrayList<>();
        boolean is_end = false;
        while(obj_Reader.hasNextLine() && !is_end){
            String line = obj_Reader.nextLine();
            if(!line.isEmpty()){
                all_coords.add(getXY(line));
            }
            else{is_end = !is_end;}
        }
        //System.out.println("END OF COORDS");
        return all_coords;
    }
    public ArrayList<TuppleCharacterInteger> getInstructions(){
        ArrayList<TuppleCharacterInteger> instructions = new ArrayList<>();
        while(obj_Reader.hasNextLine()){
           instructions.add(createTupple(obj_Reader.nextLine()));

        }
        return instructions;
    }
    private TuppleCharacterInteger createTupple(String line){
        String[] line_split = line.split("=");
        char x = line_split[0].charAt(line_split[0].length()-1);
        return new TuppleCharacterInteger(x, Integer.parseInt(line_split[1]));
    }
    
}
