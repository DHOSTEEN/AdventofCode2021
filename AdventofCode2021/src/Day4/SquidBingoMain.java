/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day4;

import InputReaders.AdventInputReader;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Daniel
 */
public class SquidBingoMain {

private static Scanner scan;
private static AdventInputReader obj;

private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput04_testdata.txt";


    public static void main (String[] agrs){

        obj = new AdventInputReader(file_location);
        scan = obj.getFile_obj();
        //obj.testScan(scan);
        scan.nextLine();//skips input
        BingoBoard board = new BingoBoard();
        String[] raw_board = string_snippet();
        board.createBoard(raw_board);
        board.printStandardBoard();
        System.out.println("COLUMNS");
        board.printColomBoard();


    }
private static String[] string_snippet(){

    String[] str_ar = new String[5];
    for(int i =0; i< str_ar.length; i++){
        String temp = scan.nextLine();
        if(!temp.equals("")){
            str_ar[i] = temp;
            System.out.println(str_ar[i]);
        }
else{i--;}
    }

    return str_ar;
}

    
}
