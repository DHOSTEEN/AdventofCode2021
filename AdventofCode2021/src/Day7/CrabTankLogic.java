/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day7;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Daniel
 */
public class CrabTankLogic {

    public int getLeast_fuel_cost() {
        return least_fuel_cost;
    }

    public int getPos() {
        return pos;
    }

    private int least_fuel_cost;
    private int pos;
    private Integer[] all_crabs;
    
    public CrabTankLogic(ArrayList<Integer> list){

        least_fuel_cost = Integer.MAX_VALUE;
        pos =0;
        all_crabs = new Integer[list.size()];
        //list.sort(null); //no need to sort
        all_crabs = list.toArray(all_crabs);
    }

    public void findLeastFuel(){
        for(int i =0; i<all_crabs.length;i++){
            findLeastFuelhelper(all_crabs[i]);
        }        
    }

    private void findLeastFuelhelper(int search_pos){

        int poss_fuel_cost =0;
        int i =0;
        while(i<all_crabs.length && least_fuel_cost>poss_fuel_cost){
            poss_fuel_cost += countSteps(all_crabs[i], search_pos);
            i++;
        }
        if(least_fuel_cost> poss_fuel_cost){
            least_fuel_cost = poss_fuel_cost;
            pos = search_pos;
        }

    }
    private int countSteps(int target_step, int initial_step){

        int counter =0;
        if(target_step == initial_step){return counter;}
        if(initial_step>target_step){
            counter += countStepsDown(target_step, initial_step);
        }
        else{
            counter += countStepsUp(target_step, initial_step);
        }
    
        return counter;
    }

    protected int countStepsDown(int target_step, int initial_step){
        int counter =0;
        while(initial_step!=target_step){
            counter++;
            initial_step--;
        }
        return counter;
    }
    protected int countStepsUp(int target_step, int initial_step){
        int counter =0;
        while(initial_step != target_step){

            counter++;
            initial_step++;

        }
        return counter;
    }
}
