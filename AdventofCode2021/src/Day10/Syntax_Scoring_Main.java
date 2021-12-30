/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day10;

import InputReaders.SyntaxReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Daniel
 */
public class Syntax_Scoring_Main {

private static SyntaxReader obj;
private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput10_testdata.txt";
private static String testy = "{([(<{}[<>[]}>{[]{[(<()>";
private static String testy2 ="([<(((((())";
public static void main(String[] args){

    obj = new SyntaxReader(file_location);
    SyntaxLogic logic = new SyntaxLogic();
    SyntaxAutoFill auto_fill = new SyntaxAutoFill();
    String[] test = testy2.split("");

    System.out.println(Arrays.toString(test));
    System.out.println(logic.recursive(test));
    //System.out.println(Arrays.toString(obj.getLine()));
    /*ArrayList<String[]> all_lines = obj.getAllLines();
    int count = 0;
    for(String[] str_ar : all_lines){

        String result = logic.recursive(str_ar);
        switch(result){
            case ")":
                count += 3;
                break;
            case "]":
                count += 57;
                break;
            case "}":
                count += 1197;
                break;
            case ">":
                count += 25137;
                break;
            case "incomplete line":
                System.out.println(Arrays.toString(str_ar) +  " add: " + auto_fill.findPair(str_ar).toString());

        }      
        //System.out.println(result);
        //System.out.println(Arrays.toString(str_ar));

    }
    System.out.println("COUNT: " + count);*/
}
    
}
