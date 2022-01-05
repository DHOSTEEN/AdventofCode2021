/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Daniel
 */
public class WeirdTree extends Thread{

//attempt to parallel the left and right

//split in half until 2 or 1
//apply Logic to grow
//merge
private Polymer_Logic logic;

    public void setLeft_split(LinkedList<String> left_split) {
        this.left_split = left_split;
    }

    public void setRight_split(LinkedList<String> right_split) {
        this.right_split = right_split;
    }

    public LinkedList<String> getLeft_split() {
        return left_split;
    }

    public LinkedList<String> getRight_split() {
        return right_split;
    }
private LinkedList<String> left_split;
private LinkedList<String> right_split;
private HashMap<String, String> pair_insertion_rules;
private HashMap<String, Long> count;


    public WeirdTree(Polymer_Logic logic){
        this.logic = logic;
    }
    public WeirdTree(HashMap<String, String> pair_insertion_rules, HashMap<String, Long> count){
        this.pair_insertion_rules = pair_insertion_rules;
        this.count = count;
    }

    public void buildPoly(){

        LinkedList<String> polymer = logic.getPolymer();
        //splitBranch(polymer);
        LinkedList<String> left_split_build = new LinkedList(polymer.subList(0, polymer.size()/2));
        LinkedList<String> right_split_build = new LinkedList(polymer.subList((polymer.size()/2)-1, polymer.size()));
        //System.out.println("LEFTSIDE");
       // System.out.println(left_split_build.toString());
        //System.out.println("RIGHTSIDE");
        //System.out.println(right_split_build.toString());
      /* WeirdTree threadTree = new WeirdTree(logic.getPair_insertion_rules(), logic.getCount());

        threadTree.setLeft_split(left_split_build);
        threadTree.setRight_split(right_split_build);

        threadTree.start();
        while(threadTree.isAlive()){}
        polymer = threadTree.getLeft_split();
        polymer.addAll(threadTree.getRight_split());
        //System.out.println("DONE" + polymer.toString());
        logic.setPolymer(polymer);*/

       WeirdTree left_tree = new WeirdTree(logic.getPair_insertion_rules(), logic.getCount());
        WeirdTree right_tree = new WeirdTree(logic.getPair_insertion_rules(), logic.getCount());

        left_tree.setLeft_split(left_split_build);
        right_tree.setLeft_split(right_split_build);
        left_tree.start();
        right_tree.start();
    while(left_tree.isAlive() || right_tree.isAlive()){
    //do NOTHING
    }
    polymer = left_tree.getLeft_split();
    right_split_build = right_tree.getLeft_split();
    right_split_build.removeFirst();
    polymer.addAll(right_split_build);
    logic.setPolymer(polymer);
    }

        
    

private LinkedList<String> threadBranch(LinkedList<String> poly_branch){

    LinkedList<String> left_split_branch = new LinkedList(poly_branch.subList(0, poly_branch.size()/2));
    LinkedList<String> right_split_branch = new LinkedList(poly_branch.subList((poly_branch.size()/2)-1, poly_branch.size()));

    WeirdTree left_tree = new WeirdTree(pair_insertion_rules, count);
    WeirdTree right_tree = new WeirdTree(pair_insertion_rules, count);

    left_tree.setLeft_split(left_split_branch);
    right_tree.setLeft_split(right_split_branch);
    left_tree.start();
    right_tree.start();
    while(left_tree.isAlive() || right_tree.isAlive()){}
    poly_branch = left_tree.getLeft_split();
    right_split_branch = right_tree.getLeft_split();
    right_split_branch.removeFirst();
    poly_branch.addAll(right_split_branch);
    return poly_branch;

}
private LinkedList<String> splitBranch(LinkedList<String> poly_branch){

    LinkedList<String> left_split_branch = new LinkedList(poly_branch.subList(0, poly_branch.size()/2));
    LinkedList<String> right_split_branch = new LinkedList(poly_branch.subList((poly_branch.size()/2)-1, poly_branch.size()));

    WeirdTree branch = new WeirdTree(pair_insertion_rules, count);
    branch.setLeft_split(left_split_branch);
    branch.setRight_split(right_split_branch);

    branch.start();//make two!!!!
    while(branch.isAlive()){}
    poly_branch = branch.getLeft_split();
    poly_branch.addAll(branch.getRight_split());
    //System.out.println("DONE IN NESTED" + poly_branch.toString());
    return poly_branch;
}
  
@Override
    public void run(){
        if(left_split.size()>10000){
           // System.out.println("new thread");
           // left_split = splitBranch(left_split);
            left_split = threadBranch(left_split);
        }
        else{
            Polymer_Logic my_logic = new Polymer_Logic(left_split, pair_insertion_rules, count);
            my_logic.singleStep();
            left_split = my_logic.getPolymer();
            //my_logic.getCount();
        }
        /*if(right_split.size()>1024){
  //System.out.println("new thread");
            right_split = splitBranch(right_split);
            right_split.removeFirst();
        }
        else{
            Polymer_Logic my_logic = new Polymer_Logic(right_split, pair_insertion_rules, count);
            my_logic.singleStep();
            right_split = my_logic.getPolymer();
            right_split.removeFirst();
        }*/
        
    }

private void mergeMaps(HashMap<String, Long> map){
    for(String key : count.keySet()){

    }    
}
    
}
