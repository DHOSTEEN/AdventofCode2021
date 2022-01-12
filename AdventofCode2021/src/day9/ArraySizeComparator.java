/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day9;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Daniel
 */
public class ArraySizeComparator  implements Comparator<ArrayList<Integer>>{

    @Override
    public int compare(ArrayList<Integer> firstList, ArrayList<Integer> secondList) {
       return Integer.compare( secondList.size(), firstList.size());
    }

    
}
/*public class Player implements Comparable<Player> {

    // same as before

    @Override
    public int compareTo(Player otherPlayer) {
        return Integer.compare(getRanking(), otherPlayer.getRanking());
    }

}*/