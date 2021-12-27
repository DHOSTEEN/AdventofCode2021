/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day4;

import InputReaders.BingoReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class SquidWinsBingoMain {

    private static BingoReader obj;
    private static Scanner scan;
    private static ArrayList<UnwinningBoard> all_bingos;
    private static BoardLogic logic;
    private static String[] raw_board;
    private static WrapperBoardNumber biggest_loser;

    private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput04_data.txt";

    public static void main(String[] args){

        obj = new BingoReader(file_location);
        scan = obj.getFile_obj();
        all_bingos = new ArrayList<>();
        logic = new BoardLogic();

        boolean is_running = true;
        String[] bingo_numbers = obj.bingoNumbers();
        System.out.println("Bingo Numbers: " + Arrays.toString(bingo_numbers));

        while(is_running){
            UnwinningBoard board = new UnwinningBoard();
            try{
                raw_board = obj.readBingos();
                board.createBoard(raw_board);
                all_bingos.add(board);
            }catch(NoSuchElementException e){is_running = !is_running;}
               
        }
        //setup complete
        boolean house = false;
        int i =0;
        while(i<bingo_numbers.length){
            house = cycleBoards(bingo_numbers[i]);
            i++;
        }
       // print_allBoards();
        System.out.println(biggest_loser.getWinning_number()*logic.sumUnmarkedNumbers(biggest_loser.getWinning_board()));
        System.out.println("biggest looser: ");
biggest_loser.getWinning_board().printStandardBoard();
    }

 private static boolean cycleBoards(String val){
        boolean found_bingo = false;
        int i =0;
        while(i<all_bingos.size()){
            if(!all_bingos.get(i).isHas_won()){
                WrapperBingoNumberCoodinates test = logic.markNumber(all_bingos.get(i), val);
                 if(test.is_true()){
                    // System.out.println("IS TRUE");
                     found_bingo = logic.isWin(test.getMatrix_val_row(), test.getMatrix_val_col(), all_bingos.get(i));
                     all_bingos.get(i).setHas_won(found_bingo);
                     if(found_bingo){
                         //all_bingos.get(i).printStandardBoard();
                         biggest_loser = new WrapperBoardNumber(Integer.parseInt(val), all_bingos.get(i));

                     }
                 }
            }
        i++;
        }
        //System.out.println("FREEEEE");
        return found_bingo;
    }
    private static void print_allBoards(){
        for(UnwinningBoard b : all_bingos){
            b.printStandardBoard();
        }
    }
}
