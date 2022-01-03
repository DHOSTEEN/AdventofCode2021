/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day13;

import InputReaders.Transparent_Origami_Reader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Daniel
 */
public class Transparent_Origami_Main {

    private static String file_target = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput13_data.txt";
    private static Transparent_Origami_Reader obj_Reader;
private static ArrayList<int[]> inputs;

private static int highest_col=0;
private static int highest_row=0;

    public static void main(String[] args){
        obj_Reader = new Transparent_Origami_Reader(file_target);
        inputs = obj_Reader.getCoordinates();
        inputs.forEach(ar -> {
           // System.out.println(Arrays.toString(ar));
            if(ar[0]>highest_col){
                highest_col = ar[0];
            }
            if(ar[1]>highest_row){
                highest_row = ar[1];
            }
        });
        //obj_Reader.getInstructions().forEach(ar -> {System.out.println(ar.getCoord() + " - " + ar.getVal());});
        ArrayList<TuppleCharacterInteger> instructions = obj_Reader.getInstructions();
        System.out.println(highest_col + " - " + highest_row);
        OrigamiPaper paper = new OrigamiPaper(highest_col +1, highest_row +1);

        inputs.forEach(ar ->{ paper.add(ar[0], ar[1]);});
       // paper.printPaper();
       // System.out.println("PAPERS");
int val;
char fold;
        for(int i =0; i<instructions.size(); i++){
            fold = instructions.get(i).getCoord();
            val = instructions.get(i).getVal();
            if(fold == 'y'){
                    paper.splitPaperOnY(val);
            }
            //System.out.println("NEW");
           else{
                paper.splitPaperOnX(val);
            }
        }
        //paper.printPaper();
      
       // System.out.println("NEWIES");
        paper.printPaper();
 System.out.println(paper.countPoints());
    }

    
}
