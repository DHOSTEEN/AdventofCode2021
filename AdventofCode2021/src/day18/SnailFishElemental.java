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
public class SnailFishElemental extends SnailFishNumber {


    protected long elemental_value;

    public SnailFishElemental(long elemental_value) {
        this.elemental_value = elemental_value;
    }
@Override
protected String printNumber(){
    return elemental_value + "";
}
@Override
protected long getValue(){return elemental_value;}
@Override
protected void setParent(SnailFishNumber parent){
    this.parent = parent;
}
@Override
protected void updateDepth(){
    depth++;
}
@Override
protected long calcMag(){
    return elemental_value;
}
@Override
protected void makeList(ArrayList<SnailFishNumber> list){
    list.add(this);
}

    @Override
    protected void explode(){
      /*  System.out.println("BOOM!!");
        if(parent != null){
            SnailFishNumber ancestory = parent;
            while(!(ancestory.left instanceof SnailFishElemental)){
                ancestory = ancestory.parent;
            }
            if(ancestory.left instanceof SnailFishElemental){
                 ((SnailFishElemental)parent.left).elemental_value += elemental_value;
            }
            ancestory = parent;
            while(!(ancestory.right instanceof SnailFishElemental)){
                ancestory = ancestory.parent;
            }
            if(ancestory.right instanceof SnailFishElemental){
               ((SnailFishElemental)parent.right).elemental_value += elemental_value;
            }
        }
            //parent.left += left; */
    }

public void splitWithList(ArrayList<SnailFishNumber>  ordered_list){

    //System.out.println("in split");
    //System.out.println(elemental_value);
    long left_elem = elemental_value/2;
    long right_elem = elemental_value/2 + elemental_value % 2;

SnailFishNumber left_num = new SnailFishElemental(left_elem);
SnailFishNumber right_num = new SnailFishElemental(right_elem);

        if(parent.left.equals(this) ){
            SnailFishNumber tempParent = parent;
            SnailFishNumber pair_left = new SnailFishPair(left_num, right_num, parent.depth +1);
            pair_left.setParent(tempParent);
            parent.left = pair_left;

        }
        else{
            SnailFishNumber tempParent = parent;
            SnailFishNumber pair_right = new SnailFishPair(left_num, right_num, parent.depth +1);
            pair_right.setParent(tempParent);
            parent.right = pair_right;
        }

   /* for(int i =0; i< ordered_list.size(); i++){
        if(ordered_list.get(i) == this){
            ordered_list.set(i, right_num);
            ordered_list.add(i+1, left_num);
            break;
        }
    }*/
}
    @Override
    protected void split(){
        //System.out.println("in split");
        long left_elem = elemental_value/2;
        long right_elem = elemental_value/2 + elemental_value % 2;

        if(parent.left.equals(this) ){
            SnailFishNumber tempParent = parent;
            SnailFishNumber pair_left = new SnailFishPair(new SnailFishElemental(left_elem), new SnailFishElemental(right_elem), parent.depth +1);
            pair_left.setParent(tempParent);
            parent.left = pair_left;
           

        }
        else{
            SnailFishNumber tempParent = parent;
            SnailFishNumber pair_right = new SnailFishPair(new SnailFishElemental(left_elem), new SnailFishElemental(right_elem), parent.depth +1);
            pair_right.setParent(tempParent);
            parent.right = pair_right;
        }

    }
private void cycleBack(){
    SnailFishNumber ancestor = parent;
        while(ancestor !=null){
            if(ancestor.parent == null){ancestor.setParent(null);}
            ancestor = ancestor.parent;
      
    }
        
}

}
    

