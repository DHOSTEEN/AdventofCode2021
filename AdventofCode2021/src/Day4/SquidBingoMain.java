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
public class SquidBingoMain {

private static Scanner scan;
private static BingoReader obj;
private static ArrayList<BingoBoard> all_bingos;
private static String[] raw_board;
private static WrapperBoardNumber winner;

private static BoardLogic logic;

private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput04_data.txt";


    public static void main (String[] agrs){

        obj = new BingoReader(file_location);
        scan = obj.getFile_obj();

        all_bingos = new ArrayList<>();
        logic = new BoardLogic();
        //obj.testScan(scan);
        //scan.nextLine();//skips input
        String[] bingo_numbers = obj.bingoNumbers();
        System.out.println("Bingo Numbers: " + Arrays.toString(bingo_numbers));
        boolean is_running = true;
        while(is_running){
            BingoBoard board = new BingoBoard();
            try{
                raw_board = obj.readBingos();
                board.createBoard(raw_board);
                all_bingos.add(board);
            }catch(NoSuchElementException e){is_running = !is_running;}
               
        }
        System.out.println("SUCCESS");
        System.out.println(all_bingos.size());
       // print_allBoards();
        boolean house = false;
        int i =0;
        while(i<bingo_numbers.length && !house){
            house = cycleBoards(bingo_numbers[i]);
            i++;
        }
       // print_allBoards();
        System.out.println(winner.getWinning_number()*logic.sumUnmarkedNumbers(winner.getWinning_board()));
        //board.printStandardBoard();
        //board.printColomBoard();

        //testing logic

        //BoardLogic logic = new BoardLogic();
        //WrapperBingoNumberCoodinates pair = logic.markNumber(board, "10");
        //board.printStandardBoard();
        //board.printColomBoard();

        //System.out.println("Pair: \n row:" + pair.getMatrix_val_row() + "\n col: " + pair.getMatrix_val_col());
        //System.out.println(logic.isWin(3, 1, board));



    }    
    private static boolean cycleBoards(String val){
        boolean found_bingo = false;
        int i =0;
        while(i<all_bingos.size() && !found_bingo){
           WrapperBingoNumberCoodinates test = logic.markNumber(all_bingos.get(i), val);
            if(test.is_true()){
                System.out.println("IS TRUE");
                found_bingo = logic.isWin(test.getMatrix_val_row(), test.getMatrix_val_col(), all_bingos.get(i));
                if(found_bingo){
                    all_bingos.get(i).printStandardBoard();
                    winner = new WrapperBoardNumber(Integer.parseInt(val), all_bingos.get(i));

                }
            }
            i++;
        }
        System.out.println("FREEEEE");
        return found_bingo;
    }
    private static void print_allBoards(){
        for(BingoBoard b : all_bingos){
            b.printStandardBoard();
        }
    }
}
