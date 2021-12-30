/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day10;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Daniel
 */
public class SyntaxAutoFill extends SyntaxLogic{

private String[] line;
private ArrayList<String> additions;

public SyntaxAutoFill(){super();}

    public ArrayList<String> getAdditions(String[] line){

        this.line = line;
        additions = new ArrayList<>();

        for(int i =0; i<line.length; i++){

            if(parenthesis_pair.get(line[i]) != null){
                recursiveAutoFill(parenthesis_pair.get(line[i]), 0, i+1);
            }
        }
        Collections.reverse(additions);
        return additions;
    }

    private void recursiveAutoFill(String target, int depth, int pos){

        //System.out.println("TARGET: " + target);
        //System.out.println("POS: " + pos);
        //System.out.println("DEPTH: " + depth);
        if(pos>=line.length){
            additions.add(target);
            return;
        }
//if(target.equals(line[pos]) && depth == 0 && !is_done)
        if(target.equals(line[pos]) && depth == 0){
            //System.out.println("IN HERE");
            //discard () pair
        }
        else if(is_openParenthesis(line[pos])){
           // System.out.println("In branch");
            //count_open++;
            recursiveAutoFill(target, depth+1, pos+1);
        }
        else if(depth ==0){
            System.out.println("I SHOULD NEVER PROC");
   
        }
        else{
            recursiveAutoFill(target, depth-1, pos+1);
        }
    }
}
   
