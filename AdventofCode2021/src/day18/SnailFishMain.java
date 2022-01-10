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

        SnailFishNumber outer = new SnailFishPair(new SnailFishElemental(1,0), new SnailFishElemental(2,0));
        System.out.println(outer.printNumber());//[1,2]
        outer = new SnailFishPair(outer, new SnailFishElemental(3,0));
        System.out.println(outer.printNumber());//[[1,2],3]
        outer = new SnailFishPair(new SnailFishElemental(9,0), new SnailFishPair(new SnailFishElemental(8,0), new SnailFishElemental(7,0)));
        System.out.println(outer.printNumber());//[9,[8,7]]

String input = "[[[[1,2],[3,4]],[[5,6],[7,8]]],9]";

System.out.println(outer.printNumber());
ArrayList<RawSnailNumber> raw_pairs = SnailFishNumber.pairs;
raw_pairs.sort(new SnailComparator());
        for(RawSnailNumber raw : raw_pairs){
            System.out.println(raw.getRaw_number());}
        System.out.println("coutn: " + SnailFishNumber.pairs.size());
        System.out.println("input length: " + input.length());
        outer = SnailFishNumber.betterBuild(input, 0);
        System.out.println("IS: " + outer.printNumber());

        }
        
}

/*[1,2]
[[1,2],3]
[9,[8,7]]

[[[1,3],[5,3]],[[1,3],[8,7]]]

[[[4,9],[6,9]],[[8,2],[7,3]]]*/