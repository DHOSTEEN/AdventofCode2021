/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day15;

import java.util.Arrays;

/**
 *
 * @author Daniel
 */
public class ArrayGrowth {

private int[][] orginal;

private int[][] big_boy;

public ArrayGrowth(int[][] orginal){
    this.orginal = orginal;
    big_boy = new int[orginal.length*5][orginal.length*5];
}
public int[][] grow(int[][] arr){
    int[][] ret = new int[orginal.length][orginal.length];
   for(int col =0; col<arr.length; col++){
        for(int row =0; row<arr.length; row++){
            ret[col][row] = arr[col][row] +1;}}
   return ret;
}
    public void append(int starting_col, int starting_row,int[][] graph){
int count = 0;
        System.out.println("STARTING COL :" + starting_col + " Starting ROW: " + starting_row);
        for(int col =0; col<graph.length; col++){
            for(int row =0; row<graph.length; row++){
                big_boy[starting_col][starting_row] = graph[col][row];
                System.out.println("col " + starting_col +" vs " + col);
                System.out.println("row: " + starting_row+ " vs " + row);
                starting_row++;
            }
            starting_row =0;
            starting_col++;
            
        }
        System.out.println("count: " + count);
    }

    public void makeBig(int[][] arr){
int row_limiter;
int col_limiter;
        System.out.println("BIG" + big_boy.length);
        System.out.println("ORGINAL: " + orginal.length);
        int[][] mine = arr;
    for(int row =0; row<5; row++){
        if(row == 0){row_limiter = 0;}else{row_limiter = row*orginal.length;}
        append(0, row_limiter, mine);
       mine =  grow(arr);
    }

    }
public void printBIGARR(){
     for(int col =0; col<big_boy.length; col++){
        for(int row =0; row<big_boy.length; row++){
            System.out.print(big_boy[col][row]);
        }
         System.out.println("");
    }
}
}
//1163751742
//1163751742

//2274862853
//2274862853

//3385973964
//3385173164

//4496184175
//4416284275

//5527315386
//5517295286

