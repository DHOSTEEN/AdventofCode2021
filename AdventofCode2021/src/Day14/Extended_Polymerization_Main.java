/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day14;

import InputReaders.Extended_Polymerization_Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 *
 * @author Daniel
 */
public class Extended_Polymerization_Main {

    private static Extended_Polymerization_Reader obj_Reader;
    private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput14_testdata.txt";
private static final int TEN_STEPS = 10;
private static final int FORTY_STEPS = 40;

    public static void main(String[] args){
        obj_Reader = new Extended_Polymerization_Reader(file_location);
        String polymer = obj_Reader.getPolymer();
        System.out.println(polymer);
        ArrayList<String[]> allInserts = obj_Reader.getAllInsertions();
        //allInserts.forEach(arr ->{System.out.println(Arrays.toString(arr));});

HashPolymer hash_logic = new HashPolymer();
hash_logic.addPolymer(polymer);
        System.out.println("ADDING: " + Arrays.toString(allInserts.get(0)));
allInserts.forEach(arr -> {hash_logic.setInserts(arr);});
hash_logic.printPoly();
hash_logic.printInsers();
        //Polymer_Logic logic = new Polymer_Logic(polymer);
       // allInserts.forEach(arr -> {logic.addPair(arr[0], arr[1]);});
       // System.out.println(logic.getPair_insertion_rules().toString());
        /* System.out.println("THE POLY: " +logic.getPolymer().toString());
       
        
        logic.singleStep();
        System.out.println("NEW POLY: " + logic.getPolymer().toString());*/
        //System.out.println("BATCH PROCESSING");
        //logic.batchProcessing().forEach(ar -> {System.out.println("ADDED: " + ar.toString());});
        System.out.println("LOGIC");
        //PolyThread thread = new PolyThread(logic);
        //WeirdTree tree = new WeirdTree(logic);
        long start = System.nanoTime();
HashMap<String, Long> map = hash_logic.getMap();
        for(int i =0; i<1; i++){
           //map = hash_logic.addInserts(map);
            hash_logic.insertFirst(map);
        }
        System.out.println("RESULT: " + hash_logic.calcAns(map));
        System.out.println("MAP: " + map.toString());
long num = 0L;
        for(Long l : map.values()){
num += l;
        }
        System.out.println(num);
        //System.out.println("AFTER poly:");
        //hash_logic.printPoly();
        /*for(int i =0; i<20; i++){
            //logic.singleStep();
            //thread.threadRun();
            tree.buildPoly();
        }
        System.out.println("SIZE OF FINAL POLYMER: " + logic.getPolymer().size());
        //System.out.println("FINAL POLYMER: " + logic.getPolymer().toString());
        System.out.println(logic.getAnswer());
// ...*/
        long finish = System.nanoTime();
        System.out.println("TIME :" + (finish - start)/1000000);


    }
}
