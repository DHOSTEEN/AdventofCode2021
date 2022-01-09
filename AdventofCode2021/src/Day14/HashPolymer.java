/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day14;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Daniel
 */
public class HashPolymer {

    private HashMap<String, Long> all_polymers;
    private Map<String, String> insertions;
private HashMap<Character, Long> duplicates;

    public HashPolymer(){
        all_polymers = new HashMap<>();
        insertions = new HashMap<>();
duplicates = new HashMap<>();
    }
public void setInserts(String[] inserts){

        String key = inserts[0];
        String insert = inserts[1];
      
        //System.out.println("KEY: " + key + " VAL: " + insert);
        insertions.put(key, insert);

}
public void insertFirst(HashMap<String, Long> old_map){
        long amount_to_add = 0L;
        for(String key: insertions.keySet()){

            if(old_map.containsKey(key)){
             String[] split_key = key.split("");
                String first_pair = split_key[0] + insertions.get(key);
                String second_pair = insertions.get(key) + split_key[1];

                System.out.println("KEY: " + key);
                System.out.println("FIRST: " + first_pair + " SECOND: " + second_pair);
                amount_to_add = old_map.get(key);

                long first_pair_in_old = old_map.getOrDefault(first_pair, 0L);
                long second_pair_in_old = old_map.getOrDefault(second_pair, 0L);
char dup = insertions.get(key).charAt(0);
                System.out.println("CHAR: " + dup);
if(duplicates.containsKey(dup)){
    duplicates.put(dup, duplicates.get(dup) + amount_to_add/2);
}
else{duplicates.put(dup, amount_to_add/2);}
                old_map.put(first_pair, amount_to_add + first_pair_in_old);
                old_map.put(second_pair, amount_to_add + second_pair_in_old);
                old_map.remove(key);
            }
            //else{next_step.put(key, old_map.get(key));}
        }

    }
    public HashMap<String, Long> addInserts(HashMap<String,Long> old_map){    
        HashMap<String, Long> next_step = new HashMap<>();
        long amount_to_add = 0L;
        for(String key: old_map.keySet()){

            if(insertions.containsKey(key)){
                String[] split_key = key.split("");
                String first_pair = split_key[0] + insertions.get(key);
                String second_pair = insertions.get(key) + split_key[1];

                System.out.println("KEY: " + key);
                System.out.println("FIRST: " + first_pair + " SECOND: " + second_pair);
                amount_to_add = old_map.get(key);

char dup = insertions.get(key).charAt(0);
                System.out.println("CHAR: " + dup);
if(duplicates.containsKey(dup)){
    duplicates.put(dup, duplicates.get(dup) + amount_to_add/2);
}
else{duplicates.put(dup, amount_to_add/2);}
                long first_pair_in_old = old_map.getOrDefault(first_pair, 0L);
                long second_pair_in_old = old_map.getOrDefault(second_pair, 0L);
                next_step.put(first_pair, amount_to_add + first_pair_in_old);
                next_step.put(second_pair, amount_to_add + second_pair_in_old);
            
            }
            //else{next_step.put(key, old_map.get(key));}             
//all_polymers = new HashMap<>(next_step);
        }
       return next_step;
    }
    public void addPolymer(String polymer){
        String[] indvidual_letters = polymer.split("");
        int lim = 0;
        String pair = "";

        for(int i =0; i<indvidual_letters.length; i++){
            pair += indvidual_letters[i];
            lim++;
            if(lim == 2){
                //System.out.println("PAIR: " + pair);
                lim = 1; 
   
                if(all_polymers.containsKey(pair)){
                    all_polymers.put(pair, all_polymers.get(pair) + 1L);
                }
                else{
                    all_polymers.put(pair, 1L);
                }  
             pair = indvidual_letters[i];
            }
           
        }
    }

public void singleStep(){
all_polymers = addInserts(all_polymers);

}
public long calcAns(HashMap<String,Long> map){
    long min = Long.MAX_VALUE;
    long max = Long.MIN_VALUE;
    HashMap<Character, Long> char_record = new HashMap<>();
    for(String key : map.keySet()){
        char first = key.charAt(0);
        char second = key.charAt(1);
        if(char_record.containsKey(first)){
            char_record.put(first, char_record.get(first) + map.get(key));
        }
        else{char_record.put(first, map.get(key));}
        /*if(char_record.containsKey(second)){
            char_record.put(second, char_record.get(second) + map.get(key));
        }
        else{char_record.put(second, map.get(key));}*/
    }
    System.out.println("CHARS: " + duplicates.toString());
    for(Character key : char_record.keySet()){
        long val = char_record.get(key);// - duplicates.getOrDefault(key, 0L);
        if(val<min){min = val;}
        if(val>max){max = val;}
    }
    System.out.println("MAX: " + max + " MIN: " + min);
    return max - min;
} 
    public void printPoly(){System.out.println(all_polymers.toString());}
    public void printInsers(){System.out.println(insertions.toString());}
public HashMap<String, Long> getMap(){return all_polymers;}

}
