/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day14;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Daniel
 */
public class PolyThread extends Thread{

    private Polymer_Logic logic;

    public ArrayList<LinkedList<String>> getNew_poly() {
        return new_poly;
    }
    private ArrayList<LinkedList<String>> new_poly;

    public PolyThread(Polymer_Logic logic){
        new_poly = new ArrayList<>();
        this.logic = logic;
    }

    public void threadRun(){
        PolyThread mini_me = new PolyThread(logic);

            mini_me.start();
        while(mini_me.isAlive()){
            //System.out.println("waiting...");
        }    
        new_poly = mini_me.getNew_poly();
        //System.out.println("DONE THREAD");  
        LinkedList<String> polymer = new LinkedList<>();
        //System.out.println("SIZE" + new_poly.size());
        polymer.addAll(new_poly.get(0));
        for(int i =1; i< new_poly.size(); i++){
            new_poly.get(i).removeFirst();
            polymer.addAll(new_poly.get(i));
        }
        logic.setPolymer(polymer);
    }
    @Override
    public void run(){

        ArrayList<LinkedList<String>> batchlist = logic.batchProcessing();
        //System.out.println("BATCH SIZE" + batchlist.size());
        for(LinkedList list : batchlist){
            new_poly.add(logic.singleParallelStep(list));
        }
    }  
    
}
