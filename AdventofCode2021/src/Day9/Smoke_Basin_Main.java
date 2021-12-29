/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day9;

import InputReaders.Smoke_Basin_Reader;
import java.util.ArrayList;
import java.util.Arrays;


/**
 *
 * @author Daniel
 */
public class Smoke_Basin_Main {
    
private static Smoke_Basin_Reader obj;
private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput09_data.txt";

static String test_basin1 = "213";
static String test_basin2 = "43210"
 + "421"
 + "2";
static String test_basin3 = "878"
 + "85678"
 + "87678"
 + "8";
static String test_basin4 = "8"
 + "678"
 + "65678";

private static SmokeLogic logic;

    public static void main(String[] args){
        obj = new Smoke_Basin_Reader(file_location);
        int[][] height_map = obj.getHeighttMap();
        System.out.println(height_map.length);
        for(int[] arr : height_map){

           // System.out.println(Arrays.toString(arr));
        }
        logic = new SmokeLogic(height_map);
        System.out.println("RISK: " + logic.sumRiskLevels());

        BasinLogic tree_logic = new BasinLogic(height_map);
        tree_logic.findBasin();
        ArrayList<ArrayList<Integer>> test = tree_logic.getAll_basins();
        int product = 1;
        test.sort(new ArraySizeComparator());
        for(int i =0; i<3; i++){
            product *= test.get(i).size();
        }
      
            System.out.println("product: " + product);
    }
}
