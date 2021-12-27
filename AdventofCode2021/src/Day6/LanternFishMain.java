/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day6;

import InputReaders.LanternFishReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class LanternFishMain {

private static ArrayList<Integer> fish;
private static LanternFishReader obj;
private static Scanner scan;
private static final int DAYS = 80;

private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput06_testdata.txt";
public static void main(String[] args){

    obj = new LanternFishReader(file_location);
    fish = obj.fish_inputList();
    System.out.println(fish.toString());

    for(int i =0; i<DAYS;i++){
        breeder();
        //System.out.println(fish.toString());
    }
    System.out.println("fish num is: " + fish.size());

    int max = 2147483647;//is WHY
}
    private static void breeder(){

        for(int i =0; i<fish.size(); i++){
            if(fish.get(i)==0){
                fish.set(i, 6);
                fish.add(9);
            }
            else{
                fish.set(i, fish.get(i)-1);
            }
        }
    }    


}
