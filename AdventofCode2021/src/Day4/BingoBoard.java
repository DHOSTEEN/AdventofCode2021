/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day4;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class BingoBoard {

    public ArrayList<ArrayList<PairBoolString>> getBoard_rows() {
        return board_rows;
    }

    public ArrayList<ArrayList<PairBoolString>> getBoard_cols() {
        return board_cols;
    }

private ArrayList<ArrayList<PairBoolString>> board_rows;
private ArrayList<ArrayList<PairBoolString>> board_cols;

//private ArrayList<PairBoolInt> row;
//private ArrayList<PairBoolInt> col;

//private int number;


    public BingoBoard(){

        board_rows = new ArrayList<>();
        board_cols = new ArrayList<>();
    }
    
    public void createBoard(String[] raw_rows){

        for(int i=0; i<raw_rows.length; i++){

            createRows(raw_rows[i]);
        }
        createCols();
    }
    private void createRows(String input_row){

        ArrayList<PairBoolString> row = new ArrayList<>();
        String[] row_parts = input_row.split(" ");

        for(int i= 0; i<row_parts.length; i++){
            if(!row_parts[i].equals("")){
                row.add(new PairBoolString(row_parts[i]));
            }
        }
        board_rows.add(row);
    }
    
    private void createCols(){
        
        int pos =0; 
        for(int i =0; i<board_rows.size(); i++){
        
            createColsHelper(pos);
            pos++;
        }
    
    }
    private void createColsHelper(int pos){
        
        ArrayList<PairBoolString> col = new ArrayList<>();
        
        for(int i =0; i<board_rows.size(); i++){
        
            col.add(board_rows.get(i).get(pos));
           
        }
        board_cols.add(col);
    }
   
    /**debugging code*/
    
    public void printStandardBoard(){
        System.out.println("ROWS:");
        printBoard(board_rows);
    }
    public void printColomBoard(){
        System.out.println("COLS:");
        printBoard(board_cols);}
    
    private void printBoard(ArrayList<ArrayList<PairBoolString>> board){
        for(int i =0; i<board.size();i++){
            printRows(board.get(i));
            System.out.println();
        }
    }
    private void printRows(ArrayList<PairBoolString> list){
        for(int i=0; i<list.size();i++){
            System.out.print(" :" + list.get(i).getNum() + "- " + list.get(i).isMarked());}
    }
    
}

//public boolean isWin(){return }
