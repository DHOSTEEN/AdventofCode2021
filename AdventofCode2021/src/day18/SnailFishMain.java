/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day18;

import InputReaders.AdventInputReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Daniel
 */
public class SnailFishMain {


private static AdventInputReader obj;
private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput18_data.txt";
    
    public static void main(String[] args){ 

        obj = new AdventInputReader(file_location);
        Scanner scan = obj.getFile_obj();
        SnailFishNumber outer = new SnailFishPair(new SnailFishElemental(1), new SnailFishElemental(2),4);
        System.out.println(outer.printNumber());//[1,2]
        outer = new SnailFishPair(outer, new SnailFishElemental(3),4);
        System.out.println(outer.printNumber());//[[1,2],3]
        outer = new SnailFishPair(new SnailFishElemental(9), new SnailFishPair(new SnailFishElemental(8), new SnailFishElemental(7),4),4);
        System.out.println(outer.printNumber());//[9,[8,7]]

        //String input = "[[[[0,[4,5]],[0,0]],[[[4,5],[2,6]],[9,5]]],[7,[[[3,7],[4,3]],[[6,3],[8,8]]]]]";
        //[[[0,[4,5]],[0,0]],[[[4,5],[2,6]],[9,5]]]
//[7,[[[3,7],[4,3]],[[6,3],[8,8]]]]
/*
        System.out.println(outer.printNumber());
   
        outer = SnailFishNumber.betterBuild(input, 0, null);
        outer.setParent(null);
        System.out.println("IS: " + outer.printNumber());
        SnailFishNumber bkup = outer;
        has_boom = false;
        has_split = false;
/*
        runExplode(outer);
        System.out.println(bkup.printNumber());
        
        runSplit(outer);
        System.out.println(bkup.printNumber());
        has_boom = false;
has_split = false;
        runExplode(outer);
   System.out.println(bkup.printNumber());
        runSplit(outer);
   System.out.println(bkup.printNumber());
*/

    //outer = SnailFishNumber.betterBuild(test, 0, null);
        System.out.println("hi");
        System.out.println(outer.printNumber());
        ArrayList<SnailFishNumber> list = new ArrayList<>();
        //input = scan.nextLine();
       String input ="";
   while(scan.hasNext()){
       input = "[" + outer.printNumber() + "," + scan.nextLine() + "]";
        //depthChecker(outer);
        outer = SnailFishNumber.betterBuild(input, 0, null);
        outer.setParent(null);
        //outer = snail_number;
        outer.makeList(list);
        System.out.println("OTHER---------------------------");
        //depthChecker(snail_number);
        //System.out.println("SnailNumber: " + outer.printNumber());
        //outer = outer.add(SnailFishNumber.betterBuild(scan.nextLine(), 0, null));

        System.out.println("NEW ADDITION: " + outer.printNumber());
        boolean many_booms = false;
        boolean many_splits = false;
        while(!has_boom || !has_split){
            //System.out.println(outer.printNumber());
            runExplode(outer,list);
            if(many_booms == has_boom){
                runSplit(outer,list);
                list.clear();
                outer.makeList(list);
                if(many_splits == has_split){
                    break;
                }
                else{has_split = false;}
            }
            else{has_boom = false;}
        }
       
    }
        System.out.println("input: " + input);

        System.out.println("ME: " + outer.printNumber());
        //outer = outer.add(new SnailFishElemental(69));
        depthChecker(outer);
        System.out.println("Magnatude: " + outer.calcMag());
        
        



    }
static boolean has_boom;
static boolean has_split;

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
private static void depthChecker(SnailFishNumber snail_number){
    //System.out.println(snail_number.printNumber() + " depth: " + snail_number.depth);
    if(snail_number.left != null && snail_number.left instanceof SnailFishPair){
            depthChecker(snail_number.left);}
        if(snail_number.right != null && snail_number.left instanceof SnailFishPair){
            depthChecker(snail_number.right);}
}  
}

/*[1,2]
[[1,2],3]
[9,[8,7]]

[[[1,3],[5,3]],[[1,3],[8,7]]]

[[[4,9],[6,9]],[[8,2],[7,3]]]*/

//[[[[4,0],[5,4]],[[7,7],[6,0]]],[[8,[7,7]],[[7,9],[5,0]]]]
//
//[[[0,[4,5]],[0,0]],[[[4,5],[2,6]],[9,5]]]
//[[[[0,[4,5]],[0,0]],[[[4,5],[2,6]],[9,5]]],[7,[[[3,7],[4,3]],[[6,3],[8,8]]]]]


//[[[[1,1],[2,2]],[3,3]],[4,4]]
//[[[[1,1],[2,2]],[3,3]],[4,4]]

//[[[[0,[2,9]],[[5,5],[5,0]]],[[[6,0],[8,9]],1]],[[[[4,2],2],6],[8,7]]]
//[[[[8,7],[7,7]],[[8,6],[7,7]]],[[[0,7],[6,6]],[8,7]]]