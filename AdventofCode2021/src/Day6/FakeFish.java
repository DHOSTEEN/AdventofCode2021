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
public class FakeFish {

    private static ArrayList<Integer> fish;
    private static ArrayList<Integer> day_tracker;
    private static LanternFishReader obj;
    private static final int DAYS = 256;
    private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput06_data.txt";

public static void main(String[] args){

    obj = new LanternFishReader(file_location);
    fish = obj.fish_inputList();
    System.out.println("FISH: "+ fish.toString());
    day_tracker = new ArrayList<>();
    initDay();

long sum = fish.size();
    System.out.println("days: " + day_tracker.toString());
    for(int i =0;i<day_tracker.size();i++){
        
        sum += calcTEST(fish.get(i), DAYS);
    }
    System.out.println("SUM: " + sum);
    //System.out.println("DAY 1 TEST: " + dayCalc(2));
    //System.out.println("TEST: " + dayCalc(3));
    //System.out.println("TEST: " + dayCalc(4));
   // System.out.println("TEST: " + dayCalc(4));
    //System.out.println("TEST: " + dayCalc(5));
}

    private static void initDay(){
        for(int i =0; i<fish.size();i++){day_tracker.add(0);}
    }   

   /*private static int dayCalc(int day){
        System.out.println("DAY:" + day);
        if(day==DAYS){return 1;}
        if(day>DAYS){return 0;}


        return 1+ dayCalc(day + 7) + dayCalc(day+9);
    } */
    
   private static long dayCalc(int day){   
        System.out.println("DAY:" + day);
        int x = daySIX(day +7);
        int y = dayEIGHT(day +9);
        return x + y;
    }
    private static int daySIX(int day){
        if(day>DAYS){return 0;}
       // if(day == DAYS){return 1;}
        return 1;// dayCalc(day);
    }
    private static int dayEIGHT(int day){
        if(day>DAYS){return 0;}
      // if(day == DAYS){return 1;}
        return 1 ;//+ dayCalc(day);
    }
    
    private static long calcTEST(int day, int MAX){
    
       // System.out.println("DAYIS: " + day);
        if(MAX <= 0){return 0;}
        if(day == 0){           
            return 1 + calcTEST(0, MAX -9) + calcTEST(0, MAX-7);
        }
        return calcTEST(day-1, MAX -1);
    }
   
}//5934
//5509621059
//26984457539
//26984457539