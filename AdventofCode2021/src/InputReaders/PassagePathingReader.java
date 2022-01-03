/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InputReaders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class PassagePathingReader extends AdventInputReader{

    public PassagePathingReader(String file_path){
        super(file_path);
    }
    public String[] getNode(){
        return obj_Reader.nextLine().split("-");
    }
    public ArrayList<String[]> getAllNodes(){
        ArrayList<String[]> all_nodes = new ArrayList<>(15);
        while(obj_Reader.hasNext()){
            all_nodes.add(getNode());
        }
        return all_nodes;
    }
}
