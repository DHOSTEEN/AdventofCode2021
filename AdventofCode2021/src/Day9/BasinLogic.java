/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day9;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class BasinLogic {

    private final int[][] height_map;
    private boolean[][] already_visited;

    public ArrayList<ArrayList<Integer>> getAll_basins() {
        return all_basins;
    }
    private ArrayList<ArrayList<Integer>> all_basins;
private ArrayList<Integer> basin;


    public BasinLogic(int[][] height_map){
        this.height_map = height_map;
        already_visited = new boolean[height_map.length][height_map[0].length];
all_basins = new ArrayList<>();
    }
    //untill see 9 = add list
//need boolean table to prevent duplicates, entries and sub-basins
///HMMMM need to be able to check if zig-zags happen. might not be possible WITHOUT knowing all nines....
    public void findBasinsRecursive(int col, int row, ArrayList<Integer> basin, LastNinePos last_nine){
    
    if(col > height_map.length){return;}//end of map
    if(row>=height_map[0].length){//end of row
        findBasinsRecursive(col +1, 0, basin, last_nine);
    }
    else if(height_map[col][row] == 9){
        if(nine_Connected(row, col, last_nine)){//is same Basin
            basin.add(height_map[row][col]);
            findBasinsRecursive(col, row +1, basin, new LastNinePos(col, row));
        }  
//if NOT, need to carry on until we meet a nine who IS connected
        findBasinsRecursive(col + 1, 0, basin, new LastNinePos(col, row));//go to next row;
        findBasinsRecursive(col, row +1, new ArrayList<>(), new LastNinePos(col, row));//carry on same row, new basin
    }
   // list.add(height_map[col][row]);

    }

private boolean nine_Connected(int row, int col, LastNinePos last_nine){//connected UP

return true;
}
public void findBasin(){

    //basin = new ArrayList<>();
    for(int i =0; i< height_map.length; i++){
        for(int j =0; j<height_map[i].length; j++){
            basin = new ArrayList<>();
            treeSearch(i, j);
            if(!basin.isEmpty()){
                all_basins.add(basin);
            }
        }
    }
}
public void treeSearch(int col, int row){

    if(!way_Up(col, row) && !way_Down(col, row) && !way_Left(col, row) && !way_Right(col, row)){

       // all_basins.add(basin);
        if(!already_visited[col][row] && height_map[col][row] !=9){
                basin.add(height_map[col][row]);
                already_visited[col][row] = true;
        }
       
        return;
    }
    if(height_map[col][row] !=9){
        basin.add(height_map[col][row]);
    }
    already_visited[col][row] = true;
    if(way_Up(col, row)){
        treeSearch(col-1, row);
    }
    if(way_Down(col, row)){
        treeSearch(col +1 , row);
    }
    if(way_Left(col, row)){
        treeSearch(col, row-1);
    }
    if(way_Right(col, row)){
        treeSearch(col, row +1);
    }
    //basin.add(height_map[row][col]);

}

private boolean way_Up(int col, int row){
    if(col -1 < 0){return false;}
    if(already_visited[col -1][row]){return false;}
    if(height_map[col -1][row] == 9){return false;}
    return true;
}
private boolean way_Down(int col, int row){
    if(col + 1 >= height_map.length){return false;}
    if(already_visited[col +1][row]){return false;}
    return height_map[col +1][row] != 9;//ie not an edge
}
private boolean way_Left(int col, int row){
    if(row -1 <0){return false;}
    if(already_visited[col][row-1]){return false;}
    return height_map[col][row-1] != 9;
}
private boolean way_Right(int col, int row){
    if(row +1 >=height_map[0].length){return false;}
    if(already_visited[col][row +1]){return false;}
    return height_map[col][row+1] != 9;
}
public void findNines(){}
}
