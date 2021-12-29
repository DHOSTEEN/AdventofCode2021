/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InputReaders;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Daniel
 */
public class Smoke_Basin_Reader extends AdventInputReader{

ArrayList<int[]> array;

private String arr_length;
    public Smoke_Basin_Reader(String file_path){super(file_path);}

    public int[][] getHeighttMap(){
        array = new ArrayList<>();
        if(obj_Reader.hasNext()){
                arr_length = obj_Reader.nextLine();
        }
        System.out.println(arr_length);
        array.add(getRow(arr_length.split("")));
        int i = 1;
        while(obj_Reader.hasNext()){
                String line = obj_Reader.nextLine();
                array.add(getRow(line.split("")));
                i++;
        }
        int[][] height_map = new int[array.size()][arr_length.length()];
        height_map = array.toArray(height_map);
        return height_map;
    }

    private int[] getRow(String[] arr){
        int[] row = new int[arr_length.length()];
        for(int i =0; i<row.length;i++){
            row[i] = Integer.parseInt(arr[i]);
        }
        return row;
    }
    
}
