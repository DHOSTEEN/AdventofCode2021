/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day14;

import InputReaders.Extended_Polymerization_Reader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Daniel
 */
public class Extended_Polymerization_Main {

    private static Extended_Polymerization_Reader obj_Reader;
    private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput14_data.txt";
private static final int TEN_STEPS = 10;
private static final int FORTY_STEPS = 40;

    public static void main(String[] args){
        obj_Reader = new Extended_Polymerization_Reader(file_location);
        String polymer = obj_Reader.getPolymer();
        System.out.println(polymer);
        ArrayList<String[]> allInserts = obj_Reader.getAllInsertions();
        //allInserts.forEach(arr ->{System.out.println(Arrays.toString(arr));});

        Polymer_Logic logic = new Polymer_Logic(polymer);
        allInserts.forEach(arr -> {logic.addPair(arr[0], arr[1]);});
        System.out.println(logic.getPair_insertion_rules().toString());
        /* System.out.println("THE POLY: " +logic.getPolymer().toString());
       
        
        logic.singleStep();
        System.out.println("NEW POLY: " + logic.getPolymer().toString());*/
        //System.out.println("BATCH PROCESSING");
        //logic.batchProcessing().forEach(ar -> {System.out.println("ADDED: " + ar.toString());});
        System.out.println("LOGIC");
        PolyThread thread = new PolyThread(logic);
        WeirdTree tree = new WeirdTree(logic);
        long start = System.nanoTime();
        
        for(int i =0; i<20; i++){
            //logic.singleStep();
            //thread.threadRun();
tree.buildPoly();
        }
        System.out.println("SIZE OF FINAL POLYMER: " + logic.getPolymer().size());
        //System.out.println("FINAL POLYMER: " + logic.getPolymer().toString());
        System.out.println(logic.getAnswer());
// ...
long finish = System.nanoTime();
        System.out.println("TIME :" + (finish - start)/1000000);
        //133372200
        //63197900
        //51347600
        //31689700
        //146188100
        //77537000
        //101475600
        //61926800
        //8714700
        //8500400
        //82872900
//NBBBCNCCNBBNBNBBCHBHHBCHB
//NBBBCNCCNBBNBNBBCHBHHBCHB
//128640000
//131952100
//6696 - no threads
//4722 - threads
//18989

    }
}
