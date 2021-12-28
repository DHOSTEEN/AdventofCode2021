/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day7;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class FuelBurnCrabTankLogic extends CrabTankLogic{
    
    public FuelBurnCrabTankLogic(ArrayList<Integer> list){
        super(list);
    }
@Override
protected int countStepsDown(int target_step, int initial_step){
    int counter =0;
    int increaser =0;
    while(initial_step!=target_step){

        increaser++;
        counter+=increaser;
       // System.out.println("INCREASER: " + increaser);
       // System.out.println("COUNTER: " + counter);
        initial_step--;
    }
        return counter;
    }
@Override
protected int countStepsUp(int target_step, int initial_step){
        int counter =0;
        int increaser =0;
    while(initial_step != target_step){
        increaser++;
        counter+= increaser;
        initial_step++;
     //System.out.println("INCREASER: " + increaser);
       // System.out.println("COUNTER: " + counter);
    }
        return counter;
    }
}
