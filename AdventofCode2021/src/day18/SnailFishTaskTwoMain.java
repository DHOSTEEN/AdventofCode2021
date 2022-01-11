/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day18;

import InputReaders.AdventInputReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class SnailFishTaskTwoMain {
    
private static AdventInputReader obj;
private static Scanner scan;
private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput18_data.txt";

static boolean has_boom = false;
static boolean has_split = false;

    public static void main(String[] args){
        obj = new AdventInputReader(file_location);
        ArrayList<String> raw_lines = new ArrayList<>();
        scan = obj.getFile_obj();

        while(scan.hasNext()){raw_lines.add(scan.nextLine());}
        System.out.println(raw_lines.toString());
        long greatest = Long.MIN_VALUE;
        for(int col =0; col<raw_lines.size(); col++){
            for(int row =0; row<raw_lines.size(); row++){
                if(!raw_lines.get(col).equals(raw_lines.get(row))){
                    long calc =  taskOne(raw_lines.get(col), raw_lines.get(row));
                    if(calc>greatest){greatest = calc;}
                }
            }
        }
        System.out.println("GREATEST: " + greatest);
    }
    public static long taskOne(String first, String second){

        boolean many_booms = false;
        boolean many_splits = false;
        String input = "";
        SnailFishNumber snail_number= SnailFishNumber.betterBuild(first, 0, null);
        ArrayList<SnailFishNumber> ordered_list = new ArrayList<>();

       
        //depthChecker(outer);
        

        for(int i =0; i<2; i++){
            if(i!=0){
                input = "[" + snail_number.printNumber() + "," + second + "]";
                snail_number = SnailFishNumber.betterBuild(input, 0, null);
            }
            snail_number.setParent(null);          
            snail_number.makeList(ordered_list);

            while(!has_boom || !has_split){
                //System.out.println(outer.printNumber());
                runExplode(snail_number,ordered_list);
                if(many_booms == has_boom){
                    runSplit(snail_number,ordered_list);
                    ordered_list.clear();
                    snail_number.makeList(ordered_list);
                    if(many_splits == has_split){
                        break;
                    }
                    else{has_split = false;}
                }
                else{has_boom = false;}
            }
        }
        return snail_number.calcMag();

    }

private static void runExplode(SnailFishNumber outer, ArrayList<SnailFishNumber> ordered_list){
 //System.out.println("BOOMS: " + outer.printNumber());
    if(outer instanceof SnailFishPair && outer.is_Four_deep && !has_boom){
        //System.out.println("OI");
        //outer.explode();
        ((SnailFishPair)outer).explodeWithList(ordered_list);
        has_boom = true;
    }
    if(outer.getLeft() !=null){
        runExplode(outer.getLeft(),ordered_list);
    }
    if(outer.getRight() !=null){
        runExplode(outer.getRight(),ordered_list);
    }  
}
  
    private static void runSplit(SnailFishNumber outer, ArrayList<SnailFishNumber> ordered_list){
        if(outer instanceof SnailFishElemental && outer.getValue() >= 10 && !has_split){
            ((SnailFishElemental)outer).splitWithList(ordered_list);
            //outer.split();
            has_split=true;}
        if(outer.left != null){
            runSplit(outer.left,ordered_list);}
        if(outer.right != null){
            runSplit(outer.right,ordered_list);}
    }    
}
