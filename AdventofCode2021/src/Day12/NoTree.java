/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Daniel
 */
public class NoTree {

private HashMap<String, ArrayList<String>> uniques; 
private Set<String> small_caves;

    public NoTree(){
        uniques = new HashMap<>();
        small_caves = new LinkedHashSet<>();
    }
    public void add(String parent, String child){

        if(Character.isLowerCase(parent.toCharArray()[0]) && !parent.equals("end") && !parent.equals("start")){
            if(!small_caves.contains(parent)){
                small_caves.add(parent);
            }
        }
        if(Character.isLowerCase(child.toCharArray()[0]) && !child.equals("end") && !child.equals("start")){
            if(!small_caves.contains(child)){
                small_caves.add(child);
            }
        }
        if(uniques.containsKey(parent)){

            uniques.get(parent).add(child);
            if(uniques.get(child)!=null){
                uniques.get(child).add(parent);
            }
            else{
                ArrayList<String> children = new ArrayList<>();
                children.add(parent);
                uniques.put(child, children);
            }
        }
        else{
            ArrayList<String> children = new ArrayList<>();
            children.add(child);
            uniques.put(parent, children);
            if(uniques.containsKey(child)){
                uniques.get(child).add(parent);
            }
            else{
                children = new ArrayList<>();
                children.add(parent);
                uniques.put(child, children);
            }
        }
    }   
    public HashMap<String, ArrayList<String>> getMap(){return uniques;}
    public Set<String> getSmallCaves(){return small_caves;}
}


