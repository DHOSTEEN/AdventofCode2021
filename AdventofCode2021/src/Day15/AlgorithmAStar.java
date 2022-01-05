/*
 * Click nbfs://nbhost/////SystemFile////System/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/////SystemFile////System/Templates/Classes/Class.java to edit this template
 */
package Day15;

import CustomCode.CustomCode;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Daniel
 */
public class AlgorithmAStar {

    private ArrayList<Node> open_list;
    private ArrayList<Node> closed_list;
    private ArrayList<Node> successors;
    private CustomCode bools;
    private int[][] graph;
    private long best_cost;
    private Node bestNode;

    public AlgorithmAStar(int[][] graph){
        open_list = new ArrayList<>();
        closed_list = new ArrayList<>();
        bools = new CustomCode();
        this.graph = graph;
    }
/*for each successor
        i) if successor is the goal, stop search
          successor.g = q.g + distance between 
                              successor and q
          successor.h = distance from goal to 
          successor (This can be done using many 
          ways, we will discuss three heuristics- 
          Manhattan, Diagonal and Euclidean 
          Heuristics)
          
          successor.f = successor.g + successor.h*/
public void findPath(){
    open_list.add(new Node (0L, 0, 0));
   // long heuristic = naivePath();
    best_cost =0;
boolean isFound = false;
    while(!open_list.isEmpty() && !isFound){
        open_list.sort(new NodeComparator());
for(int i =0; i<closed_list.size();i++){
    //System.out.println("DEAD: " + closed_list.get(i).getF() + "(" + closed_list.get(i).getCol() + "- "+ closed_list.get(i).getRow() +")");
}
for(int i =0;i<open_list.size();i++){
    //System.out.println("in " + i + " is: " + open_list.get(i).getF() + " {" + open_list.get(i).getCol() + "-" + open_list.get(i).getRow() + ")");
}
        Node q = open_list.get(open_list.size()-1);//smallest
        open_list.remove(open_list.size()-1);
        ////System.out.println("I SHOULD BE LESS");
//System.out.println("CHOSEN: " + q.getF() + " (" + q.getCol() + "-" + q.getRow() + ")");
for(int i =0;i<open_list.size();i++){
    ////System.out.println("in " + i + " is: " + open_list.get(i).getF());
}
        successors = genSuccessors(q.getCol(), q.getRow(), q);
        for(Node node : successors){
            if(node.getCol() == graph.length-1 && node.getRow() == graph.length-1){
                //System.out.println("ONLY ONCE");
                best_cost = node.getCost();
                isFound = true;
                bestNode = node;
                break;
            }
            long heuristic = Math.abs((node.getCol() - (graph.length-1))) + Math.abs((node.getRow() - graph.length-1));
            //System.out.println("H: " + heuristic + " for (" + node.getCol() + "-" + node.getRow() + ")");
            node.setF(node.getCost() + heuristic);
            if(!hasNode_in_Open(node.getCol(), node.getRow(), node.getF()) && !hasNode_in_Closed(node.getCol(), node.getRow(), node.getF())){//skip if lower in open
////System.out.println("NODE ADDED IS: " + node.getF() + "(" + node.getCol() + "- "+ node.getRow() +")");
                open_list.add(node);
            }
        }//end for loop
        closed_list.add(q);
    }//end while loop
System.out.println("BEST: " + best_cost);
while(bestNode!=null){
    //System.out.println("F: "+ bestNode.getCost()+ "(" + bestNode.getCol() + "-" + bestNode.getRow() + ")");
bestNode = bestNode.getParent();
}
}
   private ArrayList<Node> genSuccessors(int col, int row, Node parent){
        ArrayList<Node> suc = new ArrayList<>();
        long val;
        if(bools.way_Up(col)){
            val = parent.getCost() + graph[col-1][row];
            suc.add(new Node(val, col-1, row, parent));
        }
        if(bools.way_Down(col, graph.length)){
            val = parent.getCost() + graph[col+1][row];           
            suc.add(new Node(val, col+1, row, parent));
        }
        if(bools.way_Left(row)){
            val = parent.getCost() + graph[col][row-1];
            suc.add(new Node(val, col, row-1, parent));
        }
        if(bools.way_Right(row, graph.length)){
            val = parent.getCost() + graph[col][row+1];
            suc.add(new Node(val, col, row+1, parent));
        }
        return suc;
    }
  private long naivePath(){
        long cost = 0L;
        for(int i =1; i<graph.length; i++){
            cost += graph[0][i];
        }
        for(int i =0; i<graph.length; i++){
            cost += graph[i][graph.length-1];
        }
        return cost;
    }
private boolean hasNode_in_Open(int col, int row, Long f){
    for(Node node : open_list){
        if(node.getCol() == col && node.getRow() == row){
            if(f>node.getF()){
                return true;
            }
        }
    }
    return false;
}
private boolean hasNode_in_Closed(int col, int row, Long f){
     for(Node node : closed_list){
        if(node.getCol() == col && node.getRow() == row){
            if(f>node.getF()){
                return true;
            }
        }
    }
    return false;
}
}
