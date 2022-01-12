/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day9;

import java.util.Arrays;

/**
 *
 * @author Daniel
 */
public class SmokeLogic {
    private final int[][] height_map;
    private boolean[][] redundancy;

    public SmokeLogic(int[][] height_map){
        this.height_map = height_map;
        redundancy = new boolean[height_map.length][height_map[0].length]; // all false;
    }

    public int sumRiskLevels(){
        int sum_risk =0;
        for(int i =0; i<height_map.length;i++){
            sum_risk += testLine(height_map[i], i);
        }
        return sum_risk;
    }
    private int testLine(int[] line, int col){
        int sum_risk =0;
        for(int i =0; i< line.length; i++){
            if(is_Lowest(i, col)){
                sum_risk += line[i] +1;
               // System.out.println("LOW: " + line[i]);
               // System.out.println("COL: " + col + "ROW: " + i);
            }
        }
        return sum_risk;
    }

    private boolean is_Lowest(int row, int col){
        return is_Lower_Left(row, col) && is_Lower_Right(row, col) && is_Lower_Up(row, col) && is_Lower_Down(row, col);
    }
    private boolean is_Lower_Left(int row, int col){
        if((row -1) < 0){return true;}
        //System.out.println("Left: " + height_map[col][row-1]);
        return height_map[col][row -1] > height_map[col][row];
    }
    private boolean is_Lower_Right(int row, int col){
        if((row + 1) >= height_map[col].length){return true;}
  //System.out.println("Right: " + height_map[col][row+1]);
        return height_map[col][row +1 ]> height_map[col][row];
    }
    private boolean is_Lower_Up(int row, int col){
        if((col -1) <0){return true;}
       // System.out.println("Up: " + height_map[col-1][row]);
        return height_map[col -1][row] > height_map[col][row];
    }
    private boolean is_Lower_Down(int row, int col){
        if((col + 1) >= height_map.length){return true;}
  //System.out.println("Down: " + height_map[col+1][row]);
        return height_map[col +1][row]> height_map[col][row];
    }
}
   
