/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day11;

import java.util.Arrays;

/**
 *
 * @author Daniel
 */
public class DumbOctopusLogic {

    //private boolean[][] has_flashed;

    public DumboOctopus[][] getOcto() {
        return octo;
    }
    private DumboOctopus[][] octo;

    public long getFlash_counter() {
        return flash_counter;
    }

    public void addFlash(){
        flash_counter++;
    }
    private long flash_counter;

    public DumbOctopusLogic(int[][] octo){

        flash_counter = 0;
        this.octo = dumb_octo_Converter(octo);
        addAjacent();
        //has_flashed = new boolean[octo.length][octo.length];
    }

    public void singleStep(){
        for(int col = 0; col<octo.length; col++){
            for(int row = 0; row<octo[col].length; row++){
                octo[col][row].incrementEnergy();}
        }
        //resetAll();
    }
    public boolean isSync(){
        for(int col = 0; col<octo.length; col++){
            for(int row = 0; row<octo[col].length; row++){
                if(!octo[col][row].isHas_flashed()){
                    return false;
                }
            }
        } 
        return true;  
    }
    public void resetAll(){
        for(int col = 0; col<octo.length; col++){
            for(int row = 0; row<octo[col].length; row++){
                octo[col][row].reset();}
        }   
    }
    private DumboOctopus[][] dumb_octo_Converter(int[][] octo_arr){

        DumboOctopus[][] converted_arr =  new DumboOctopus[octo_arr.length][octo_arr[0].length];
        for(int col =0; col<octo_arr.length; col++){
            for(int row =0; row<octo_arr[col].length; row++){

                converted_arr[col][row] = new DumboOctopus(octo_arr[col][row], this);
            }
        }
        return converted_arr;
    }
    private void addAjacent(){
        for(int col =0; col<octo.length; col++){
            for(int row =0; row<octo[col].length; row++){
               
                if(way_Up(col)){
                    octo[col][row].addAdjacent(octo[col-1][row]);}
                if(way_Down(col)){
                    octo[col][row].addAdjacent(octo[col+1][row]);}
                if(way_Left(row)){
                    octo[col][row].addAdjacent(octo[col][row-1]);}
                if(way_Right(row)){
                    octo[col][row].addAdjacent(octo[col][row+1]);}
                //Diagonals
                if(way_Up(col) && way_Left(row)){
                    octo[col][row].addAdjacent(octo[col-1][row-1]);}
                if(way_Up(col) && way_Right(row)){
                    octo[col][row].addAdjacent(octo[col-1][row+1]);}
                if(way_Down(col) && way_Left(row)){
                    octo[col][row].addAdjacent(octo[col+1][row-1]);}
                if(way_Down(col) && way_Right(row)){
                    octo[col][row].addAdjacent(octo[col+1][row+1]);
                }
            }
        }//end of loop
    }


private boolean way_Up(int col){
    return (col -1 >= 0);
}
private boolean way_Down(int col){
    return (col + 1 < octo.length);
}
private boolean way_Left(int row){
    return (row -1 >=0);
}
private boolean way_Right(int row){
    return(row +1 < octo[0].length);
}


    
}
