/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day11;

import InputReaders.AdventInputReader;
import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author Daniel
 */
public class DumboOctopusMain {

//count flashes
//AFTER step increase up to 9
//if 9, set ZERO and FLASH

    private static AdventInputReader obj;
    private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput11_data.txt";
    private static String file_target = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput11_target.txt";

private static ArrayList<String> failures = new ArrayList<>();

    public static void main(String[] args){

        obj = new AdventInputReader(file_target);
        int[][] target = obj.get2DintArray();
        obj = new AdventInputReader(file_location);
        int[][] octo = obj.get2DintArray();

        DumbOctopusLogic logic = new DumbOctopusLogic(octo);
        DumboOctopus[][] arr = logic.getOcto();
        printOct(arr);

        System.out.println(logic.getFlash_counter());
    boolean syncronized = false;
    int i =0;
    while(!syncronized){
        logic.singleStep();
        syncronized = logic.isSync();
        logic.resetAll();
     
        i++;
    }
        System.out.println("NEW:");
        printOct(arr);
        compare(target, arr);
        System.out.println(logic.getFlash_counter());
        System.out.println("Sync is " + i + "and :" + syncronized);
       /* System.out.println(failures.toString());

    //[COL: 4 ROW: 9, COL: 6 ROW: 3]
        DumboOctopus first_fail = arr[4][9]; 
        ArrayList<DumboOctopus> first_adjacent = first_fail.getAdjacent();
        DumboOctopus second_fail = arr[6][3];
        ArrayList<DumboOctopus> second_adjacent = second_fail.getAdjacent();
        System.out.println("First Size: " + first_adjacent.size() + " Second Size: " + second_adjacent.size());

        DumboOctopus first_above = arr[3][9];
        System.out.println("Is above: " + first_adjacent.contains(first_above));
        System.out.println("Has: " + first_above.getAdjacent().contains(first_fail));

        DumboOctopus first_below = arr[5][9];
        System.out.println("is below: " + first_adjacent.contains(first_below));
        System.out.println("Has: " + first_below.getAdjacent().contains(first_fail));

        DumboOctopus first_left = arr[4][8];
        System.out.println("is left " +first_adjacent.contains(first_left));
        System.out.println("Has: " + first_left.getAdjacent().contains(first_fail));

        DumboOctopus first_upLeft = arr[3][8];
        System.out.println("is upLeft: " + first_adjacent.contains(first_upLeft));
        System.out.println("Has: " + first_upLeft.getAdjacent().contains(first_fail));

        DumboOctopus first_downLeft = arr[5][8];
        System.out.println(first_adjacent.contains(first_downLeft));
        System.out.println("Has: " + first_downLeft.getAdjacent().contains(first_fail));
        System.out.println("FIRST: " + first_fail.isHas_flashed() + " " + first_fail.getEnergy_level());*/

    }//end of main
    


private static void printOct(DumboOctopus[][] arr){

    for(int i =0; i<arr.length; i++){
        for(int j =0; j<arr[i].length; j++){
            System.out.print(arr[i][j].getEnergy_level());
        }
        System.out.println("");
    }
    }
    private static void compare(int[][] arr, DumboOctopus[][] arr2){
        for(int i =0; i<arr.length; i++){
               for(int j =0; j<arr[i].length; j++){
                   if(!(arr[i][j] == arr2[i][j].getEnergy_level())){
                        failures.add("COL: " + i + " ROW: " + j);
                    }
               }
           }
    }
  public static boolean isSyncTEST(DumboOctopus[][] arr){
        boolean um = true;
        for(int col = 0; col<arr.length; col++){
            for(int row = 0; row<arr[col].length; row++){
               // System.out.println("HE");
                if(arr[col][row].isHas_flashed());{
                   // System.out.println("IN HERE" + arr[col][row].isHas_flashed());
                    //um = false;
                }
            }
        } 
        return um;  
    }
}

