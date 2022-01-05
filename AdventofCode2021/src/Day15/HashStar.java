/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day15;

import CustomCode.CustomCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *
 * @author Daniel
 */
/*// A* Search Algorithm
1.  Initialize the open list
2.  Initialize the closed list
    put the starting node on the open 
    list (you can leave its f at zero)

3.  while the open list is not empty
    a) find the node with the least f on 
       the open list, call it "q"

    b) pop q off the open list
  
    c) generate q's 8 successors and set their 
       parents to q
   
    d) for each successor
        i) if successor is the goal, stop search
          successor.g = q.g + distance between 
                              successor and q
          successor.h = distance from goal to 
          successor (This can be done using many 
          ways, we will discuss three heuristics- 
          Manhattan, Diagonal and Euclidean 
          Heuristics)
          
          successor.f = successor.g + successor.h

        ii) if a node with the same position as 
            successor is in the OPEN list which has a 
           lower f than successor, skip this successor

        iii) if a node with the same position as 
            successor  is in the CLOSED list which has
            a lower f than successor, skip this successor
            otherwise, add  the node to the open list
     end (for loop)
  
    e) push q on the closed list
    end (while loop)*/
public class HashStar {

private Map<String, Long> open;
private Map<String, Long> closed;
private Map<String,Long> successors;
private Map<String,Long> pathcost;
private Map<String, Long> pathbuilder;
private Map<String,Node> nodes;
private Map<String,Node> final_nodes;
private int[][] map;
private CustomCode bools;
private long best;
private String bestKey;
private ArrayList<String> the_path;
private Node node;
    public HashStar(int[][] map){
        this.map = map;
        open = new HashMap<>();
        closed = new HashMap<>();
        pathcost = new HashMap<>();
pathbuilder = new HashMap<>();
successors = new HashMap<>();
        bools = new CustomCode();
the_path = new ArrayList<>();
node = new Node(0L, 0, 0);
nodes = new HashMap<>();
final_nodes = new HashMap<>();
    }

    public void findPath(){
        open.put(0+"-"+0, 0L);
        final_nodes.put(0+"-"+0, node);
        pathcost.put(0+"-"+0, 0L);
        //System.out.println(open.keySet().toString());
        String test = (map.length-1)+"-" +(map.length-1);
        System.out.println(test);
        boolean found = false;
        while(!open.isEmpty() && !found){
        //for(String key : open.keySet()){
            //System.out.println(key + "val: " + open.get(key));}
            String key_q = getMin();
            //System.out.println("MIN: " + key_q + " val: " + open.get(key_q));
            genSuccessors(key_q);
            for(String key: successors.keySet()){
                //System.out.println("TEST : " + test);

                if(key.equals(test)){
                    System.out.println("HAVE PROC");
                    best = pathbuilder.get(key);
                    bestKey = key;
                    found = true;
                    System.out.println("F COST: " +successors.get(key));
                    node = nodes.get(key);
                    break;
                }
     
                String[] key_split = key.split("-");
                int col = Integer.parseInt(key_split[0]);
                int row = Integer.parseInt(key_split[1]);
               // System.out.println("COL: " + col + " ROW: " + row);
                long heuristic =  Math.abs((col - (map.length-1))) + Math.abs((row - map.length-1));
                long f = successors.get(key);
                if(!has_in_Open(key, f) && !has_in_Closed(key,f)){
                //pathcost.put(key, successors)}
                    open.put(key, f);
                    pathcost.put(key, pathbuilder.get(key));
                    the_path.add(key);
                    final_nodes.put(key,nodes.get(key));
                }       
                /*if(!(open.containsKey(key) && !(f>open.get(key)))){
                    if(!(closed.containsKey(key) && !(f>closed.get(key)))){
                        pathcost.put(key, successors.get(key));
                        open.put(key, f);
                    }
                }*/
            }//end for
            closed.put(key_q, open.get(key_q));
            open.remove(key_q);
            nodes.remove(key_q);
            pathcost.remove(key_q);
final_nodes.remove(key_q);
        }
        System.out.println("BEST: " + best + " AT: " + bestKey);
        System.out.println(the_path.toString());

    while(node != null){
    System.out.println(node.getCol() + "- "+node.getRow());
            node = node.getParent();
        
    }
    }

private boolean has_in_Open(String key, long f){
    if(open.containsKey(key)){
        return open.get(key)<f;
    }
    return false;
}
private boolean has_in_Closed(String key, long f){
 if(closed.containsKey(key)){
        return closed.get(key)<f;
    }
    return false;
}
private void genSuccessors(String key){

    successors.clear();
    pathbuilder.clear();
    nodes.clear();
    /*int half = key.length() % 2 == 0 ? key.length()/2 : key.length()/2 + 1;
    String first = key.substring(0, half);
    String second = key.substring(half);
    int col = Integer.parseInt(first);
    int row = Integer.parseInt(second);*/
    String[] key_split = key.split("-");
int col = Integer.parseInt(key_split[0]);
int row = Integer.parseInt(key_split[1]);
    //System.out.println("COL: " + col + " ROW: " + row);
    long val = 0L;
    String suc_key ="";

    if(bools.way_Up(col)){

        val= map[col-1][row];
        suc_key = (col-1) + "-" +row;
        successors.put(suc_key, val + open.get(key));
        pathbuilder.put(suc_key, val + pathcost.get(key));
        nodes.put(suc_key, new Node(val + pathcost.get(key), col, row, final_nodes.get(key)));
    }
    if(bools.way_Down(col, map.length)){
        val = map[col+1][row];
        suc_key = (col+1) + "-" +row;
        successors.put(suc_key, val + open.get(key));
        pathbuilder.put(suc_key, val + pathcost.get(key));
        nodes.put(suc_key, new Node(val + pathcost.get(key), col, row, final_nodes.get(key)));
    }
    if(bools.way_Left(row)){
        val = map[col][row-1];
        suc_key = col + "-" + (row-1);
        successors.put(suc_key, val + open.get(key));
        pathbuilder.put(suc_key, val + pathcost.get(key));
        nodes.put(suc_key, new Node(val + pathcost.get(key), col, row, final_nodes.get(key)));
    }
    if(bools.way_Right(row, map.length)){
        val = map[col][row+1];
        suc_key = col + "-" + (row+1);
        successors.put(suc_key, val + open.get(key));
        pathbuilder.put(suc_key, val + pathcost.get(key));
        nodes.put(suc_key, new Node(val + pathcost.get(key), col, row, final_nodes.get(key)));
    }

}
    private String getMin(){
        Entry<String, Long> min = null;
        for (Entry<String, Long> entry : open.entrySet()) {
            if (min == null || min.getValue() > entry.getValue()) {
                min = entry;
            }
        }
        //System.out.println("MIN: " +min.getKey() + " VAL:" + min.getValue());
        return min.getKey();
    }
}
