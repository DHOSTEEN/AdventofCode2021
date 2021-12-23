/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InputReaders;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class BingoReader extends AdventInputReader {

    public BingoReader(String file_path){
        super(file_path);
    }

public String[] bingoNumbers(){

    String all_num = obj_Reader.nextLine();
    String[] individual_numbers = all_num.split(",");
    return individual_numbers;
}
    
}
