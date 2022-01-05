/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day15;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Daniel
 */
public class NodeComparator implements Comparator<Node> {
/**
sorts highest to lowest*/
    @Override
    public int compare(Node first_node, Node second_node){
        return Long.compare(second_node.getF(), first_node.getF());
    }
}
/*ublic class ArraySizeComparator  implements Comparator<ArrayList<Integer>>{

    @Override
    public int compare(ArrayList<Integer> firstList, ArrayList<Integer> secondList) {
       return Integer.compare( secondList.size(), firstList.size());
    }

    
}*/