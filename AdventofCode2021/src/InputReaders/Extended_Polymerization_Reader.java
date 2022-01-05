/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InputReaders;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Extended_Polymerization_Reader extends AdventInputReader{

    public Extended_Polymerization_Reader(String file_path){
        super(file_path);
    }
    /**Assumes .txt file to be on first available insertion*/
    public ArrayList<String[]> getAllInsertions(){
        ArrayList<String[]> list = new ArrayList<>();

        while(obj_Reader.hasNext()){
            list.add(obj_Reader.nextLine().split("->"));
        }
        return list;
    }
/**returns first line in .txt and skips next line to set up Extended_Polymerization_Reader.getAllInsertions*/
    public String getPolymer(){
        String poly = obj_Reader.nextLine();
        obj_Reader.nextLine();
        return poly;
    }

}
