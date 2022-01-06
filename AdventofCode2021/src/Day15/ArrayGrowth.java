/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day15;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Daniel
 */
public class ArrayGrowth {

private int[][] orginal;

private int[][] big_boy;
private ArrayList<int[][]> row_catcher;

public ArrayGrowth(int[][] orginal){
    this.orginal = orginal;
    big_boy = new int[orginal.length*5][orginal.length*5];
    row_catcher = new ArrayList<>();
}
public int[][] grow(int[][] arr){
    int[][] ret = new int[orginal.length][orginal.length];
   for(int col =0; col<arr.length; col++){
        for(int row =0; row<arr.length; row++){
            ret[col][row] = arr[col][row] +1;
            if(ret[col][row] > 9){
                ret[col][row] = 1;
            }
        }
   }
   return ret;
}
    public void append(int starting_col, int starting_row,int[][] graph){
        
        int count = 0;
        int big_row = starting_row;
        for(int col =0; col<graph.length; col++){
            for(int row =0; row<graph.length; row++){
                big_boy[starting_col][big_row] = graph[col][row];
 
                big_row++;
            }
            big_row = starting_row;
            starting_col++;
            
        }
    }

    public void makeBig(int[][] arr){
    int row_limiter;
    int col_limiter;
        int[][] transformer = arr;
        for(int col =0; col<5; col++){
            col_limiter = col*orginal.length;
            if(col>0){transformer = row_catcher.get(col);}
            for(int row =0; row<5; row++){
                row_catcher.add(transformer);
                row_limiter = row*orginal.length;
                append(col_limiter, row_limiter, transformer);
                transformer =  grow(transformer);
            }
        }
    }
    public int[][] getBig(){return big_boy;}
    public void printBIGARR(){
         for(int col =0; col<big_boy.length; col++){
             System.out.println(Arrays.toString(big_boy[col]));
        }
    }
}

//11637517422274862853338597396444961841755517295286
//11637517422274862853338597396444961841755517295286

//67554889357866599146897761125791887223681299833479
//67554889357866599146897761125791887223681299833479