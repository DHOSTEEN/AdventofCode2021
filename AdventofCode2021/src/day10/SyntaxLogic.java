/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day10;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 *
 * @author Daniel
 */
public class SyntaxLogic {
    
    private String failure;
    private final String UNFINISHED = "incomplete line";
    private String[] line;
    private boolean is_done;

private int count_close;
private int count_open;

protected final HashMap<String, String> parenthesis_pair;

    public SyntaxLogic(){

        parenthesis_pair = new HashMap<>();

        parenthesis_pair.put("(", ")");
        parenthesis_pair.put("[", "]");
        parenthesis_pair.put("{", "}");
        parenthesis_pair.put("<", ">");
    }

    public String recursive(String[] line){
        failure = UNFINISHED;
        is_done = false;
        this.line = line;
        count_open = 0;
        count_close =0;
        if(is_openParenthesis(line[0])){
            count_open++;
            recursiveLogic(parenthesis_pair.get(line[0]),0, 1);
           
        }
        else{return "NOT VALID";}
        //System.out.println("OPEN: " + count_open + " CLOSE" + count_close);
        return failure;
    }
// if open, count++ opne, count-- close, if open == close, must be same parenthasis
    private void recursiveLogic(String target, int depth, int pos){

        //System.out.println("POS: " + pos);
        //System.out.println("DEPTH: " + depth);
        if(pos>=line.length){return;}
//if(target.equals(line[pos]) && depth == 0 && !is_done)
        if(target.equals(line[pos]) && depth == 0){
            //discard () pair
            //System.out.println("LINE pos: " + pos + "depth: " + depth + " is: " + line[pos]);
            //failure = CORRECT;
            count_close++;
            //return;
        }
        else if(is_openParenthesis(line[pos])){
           // System.out.println("In branch");
            count_open++;
            recursiveLogic(target, depth+1, pos+1);
            recursiveLogic(parenthesis_pair.get(line[pos]), 0, pos+1);
        }
        else if(depth ==0){
        //failure
            failure =  line[pos];
           // System.out.println("POS: " + pos + " DEPTH: " + depth + " actual: " + line[pos]);
            is_done = !is_done;
            //return;
        }
        else{
            recursiveLogic(target, depth-1, pos+1);
        }
       
    }
    protected boolean is_openParenthesis(String str){     
       // System.out.println("str: " + str  +  " Bool" + parenthesis_pair.containsKey(str));   
        return parenthesis_pair.containsKey(str);

    }
}
