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
    private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput15_testdata.txt";

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        obj_Reader = new AdventInputReader(file_location);
        int[][] input = obj_Reader.get2DintArray();
        Arrays.asList(input).forEach(arr -> {System.out.println(Arrays.toString(arr));});

        Chiton_Logic logic = new Chiton_Logic(input);
        AlgorithmAStar a_star = new AlgorithmAStar(input);
        long start = System.nanoTime();
        //a_star.findPath();
       // logic.findPath();
        long end = System.nanoTime();
        System.out.println("TIME: " + (end - start)/1000000 + "ms");
        HashStar star = new HashStar(input);
        star.findPath();
        System.out.println("input" + input.length);
        ArrayGrowth growth = new ArrayGrowth(input);
        growth.makeBig(input);
        growth.printBIGARR();
    }
    
}
