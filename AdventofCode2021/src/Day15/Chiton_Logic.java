/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day15;

import CustomCode.CustomCode;
import com.sun.org.apache.bcel.internal.classfile.Code;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Daniel
 */
public class Chiton_Logic extends Thread{
    private final int[][] danger_levels;
    private final boolean[][] visited;
    private final int col_destination;
    private final int row_destination;
    private CustomCode custome_code;
private ArrayList<Long> costs;
private Long best_cost;



    /**
     *Assumes symmetrical 2D array, initializes a boolean 2D array of same dimensions of all false
     * @param danger_levels
     */
    public Chiton_Logic(int[][] danger_levels){
        this.danger_levels = danger_levels;
        visited = new boolean[danger_levels.length][danger_levels.length];
        col_destination = danger_levels.length-1;
        row_destination = danger_levels.length-1;
        custome_code = new CustomCode();
        costs = new ArrayList<>();
        best_cost = Long.MAX_VALUE;
    }

    public void findPath(){
        naivePath();
        recursivePath(0L - danger_levels[0][0], 0, 0, visited);
        System.out.println("Best: " + best_cost);
    }
    private void naivePath(){
        long cost = 0L;
        for(int i =1; i<danger_levels.length; i++){
            cost += danger_levels[0][i];
        }
        for(int i =0; i<danger_levels.length; i++){
            cost += danger_levels[i][danger_levels.length-1];
        }
        best_cost = cost;
    }
public void recursivePath(long cost_so_far, int col, int row, boolean[][] map){
    
    //System.out.println("COL: " + col + " ROW: " + row);

    /*if(!costs.isEmpty()){
        costs.sort(null);
        if(cost_so_far>costs.get(0)){return;}}*/
    if(cost_so_far>best_cost){
        return;}
    if(map[col][row]){
        return;//fail
    }
    if(col == col_destination && row == row_destination){
        if(cost_so_far + danger_levels[col][row]<best_cost){
            best_cost = cost_so_far + danger_levels[col][row];
        }
        //System.out.println(path);
        return;
    }

    map[col][row] = true;
    long updated_cost = cost_so_far + danger_levels[col][row];
   // path += "POS: " + col + "-" + row + " || " + danger_levels[col][row];
    if(custome_code.way_Up(col)){
        recursivePath(updated_cost, col-1, row, copy2D(map));
    }
    if(custome_code.way_Down(col, danger_levels.length)){
        recursivePath(updated_cost, col +1, row, copy2D(map));
    }
   if(custome_code.way_Left(row)){
        recursivePath(updated_cost, col, row-1, copy2D(map));}
    if(custome_code.way_Right(row, danger_levels.length)){
        recursivePath(updated_cost, col, row+1, copy2D(map));
    }
    //return Long.MAX_VALUE;
    }
public void findThreadPath(){
        naivePath();
        recursivePath(0L - danger_levels[0][0], 0, 0, visited);
        System.out.println("Best: " + best_cost);
}

@Override
public void run(){
   //recursiveLoop();
}
public boolean[][] copy2D(boolean[][] map){

    boolean[][] new_map = new boolean[map.length][map.length];
    for(int i =0; i<map.length;i++){
        //new_map[i] = Arrays.copyOf(map[i], map.length);
        for(int j=0; j<map.length; j++){
            new_map[i][j] = map[i][j];
        }
    }
    return new_map;
}
//goUp, goDown, goLeft, goRight
}
