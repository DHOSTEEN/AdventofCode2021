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
    private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput12_data.txt";

public static void main(String[] args){

    obj_Reader = new PassagePathingReader(file_location);
    //obj_Reader.getAllNodes().forEach(ar -> {System.out.println(Arrays.toString(ar));});
    String[] intial_input = obj_Reader.getNode();
    Node root = new Node(intial_input[0]);
    root.addChild(new Node(intial_input[1]));
    NodeLogic logic = new NodeLogic(root);

    ArrayList<String[]> allNodes = obj_Reader.getAllNodes();

    allNodes.forEach(arr ->{logic.add(arr[0], arr[1]);});
    System.out.println(logic.printTree());
    ArrayList<TuppleBooleanString> all_paths = logic.buildPaths();
    all_paths.forEach(tup -> {System.out.println(tup.getStr());});
    System.out.println(all_paths.size());

    
}
}
