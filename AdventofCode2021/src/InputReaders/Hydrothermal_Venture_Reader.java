/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InputReaders;

import Day5.Coodinates;
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 *
 * @author Daniel
 */
public class Hydrothermal_Venture_Reader extends AdventInputReader{

    public Hydrothermal_Venture_Reader(String file_path){
        super(file_path);
    }

    public String full_coordinates()throws NoSuchElementException{

        return obj_Reader.nextLine();
    }
    public Coodinates getCoords(String coords){
        String[] wibs = coords.split(" ");
        return new Coodinates(wibs[0], wibs[2]);
    }
}
