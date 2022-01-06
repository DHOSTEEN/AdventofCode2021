/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day15;

import InputReaders.AdventInputReader;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *
 * @author Daniel
 */
public class Chiton_Main {

    private static AdventInputReader obj_Reader;
    private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput15_data.txt";

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        obj_Reader = new AdventInputReader(file_location);
        int[][] input = obj_Reader.get2DintArray();
        Arrays.asList(input).forEach(arr -> {System.out.println(Arrays.toString(arr));});

        AlgorithmAStar a_star = new AlgorithmAStar(input);// works on testdata but too slow for real data
        long start = System.nanoTime();
       // a_star.findPath();
       // logic.findPath();
  
        HashStar star = new HashStar(input);
        star.findPath();
        long end = System.nanoTime();
        System.out.println("TIME: " + (end - start)/1000000 + "ms");


        System.out.println("BIG PATH");
        start = System.nanoTime();
        ArrayGrowth growth = new ArrayGrowth(input);
        growth.makeBig(input);
        star = new HashStar(growth.getBig());
        star.findPath();
        end = System.nanoTime();
        System.out.println("BIG TIME: " + (end - start)/1000000 + "ms");
        //growth.printBIGARR();
    }
    
}
