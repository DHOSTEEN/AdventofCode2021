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
public class NoTreeMain {
    
    private static PassagePathingReader obj_Reader;
    private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput12_data.txt";

public static void main(String[] args){

    obj_Reader = new PassagePathingReader(file_location);
    //System.out.println(Arrays.toString(obj_Reader.getNode()));
    NoTreeLogic logic = new NoTreeLogic(obj_Reader.getNode());
    obj_Reader.getAllNodes().forEach(arr -> logic.buildMap(arr));
    logic.printMap();
    /*ArrayList<ArrayList<String>> list = logic.buildPath();
    System.out.println(list.size());
    list.forEach(str -> { System.out.println("");
        str.forEach(arr -> {
        System.out.print(arr + "-");
        });
    });*/
    System.out.println(logic.buildHashPath().size());

//99138
}
}
