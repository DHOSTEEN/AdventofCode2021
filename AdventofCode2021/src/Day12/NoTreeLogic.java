/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day12;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Daniel
 */

//MUST have nodes
public class NoTreeLogic {
    
    private NoTree map;
    private ArrayList<Node> nodes;
    private ArrayList<ArrayList<String>> all_paths;

    public NoTreeLogic(String[] arr){
        map = new NoTree();
        map.add(arr[0], arr[1]);
        all_paths = new ArrayList<>();
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
private ArrayList<String> safe_copy(ArrayList<String> list){
ArrayList<String> wibs = new ArrayList<>();
for(int i =0; i<list.size();i++){wibs.add(list.get(i));}
return wibs;


}
    public void printMap(){
        map.getMap().entrySet().forEach(set -> {System.out.println(set);});
    }
}
