/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day12;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Daniel
 */

//MUST have nodes
public class NoTreeLogic {
    
    private NoTree map;
    private ArrayList<Node> nodes;
    private ArrayList<ArrayList<String>> all_paths;
    private HashMap<String, Integer> all_hash_paths;
    private ArrayList<String> twiced_caves;

    public NoTreeLogic(String[] arr){
        map = new NoTree();
        map.add(arr[0], arr[1]);
        all_paths = new ArrayList<>();
        twiced_caves = new ArrayList<>();
        all_hash_paths = new HashMap<>();
    }

//public makeNodes(){}
    public void buildMap(String[] arr){
        map.add(arr[0], arr[1]);
    }

    public ArrayList<ArrayList<String>> buildPath(){
        String path = "";

       buildPathHelper("start", map.getMap().get("start"), new ArrayList<>(), new ArrayList<>(), true);
   
        return all_paths;
    }
public HashMap<String, Integer> buildHashPath(){
    for(String key : map.getSmallCaves()){
           buildPathHelperTaskTWO("start", map.getMap().get("start"), "", new ArrayList<>(), true, key, true);
    }

    return all_hash_paths;}

private void buildPathHelper(String head, ArrayList<String> list, ArrayList<String> path, ArrayList<String> duplicates, boolean is_start){

    //System.out.println("LIST IS: " + list.toString());
    //System.out.println("HEAD: " + head);
    //System.out.println("DUP" + duplicates.toString());
    path.add(head);
    //System.out.println("Path is: " + path);
    if(head.equals("end")){
        all_paths.add(path);
        return;
    }
    if(head.equals("start") && !is_start){
        return;
    }
    int i =0; 
    boolean found = false;
    TuppleBooleanString tupple = new TuppleBooleanString(false, "");
    if(duplicates.contains(head)){
        //System.out.println("I HAS: " + head);
        return;
    }

    if(Character.isLowerCase(head.toCharArray()[0]) && !head.equals("start")){
        //System.out.println("I ADDS: " + head);
        duplicates.add(head);
    }

    
    while(!found && i<list.size()){

        buildPathHelper(list.get(i), map.getMap().get(list.get(i)), safe_copy(path), safe_copy(duplicates), false); 
        i++;
    }

}

private void buildPathHelperTaskTWO(String head, ArrayList<String> list, String path, ArrayList<String> duplicates, boolean is_start, String twice_caver, boolean is_allowed){

    //System.out.println("LIST IS: " + list.toString());
    //System.out.println("HEAD: " + head);
    //System.out.println("DUP" + duplicates.toString());
    path += head;
    //System.out.println("Path is: " + path);
    if(head.equals("end")){
       // if(!all_hash_paths.containsKey(path)){
            all_hash_paths.put(path, path.length());
        //}
        return;
    }
    if(head.equals("start") && !is_start){
        return;
    }
    int i =0; 
    boolean found = false;
    TuppleBooleanString tupple = new TuppleBooleanString(false, "");
    if(duplicates.contains(head)){
        //System.out.println("I HAS: " + head);
        return;
    }
    if(head.equals(twice_caver) && !is_allowed){
        duplicates.add(head);
    }
    if(Character.isLowerCase(head.toCharArray()[0]) && !head.equals("start") && !head.equals(twice_caver)){
        //System.out.println("I ADDS: " + head);
        duplicates.add(head);
    }
    if(head.equals(twice_caver)){is_allowed = false;}
  
    while(i<list.size()){

        buildPathHelperTaskTWO(list.get(i), map.getMap().get(list.get(i)), path, safe_copy(duplicates), false, twice_caver, is_allowed); 
        i++;
    }
    
}
private ArrayList<String> safe_copy(ArrayList<String> list){
ArrayList<String> wibs = new ArrayList<>();
for(int i =0; i<list.size();i++){wibs.add(list.get(i));}
return wibs;


}
    public void printMap(){
        map.getMap().entrySet().forEach(set -> {System.out.println(set);});
    }
}
