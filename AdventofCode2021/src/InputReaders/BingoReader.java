/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InputReaders;

import java.util.NoSuchElementException;


/**
 *
 * @author Daniel
 */
public class BingoReader extends AdventInputReader {

private final int BINGO_BOARD_DIMENTIONS = 5;

    public BingoReader(String file_path){
        super(file_path);
    }

public String[] bingoNumbers(){

    String all_num = obj_Reader.nextLine();
    String[] individual_numbers = all_num.split(",");
    return individual_numbers;
}
/**Assumes format input starts with a blank line*/
    public String[] readBingos() throws NoSuchElementException{

        String[] bingo_board_rows = new String[BINGO_BOARD_DIMENTIONS];
        obj_Reader.nextLine();
        for(int i =0; i< bingo_board_rows.length;i++){
            bingo_board_rows[i] = obj_Reader.nextLine();
        }
        return bingo_board_rows;
    }
}
