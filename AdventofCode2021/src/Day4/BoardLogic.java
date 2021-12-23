/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day4;

import com.sun.org.apache.xerces.internal.parsers.IntegratedParserConfiguration;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class BoardLogic {

public BoardLogic(){};

private BingoBoard current_board;
private int matrix_val_row;
private int matrix_val_col;

/**
*returns WrapperBingoNumberCoodinates(bool, int, int), containing true if found, and a value to find row/col of nested ArrayList as found in BingBoard class
* false otherwise
*/
public WrapperBingoNumberCoodinates markNumber(BingoBoard board, String val){

    current_board = board;
    int i =0;
    boolean found = false;
    System.out.println("HII: " + val);
    while(i<current_board.getBoard_rows().size() && !found){
        System.out.println("in initial loop");
        found = markRow(current_board.getBoard_rows().get(i), val, i);
        i++;
    }

return new WrapperBingoNumberCoodinates(found, matrix_val_row, matrix_val_col);
}
 /**
    *<p>returns true if number appears in row and has been marked and marks respective colum as found, uses int i to set coloums</p>
    *<p><b>Parameters:</b></p>
    *<p>row - list to search</p>
    *<p>val - number to mark</p>
    *<p>i - row position in 2d matrix</p>
    *<p><b>Retruns:</b><p>
    *true if number has been marked, false otherwise
   */
private boolean markRow(ArrayList<BingoNumber> row, String val, int matrix_row){

    int i =0; 
    boolean found = false;
        while(i<row.size() && !found){
            System.out.println("in row loop");
            if(val.equals(row.get(i).getNum())){
                row.get(i).setMarked();
                System.out.println("ROW FOUND: " + row.get(i).getNum());
                found = true;
                markCol(i, matrix_row);
                matrix_val_row = matrix_row;
                matrix_val_col = i;// for calc win
            }
            i++;
        }

    return found;
}
/**
*marks obj BingoNumber as true, row, col positions are reversed for same values on nested ArrayLists board_rows, board_cols as found in BingBoard class*/
private void markCol(int row, int col){

    current_board.getBoard_cols().get(row).get(col).setMarked();
    System.out.println("COL FOUND: " + current_board.getBoard_cols().get(row).get(col).getNum());
}

/**returns true if and only if all numbers are marked in EITHER row or colum*/
    public boolean isWin(int x, int y, BingoBoard board){
        current_board = board;
        return row_complete(x) || colum_complete(y);
 
    }
  
/**returns true if and only if all numbers are marked*/
    private boolean row_complete(int i){
        for(BingoNumber bingo_number: current_board.getBoard_rows().get(i)){
            if(!bingo_number.isMarked()){return false;}
        }
        return true;
    }
  /**returns true if and only if all numbers are marked*/
    private boolean colum_complete(int i){
    //ArrayList<BingoNumber> list = current_board.getBoard_cols().get(i);
        for(BingoNumber bingo_number: current_board.getBoard_cols().get(i)){
                if(!bingo_number.isMarked()){return false;}

        }
        return true;
    }

    public int sumUnmarkedNumbers(BingoBoard board){
        current_board = board;
        int sum =0;
        for(ArrayList<BingoNumber> row : current_board.getBoard_rows()){
            for(BingoNumber num : row){
                if(!num.isMarked()){
                    sum += Integer.parseInt(num.getNum());
                }
            }
        }
        return sum;
    }
    
}
