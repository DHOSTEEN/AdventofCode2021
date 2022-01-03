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

        buildPathHelper("start", map.getMap().get("start"), new ArrayList<>(), new ArrayList<>());
        return all_paths;
    }

private void buildPathHelper(String head, ArrayList<String> list, ArrayList<String> path, ArrayList<String> duplicates){

    System.out.println("LIST IS: " + list.toString());
    System.out.println("HEAD: " + head);
    System.out.println("DUP" + duplicates.toString());
    path.add(head);
    System.out.println("Path is: " + path);
    if(head.equals("end")){
        all_paths.add(path);
        return;
    }
    int i =0; 
    boolean found = false;
    TuppleBooleanString tupple = new TuppleBooleanString(false, "");
    if(duplicates.contains(head)){
        System.out.println("I HAS: " + head);
        return;
    }

    if(Character.isLowerCase(head.toCharArray()[0]) && !head.equals("start")){
        System.out.println("I ADDS: " + head);
        duplicates.add(head);
    }
        if(path.size()-2>0){
            if(map.getMap().get(path.get(path.size()-2))!=null && !path.get(path.size()-2).equals("start")){
                System.out.println("Wanna go back to: " +path.get(path.size()-2));
                buildPathHelper(path.get(path.size()-2), map.getMap().get(path.get(path.size()-2)), safe_copy(path), safe_copy(duplicates));
            }
        }
    while(!found && i<list.size()){

        System.out.println("I TRY TO GET: " + list.get(i));
        if(map.getMap().get(list.get(i))!=null){
            buildPathHelper(list.get(i), map.getMap().get(list.get(i)), safe_copy(path), safe_copy(duplicates));
        }
        else{ 
            buildPathHelper(list.get(i), new ArrayList<>(), safe_copy(path), safe_copy(duplicates));
        }
        found = tupple.is_true();

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
