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


    public void testScan(Scanner scan){

        while(scan.hasNextLine()){

            System.out.println(scan.nextLine());
        }
    }

    
}//end of class