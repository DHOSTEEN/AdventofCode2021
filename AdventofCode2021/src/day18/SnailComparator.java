/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day18;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Daniel
 */
public class SnailComparator implements Comparator<RawSnailNumber>{

    public int compare(RawSnailNumber first, RawSnailNumber second){
        return Integer.compare(second.getEnd_pos(), first.getEnd_pos());
    }
}
