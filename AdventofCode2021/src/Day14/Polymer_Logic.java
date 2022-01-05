/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day14;

import CustomCode.CustomCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 *
 * @author Daniel
 */
public class Polymer_Logic{
  
    private HashMap<String, String> pair_insertion_rules;
    private ArrayList<TuppleStringInt> insertions;

    public HashMap<String, Long> getCount() {
        return count;
    }
    private HashMap<String, Long> count;

    public HashMap<String, String> getPair_insertion_rules() {
        return pair_insertion_rules;
    }

    public LinkedList<String> getPolymer() {
        return polymer;
    }

    public void setPolymer(LinkedList<String> polymer) {
        this.polymer = polymer;
    }

    private LinkedList<String> polymer;
/***/
    public Polymer_Logic(String raw_polymer){

        polymer = new LinkedList<>();
        pair_insertion_rules = new HashMap<>();
        count = new HashMap<>();
        String[] raw_polymer_split = raw_polymer.split("");
        for(int i =0; i<raw_polymer_split.length; i++){
            addCount(raw_polymer_split[i]);
        }
        Collections.addAll(polymer, raw_polymer.split(""));
    }
public Polymer_Logic(LinkedList<String> polymer, HashMap<String,String> pair_insertion_rules, HashMap<String, Long> count){
    this.polymer = polymer;
    this.pair_insertion_rules = pair_insertion_rules;
    this.count = count;
}

    public void addPair(String key, String val){
        key = key.trim();
        val = val.trim();
        pair_insertion_rules.put(key, val);
    }

private void addCount(String key){
    key = key.trim();

    if(!count.containsKey(key)){
        long one = 1;
        count.put(key, one);
    }
    else{
        count.put(key, (count.get(key) + 1));
    }
}
    public ArrayList<LinkedList<String>> batchProcessing(){

    CustomCode code = new CustomCode();
        ArrayList<LinkedList<String>> batchlist = code.listBatchMaker(polymer, 4);
       // batchlist.forEach(arr -> {System.out.println(arr.toString());});
        ArrayList<String> all_ends = new ArrayList<>();
        batchlist.forEach(arr ->{all_ends.add(arr.getLast());});
        //all_ends.forEach(arr -> {System.out.println("ENDS: " + arr);});
        for(int i =0; i<all_ends.size(); i++){
            if(i+1<batchlist.size()){
                batchlist.get(i+1).addFirst(all_ends.get(i));
            }
        }

        return batchlist;
    //batchlist.forEach(arr -> {System.out.println(arr.toString());});
   // AtomicInteger atomic_counter = new AtomicInteger();
    //Collection<List<String>> res = polymer.parallelStream().collect(Collectors.groupingBy(it ->atomic_counter.getAndIncrement()/3)).values();
    //System.out.println("PARALLEL" + res);
    //ForkJoinPool mypool = new ForkJoinPool();


//ArrayList<LinkedList<String>> res = new ArrayList<>();
//batchlist.parallelStream().forEach(stream -> { res.add(singleStep(stream));});
/*try{
    mypool.submit(() -> batchlist.parallelStream().forEach(stream -> { res.add(singleStep(stream));})).get();
/*for(LinkedList list : res){
        polymer.addAll(list);
    }*/
//}catch( InterruptedException | ExecutionException e){}
   
}
public void singleStepParallel(Stream<String> x){

}
    public void singleStep(){
        String pair = "";
        //System.out.println("HERE IN ");
        insertions = new ArrayList<>();
//start parallel here 

        for(int i =0; i<polymer.size(); i++){
//can thread this? but...why
            pair += polymer.get(i);
            //System.out.println("PAIR: " + pair);
            if(pair.length() == 2){
                String insert = pair_insertion_rules.get(pair);
                //System.out.println("Insert: " + insert + " at " + i);
                insertions.add(new TuppleStringInt(insert, i));
                addCount(insert);
                pair = polymer.get(i);
            }           
        }
//merge parallel here
        Collections.reverse(insertions);
        for(int i =0; i<insertions.size(); i++){
            polymer.add(insertions.get(i).pos, insertions.get(i).getStr());
        }
        
    }

    public LinkedList<String> singleParallelStep(LinkedList<String> poly){
        String pair = "";
        //System.out.println("HERE IN ");
        insertions = new ArrayList<>();

        for(int i =0; i<poly.size(); i++){
            pair += poly.get(i);
            //System.out.println("PAIR: " + pair);
            if(pair.length() == 2){
                String insert = pair_insertion_rules.get(pair);
                //System.out.println("Insert: " + insert + " at " + i);
                insertions.add(new TuppleStringInt(insert, i));
                addCount(insert);
                pair = poly.get(i);
            }           
        }
        Collections.reverse(insertions);//biggest save in time is here i think
        for(int i =0; i<insertions.size(); i++){
            poly.add(insertions.get(i).pos, insertions.get(i).getStr());
        }
        return poly;
    }
/**Returns most common element number, minus the least common element number*/
    public long getAnswer(){
        long min = Integer.MAX_VALUE; 
        long max = Integer.MIN_VALUE;
    for(long val : count.values()){
        if(min>val){
            min = val;
        }
        if(max<val){
            max = val;
        }
    }
        System.out.println("MAX: " + max);
        System.out.println("MIN: " + min);

    return max - min;}
public long getFinalAns(){
return 0;}

private class TuppleStringInt{

    public String getStr() {
        return str;
    }

    public int getPos() {
        return pos;
    }

    private final String str;
    private final int pos;

    public TuppleStringInt(String str, int pos){
        this.str = str;
        this.pos = pos;
    }
    }

}
