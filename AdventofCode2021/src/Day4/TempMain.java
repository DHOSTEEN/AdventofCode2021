/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day4;

import InputReaders.BingoReader;

/**
 *
 * @author Daniel
 */
public class TempMain {

    private static BingoReader obj;

    private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput04_testdata.txt";

public static void main(String[] args){

    obj = new BingoReader(file_location);
    String[] testy = obj.bingoNumbers();
    String test = "15";
    for(int i=0; i<testy.length;i++){
        if(testy[i].equals(test)){System.out.println("HERE");}
        System.out.println(testy[i]);
    }
}
}
