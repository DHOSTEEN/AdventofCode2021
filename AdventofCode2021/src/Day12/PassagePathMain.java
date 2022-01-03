/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day12;

import InputReaders.PassagePathingReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Daniel
 */
public class PassagePathMain {

    private static PassagePathingReader obj_Reader;
    private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput12_testdata.txt";

public static void main(String[] args){

    obj_Reader = new PassagePathingReader(file_location);
    //obj_Reader.getAllNodes().forEach(ar -> {System.out.println(Arrays.toString(ar));});
    ArrayList<String[]> allNodes = obj_Reader.getAllNodes();
    String[] intial_input ={"NO", "NO"};

    for(int i =0; i<allNodes.size(); i++){
        if(allNodes.get(i)[0].equals("start")){
            intial_input = allNodes.get(i);
            allNodes.remove(i);
            break;
        }
        else if(allNodes.get(i)[1].equals("start")){
            intial_input[0] = allNodes.get(i)[1];
            intial_input[1] = allNodes.get(i)[0];
            allNodes.remove(i);
            break;
        }
    }
  
    System.out.println("INIT: " + Arrays.toString(intial_input));
    allNodes.forEach(arr -> {System.out.println(Arrays.toString(arr));});

    Node root = new Node(intial_input[0]);
    root.addChild(new Node(intial_input[1]));
    NodeLogic logic = new NodeLogic(root);

 
    allNodes.forEach(arr -> {System.out.println(Arrays.toString(arr));});
    allNodes.forEach(arr ->{System.out.println("NODE: " + arr[0] + "-" + arr[1]);logic.add(arr[0], arr[1]);});
    //System.out.println(logic.printTree());
    ArrayList<String> all_paths = logic.buildPaths();
    all_paths.forEach(tup -> {System.out.println(tup);});
    System.out.println(all_paths.size());

    
}
}
