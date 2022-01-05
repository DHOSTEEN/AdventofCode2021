/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class CustomCode <T>{

public ArrayList<LinkedList<T>> listBatchMaker(LinkedList<T> collection, int batchSize){
 
      int i = 0;
    ArrayList<LinkedList<T>> batches = new ArrayList<LinkedList<T>>();
    while(i<collection.size()){
        int nextInc = Math.min(collection.size()-i,batchSize);
        LinkedList<T> batch = new LinkedList(collection.subList(i,i+nextInc));
        batches.add(batch);
        i = i + nextInc;
    }

    return batches;
}
public boolean way_Up(int col){
    return (col -1 >= 0);
}
public boolean way_Down(int col, int length){
    return (col + 1 < length);
}
public boolean way_Left(int row){
    return (row -1 >=0);
}
public boolean way_Right(int row, int length){
    return(row +1 < length);
}
    
}
