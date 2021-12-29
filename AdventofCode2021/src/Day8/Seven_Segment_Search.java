/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day8;

import InputReaders.Seven_Segment_Search_Reader;
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 *
 * @author Daniel
 */
public class Seven_Segment_Search {

//  acedgfb = 7 seg
//  cdfbe   = 5 seg         
//  gcdfa   = 5 seg
//  fbcad   = 5seg
//  dab     = 3 seg
//  cefabd  = 6 seg
//  cdfgeb  = 6 seg
//  eafb    = 4 seg
//  cagedb  = 6 seg
//  ab      = 2seg therefore 1

//  fgaebd 
//  cg      = 1 ie cf
//  bdaec
//  gdafb
//  agbcfd 
//  gdcbef
//  bgcad 
//  gfac    = 4 ie bcdf
//  gcb     = 7 ie acf
//  cdgabef


//output 4 digits
//cg cg fdcagb cbg

//1,1,?(9,6),7


private static Seven_Segment_Search_Reader obj;
private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput08_data.txt";
private static SevenSegementLogic logic;

public static void main (String[] args){
    obj = new Seven_Segment_Search_Reader(file_location);

    boolean is_running = true;
    int count = 0;
int sum =0;
    while(is_running){

        try{
            logic = new SevenSegementLogic();
            String[] pattern_output = obj.patternAndOutput();
            String[] pattern = pattern_output[0].split(" ");
            String[] output = pattern_output[1].split(" ");
            System.out.println(Arrays.toString(pattern));
            System.out.println(Arrays.toString(output));
            count += logic.countUniques(output);
            logic.findUniques(pattern);
            logic.findSegments(pattern);
            logic.unscramble();
            String decodeOutput = logic.decodeOutput(output);
            System.out.println(decodeOutput);
//is_running = !is_running;
if(!decodeOutput.isEmpty()){
            sum+= Integer.parseInt(decodeOutput);
}

        }catch(NoSuchElementException e){is_running = !is_running;}

    }
       logic.printChars();
       System.out.println("SUM: " + sum);
    System.out.println("A: " + logic.getSegments().get("A"));
    System.out.println("G: " + logic.getSegments().get("G"));
    System.out.println("E: " + logic.getSegments().get("E"));
    System.out.println("D: " + logic.getSegments().get("D"));
    System.out.println("B: " + logic.getSegments().get("B"));
    System.out.println("C: " + logic.getSegments().get("C"));
    System.out.println("F: " + logic.getSegments().get("F"));
    System.out.println("IS: " + count);



//ArrayList<Character> 

}
    
}
