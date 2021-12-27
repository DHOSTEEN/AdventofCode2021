/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day5;

import InputReaders.Hydrothermal_Venture_Reader;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */

//one LONG array instead of [][], to find, say, (3,5) do, 3x5 to get actaul pos. zero centered
public class Hydrothermal_Venture_Main {

private static Hydrothermal_Venture_Reader obj;
private static Scanner scan;

private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput05_data.txt";

private static DiagramLogic logic;
private static int TEST_ARR_SIZE =10;
private static int DATA_ARR_SIZE = 1000;

public static void main(String[] args){

    obj = new Hydrothermal_Venture_Reader(file_location);
    scan = obj.getFile_obj();
    Diagram dia = new Diagram(DATA_ARR_SIZE);
    logic = new DiagramLogic(dia);

    while(scan.hasNext()){
        //System.out.println(obj.full_coordinates());
        Coodinates coords = obj.getCoords(obj.full_coordinates());
       // System.out.println("(" +coords.getBegin().getX_val() + ", " + coords.getBegin().getY_val() + ")" + 
//" --> (" + coords.getEnd().getX_val() + ", " + coords.getEnd().getY_val() + ")");
   
       // String[][] test = dia.getDiagram();
        //System.out.println(dia.printDia());
        //System.out.println(logic.is_Not_dia(coords));
        if(logic.is_Not_dia(coords)){
            logic.markLine(coords);
        }
        else{logic.markDiagonalLine(coords);}
    }
    //System.out.println(dia.printDia());
    System.out.println(dia.countOverlap());
}
    
}
