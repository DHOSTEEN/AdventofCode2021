/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day7;

import InputReaders.AdventInputReader;
import InputReaders.Treachery_of_Whales_Reader;
import java.util.ArrayList;
import java.util.Arrays;


/**
 *
 * @author Daniel
 */
public class Treachery_of_Whales_Main {

    private static ArrayList<Integer> crab_tanks;
    private static AdventInputReader obj;
    private static CrabTankLogic logic;
    private static FuelBurnCrabTankLogic burner_logic;

    private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput07_data.txt";

    public static void main(String[] args){

        obj = new Treachery_of_Whales_Reader(file_location);
        crab_tanks = obj.integerList();
        System.out.println(crab_tanks.toString());
       /* crab_tanks.sort(null);
        Integer[] arr = new Integer[crab_tanks.size()];
        Integer[] test =  crab_tanks.toArray(arr);
        System.out.println(Arrays.toString(test));*/
        //logic = new CrabTankLogic(crab_tanks);
        //logic.findLeastFuel();
        //System.out.println("Least Fuel: " +logic.getLeast_fuel_cost());
       // System.out.println("Best posistion: " +logic.getPos());
        burner_logic = new FuelBurnCrabTankLogic(crab_tanks);
        burner_logic.findLeastFuel();
        System.out.println("Least Burner Fuel: " +burner_logic.getLeast_fuel_cost());
        System.out.println("Best Burner posistion: " +burner_logic.getPos());
    }
    
}
