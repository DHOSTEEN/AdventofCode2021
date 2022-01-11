/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *
 * @author Daniel
 */
public class SnailFishMain {
    
    public static void main(String[] args){ 

        SnailFishNumber outer = new SnailFishPair(new SnailFishElemental(1), new SnailFishElemental(2),4);
        System.out.println(outer.printNumber());//[1,2]
        outer = new SnailFishPair(outer, new SnailFishElemental(3),4);
        System.out.println(outer.printNumber());//[[1,2],3]
        outer = new SnailFishPair(new SnailFishElemental(9), new SnailFishPair(new SnailFishElemental(8), new SnailFishElemental(7),4),4);
        System.out.println(outer.printNumber());//[9,[8,7]]

String input = "[[3,[2,[1,[7,3]]]],[6,[5,[4,[3,2]]]]]";

    System.out.println(outer.printNumber());
   
        outer = SnailFishNumber.betterBuild(input, 0, null);
        outer.setParent(null);
        System.out.println("IS: " + outer.printNumber());
        SnailFishNumber bkup = outer;
        has_boom = false;
        run(outer);
        System.out.println(bkup.printNumber());

    }
static boolean has_boom;
private static void run(SnailFishNumber outer){

    if(outer.is_Four_deep && !has_boom){
        System.out.println("OI");outer.explode();
        has_boom = true;
    }
    if(outer.getLeft() !=null){
        run(outer.getLeft());
    }
    if(outer.getRight() !=null){
        run(outer.getRight());
    }
    

}
        
}

/*[1,2]
[[1,2],3]
[9,[8,7]]

[[[1,3],[5,3]],[[1,3],[8,7]]]

[[[4,9],[6,9]],[[8,2],[7,3]]]*/