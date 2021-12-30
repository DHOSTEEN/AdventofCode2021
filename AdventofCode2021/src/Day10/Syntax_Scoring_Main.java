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
private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput10_data.txt";
private static String testy = "{([(<{}[<>[]}>{[]{[(<()>";
private static String testy2 ="([<(((((())";

public static void main(String[] args){

    obj = new SyntaxReader(file_location);
    SyntaxLogic logic = new SyntaxLogic();
    SyntaxAutoFill auto_fill = new SyntaxAutoFill();
    /*String[] test = testy2.split("");

    System.out.println(Arrays.toString(test));
    System.out.println(logic.recursive(test));
    System.out.println("Additions: " + auto_fill.getAdditions(test).toString());
 
    //System.out.println(Arrays.toString(obj.getLine()));*/
    ArrayList<String[]> all_lines = obj.getAllLines();
    ArrayList<String> addons = new ArrayList<>();
    ArrayList<Long> all_products = new ArrayList<>();
    int count = 0;
    long products =0;
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
                addons = auto_fill.getAdditions(str_ar);
                products = calc(addons);
                all_products.add(products);
        }      
        //System.out.println(result);
        //System.out.println(Arrays.toString(str_ar));

    }
    all_products.sort(null);
       // System.out.println(all_products.toString());
    System.out.println("COUNT: " + count);
    System.out.println("SIZE: " + all_products.size());
    System.out.println("MIDDLE: " + all_products.get(all_products.size()/2));
}

    public static long calc(ArrayList<String> str_arr){
        long product = 0;
        for(int i =0; i<str_arr.size(); i++){
        switch(str_arr.get(i)){
            case ")":
                product =  product * 5;
                product += 1;
                break;
            case "]":
              product =  product * 5;
                product += 2;
                break;
            case "}":
              product =  product * 5;
                product += 3;
                break;
            case ">":
              product =  product * 5;
                product += 4;
                break;
        }
        }
        return product;
    }
    
}
