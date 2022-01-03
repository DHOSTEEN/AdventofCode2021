/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day12;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Daniel
 */
public class NoTree {

private HashMap<String, ArrayList<String>> uniques; 

    public NoTree(){
        uniques = new HashMap<>();
    }
    public void add(String parent, String child){

        if(uniques.get(parent) != null){

            uniques.get(parent).add(child);
        }
        else{
            ArrayList<String> children = new ArrayList<>();
            children.add(child);
            uniques.put(parent, children);
        }
    }   
    public HashMap<String, ArrayList<String>> getMap(){return uniques;}
}


