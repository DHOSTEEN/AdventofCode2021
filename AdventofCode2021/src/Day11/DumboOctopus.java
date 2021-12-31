/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day11;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class DumboOctopus {

    public int getEnergy_level() {
        return energy_level;
    }
    public void reset(){
        has_flashed = false;
    }

    public ArrayList<DumboOctopus> getAdjacent() {
        return adjacent;
    }
    public void addAdjacent(DumboOctopus octo){
        adjacent.add(octo);
    }

    public boolean isHas_flashed() {
        return has_flashed;
    }

    private boolean has_flashed;
    private int energy_level;
    private ArrayList<DumboOctopus> adjacent;
    private final DumbOctopusLogic master;

    public DumboOctopus(int energy_level, DumbOctopusLogic master){
has_flashed = false;
        this.master = master;
        this.energy_level = energy_level;
        adjacent = new ArrayList<>();
    }

public void incrementEnergy(){


    if(!has_flashed){energy_level++;}
    else if(has_flashed){energy_level =0;}
//    /System.out.println("AM UPPING");
    if(!has_flashed && energy_level>9){
        //System.out.println("IN HERE");
        master.addFlash();
        energy_level = 0;
        has_flashed = true;
        energizeAdjacent();
       
    }
    else if(has_flashed && energy_level > 9){
        energy_level = 9;
    }
}
    private void energizeAdjacent(){

    //adjacent.parallelStream().forEach(oct -> incrementEnergy());//MIGHT be an issue, Parallel LOL YE 
        for(int col =0; col<adjacent.size(); col++){    
            adjacent.get(col).incrementEnergy();
        }
    }
    
}
