/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day6;

import InputReaders.LanternFishReader;
import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class BigFish {

    private static ArrayList<ArrayList<Integer>> fishes;
    private static LanternFishReader obj;
    private static Scanner scan;
    private static final int DAYS = 256;

    private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput06_testdata.txt";

    public static void main(String[] args){

    fishes = new ArrayList<>();
    obj = new LanternFishReader(file_location);
    fishes.add(obj.fish_inputList());
    System.out.println(fishes.get(0).toString());

    for(int i =0; i<DAYS;i++){
        breeder();
        //System.out.println(fish.toString());
    }
    scan = new Scanner(System.in);
    String input_user = "";

    System.out.println("fish num is: " + fishes.size());
    for(int i =0; i<fishes.size();i++){
        System.out.println(fishes.get(i).size());
    }
}
    
    private static void breeder(){
        for(int i =0; i<fishes.size(); i++){
            breeder_helper(fishes.get(i));
        }   
    }

    private static void breeder_helper(ArrayList<Integer> fish){
        for(int i =0; i<fish.size(); i++){
            if(fish.get(i) == 0){
                fish.set(i, 6);
                add_fish(fish);
            }
            else{fish.set(i, fish.get(i)-1);}
        }
    }

    private static void add_fish(ArrayList<Integer> fish){

        if(fish.size()>= Integer.MAX_VALUE/2){

            if(check_last()){

                add_fish(fishes.get(fishes.size()-1));
            }
            else{
                ArrayList<Integer> new_shoal = new ArrayList<>();
                new_shoal.add(9);
                fishes.add(new_shoal);
            }
        }
        else{
            fish.add(9);
        }
    }
    private static boolean check_last(){
        if(fishes.size()<=1){return false;}
        return fishes.get(fishes.size()-1).size()<Integer.MAX_VALUE/2;
    }
}
