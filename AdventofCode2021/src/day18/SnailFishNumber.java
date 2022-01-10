/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day18;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class SnailFishNumber {


static ArrayList<RawSnailNumber> pairs = new ArrayList<>();
static ArrayList<String> simple_pairs = new ArrayList<>();
    
    protected SnailFishNumber left;
    protected SnailFishNumber right;
    protected boolean is_Four_deep;

    public void setLeft(SnailFishNumber left){this.left = left;}
    public void setRight(SnailFishNumber right){this.right = right;}

    public SnailFishNumber getLeft(){return left;}
    public SnailFishNumber getRight(){return right;}

    protected String printNumber(){
        return "I SHOULD NEVER BE";
    }


public static SnailFishNumber betterBuild(String snail_num, int depth){

    SnailFishNumber snail_number = null;
    snail_num = snail_num.substring(1,snail_num.length()-1);
    System.out.println("AM: " + snail_num);
    String first = bracketCount(snail_num);
    System.out.println("first: " + first);
    String second = snail_num.substring(first.length() +1);
    System.out.println("Second: " + second);

    if(first.length()==1 && second.length()==1){
        snail_number = new SnailFishPair(new SnailFishElemental(Integer.parseInt(first), depth), new SnailFishElemental(Integer.parseInt(second), depth));
    }
    else if(first.length() ==1){
        snail_number = new SnailFishPair(new SnailFishElemental(Integer.parseInt(first), depth), betterBuild(second, depth +1));
    }
    else if(second.length() ==1){
        snail_number = new SnailFishPair(betterBuild(first, depth +1), new SnailFishElemental(Integer.parseInt(second), depth));
    }
    else{
    snail_number = new SnailFishPair(betterBuild(first, depth +1), betterBuild(second, depth +1));
    }
    return snail_number;
}
    private static String bracketCount(String snail_num){
        String first = "";
        int open =0;
        int closed =0;
        for(int i =0; i<snail_num.length(); i++){
            if(closed>open){
                return elementalNumber(snail_num);
            }
            if(open == closed && i !=0){
                return snail_num.substring(0, i);
            }
            if(snail_num.charAt(i)=='['){
                open++;
            }
            else if(snail_num.charAt(i)==']'){
                closed++;
            }
        }
        return first;
    }
    private static String elementalNumber(String snail_num){
        for(int i =0; i<snail_num.length(); i++){
            if(snail_num.charAt(i) == '[' || snail_num.charAt(i)==']' || snail_num.charAt(i)==','){
                return snail_num.substring(0,i);
            }
        }
            return "";
    }
}
