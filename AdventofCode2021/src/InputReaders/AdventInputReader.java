/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InputReaders;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class AdventInputReader {
  
    protected final File file_obj;
    protected Scanner obj_Reader;

    private ArrayList<int[]> array;
    private String arr_length;

    public AdventInputReader(String filepath){

        file_obj = new File(filepath);
        try{
               obj_Reader = new Scanner(file_obj);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public Scanner getFile_obj() throws NullPointerException{

        return obj_Reader;
    }

    public ArrayList<Integer> integerList(){

        ArrayList<Integer> list = new ArrayList<>();

        while(obj_Reader.hasNextLine()){

            list.add(obj_Reader.nextInt());
        }

        return list;
    }
    public int[][] get2DintArray(){

        array = new ArrayList<>();
        if(obj_Reader.hasNext()){
                arr_length = obj_Reader.nextLine();
        }
        //System.out.println(arr_length);
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

    public void testScan(Scanner scan){

        while(scan.hasNextLine()){

            System.out.println(scan.nextLine());
        }
    }

    
}//end of class