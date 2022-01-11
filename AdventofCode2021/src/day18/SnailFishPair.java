/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day18;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class SnailFishPair extends SnailFishNumber{

protected boolean has_boomed_left;
protected boolean has_boomed_right;

    public SnailFishPair(SnailFishNumber left, SnailFishNumber right, int depth){

        this.left = left;
        this.right = right;
        this.depth = depth;
        is_Four_deep = depth == 4;
    }
@Override
protected long calcMag(){

    return 3*left.calcMag() + 2*right.calcMag();
}
@Override
protected SnailFishNumber add(SnailFishNumber snail_number){
    SnailFishNumber number = new SnailFishPair(this, snail_number, depth);
   
    updateDepth();
    return number;
}
@Override
protected void updateDepth(){
    depth++;
    is_Four_deep = depth ==4;
    left.updateDepth(); right.updateDepth();
}
    @Override
    protected String printNumber(){
        return "[" + left.printNumber() + "," + right.printNumber() + "]";
    }
    @Override
    protected void makeList(ArrayList<SnailFishNumber> list){
        left.makeList(list);
        right.makeList(list);
    }

public void explodeWithList(ArrayList<SnailFishNumber> ordered_list){

boolean has_boomed = false;
int left_in_list = -1;
int right_in_list = -1;
    //System.out.println("BOOM!");
    //System.out.println("LEFT: " + left.getValue() + " RIGHT: " + right.getValue());
    for(int i =0; i<ordered_list.size(); i++){

        if(ordered_list.get(i) == left){
            //System.out.println("leftBoom");
            if(i-1>=0){
                ((SnailFishElemental)ordered_list.get(i-1)).elemental_value += left.getValue();
               
            }   
            left_in_list = i;
            has_boomed = true;      
        }
        if(ordered_list.get(i) ==  right){
            //System.out.println("rightBoom");
            if((i+1)<ordered_list.size()){
                ((SnailFishElemental)ordered_list.get(i + 1)).elemental_value += right.getValue();
               
                }
            right_in_list = i;
            has_boomed = true;
        }
    }
    if(has_boomed){

        if(parent.left.equals(this)){
            SnailFishNumber elem_left = new SnailFishElemental(0);
            elem_left.setParent(parent);
            parent.left = elem_left;
            ordered_list.set(left_in_list, parent.left);
            ordered_list.remove(left_in_list +1);
            
        }
        else{
            SnailFishNumber elem_right = new SnailFishElemental(0);
            elem_right.setParent(parent);
            parent.right = elem_right;
            ordered_list.set(right_in_list, parent.right);
            ordered_list.remove(right_in_list-1);
            
        }
    }

}
    @Override
    protected void explode(){
        //System.out.println("BOOM!!");
        //System.out.println("BOOMING: " + printNumber());
        if(left instanceof SnailFishPair){
            left.explode();
        }
else{
        System.out.println("LEFT: " + left.getValue() + " RIGHT: " + right.getValue());
            has_boomed_left = false;
            has_boomed_right = false;

            if(parent != null){   
                System.out.println("null?");   
                SnailFishNumber ancestory = parent;
                explodeHelper(ancestory);

            if(has_boomed_left || has_boomed_right){
                if(parent.left.equals(this)){
                   // parent.left = new SnailFishElemental(0);
                    SnailFishNumber elem_left = new SnailFishElemental(0);
                    elem_left.setParent(parent);
                    parent.left = elem_left;
                }
                else{
                    SnailFishNumber elem_right = new SnailFishElemental(0);
                    elem_right.setParent(parent);
                    parent.right = elem_right;
                }
            }
        }
}
    }

    private void explodeHelper(SnailFishNumber ancestory){
//possible use a list to read what IS the next line. how to link list with nodes...

        if(ancestory.left instanceof SnailFishElemental && !has_boomed_left){
            System.out.println("In left boom");
           ((SnailFishElemental)ancestory.left).elemental_value += left.getValue();
            has_boomed_left = true;
        }
        if(ancestory.left instanceof SnailFishPair && ancestory.left.right instanceof SnailFishElemental && !ancestory.left.right.equals(right) && !has_boomed_left ){
            System.out.println("In left boom?");
            ((SnailFishElemental)ancestory.left.right).elemental_value += left.getValue();
             has_boomed_left = true;
        }

        if(ancestory.left instanceof SnailFishPair && ancestory.left.left instanceof SnailFishElemental && !ancestory.left.left.equals(left) && !has_boomed_left ){
            System.out.println("in left boom");
            ((SnailFishElemental)ancestory.left.left).elemental_value += left.getValue();
             has_boomed_left = true;
        }
        
        if(ancestory.right instanceof SnailFishElemental && ! has_boomed_right){
            System.out.println("in right boom");
            ((SnailFishElemental)ancestory.right).elemental_value += right.getValue();
            System.out.println("I R: " + ((SnailFishElemental)ancestory.right).elemental_value);
            has_boomed_right = true;
            //return;
        }       
        if(!is_direct_ancestor(ancestory.right) && ancestory.right instanceof SnailFishPair && ancestory.right.left instanceof SnailFishElemental && ! has_boomed_right){
          System.out.println("in right boom??");
            ((SnailFishElemental)ancestory.right.left).elemental_value += right.getValue();
            has_boomed_right = true;
        }
        if(ancestory.parent!=null){
            explodeHelper(ancestory.parent);
        }
    }

    private boolean is_direct_ancestor(SnailFishNumber ancestor){
        if(ancestor.right !=null){
        while(!(ancestor.right instanceof SnailFishElemental)){
            ancestor = ancestor.right;
            }

            return ancestor.equals(this);
        }
        return true;
    }



    @Override
    protected long getValue(){
        return 0L;
    }
    @Override
    public void setParent(SnailFishNumber given_parent){
        left.setParent(this);
        right.setParent(this);
        if(given_parent != null){
            this.parent = given_parent;
        }
    }
}
