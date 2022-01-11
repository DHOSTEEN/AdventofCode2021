/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day18;

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
protected String printNumber(){
    return "[" + left.printNumber() + "," + right.printNumber() + "]";
}
@Override
protected void explode(){
        System.out.println("BOOM!!");

        has_boomed_left = false;
        has_boomed_right = false;

        if(parent != null){      
            SnailFishNumber ancestory = parent;
            explodeHelper(ancestory);
    
        if(has_boomed_left || has_boomed_right){
            if(parent.left.equals(this)){
                parent.left = new SnailFishElemental(0);
            }
            else{
                parent.right = new SnailFishElemental(0);
            }
        }
    }

}

private void explodeHelper(SnailFishNumber ancestory){

    if(ancestory.left instanceof SnailFishElemental && !has_boomed_left){
        System.out.println("In left boom");
       ((SnailFishElemental)ancestory.left).elemental_value += left.getValue();
        has_boomed_left = true;

    }

    if(ancestory.right instanceof SnailFishElemental && ! has_boomed_right){
        System.out.println("in right boom");
        ((SnailFishElemental)ancestory.right).elemental_value += right.getValue();
        has_boomed_right = true;
        //return;
    }
    if(ancestory.left instanceof SnailFishPair && ancestory.left.right instanceof SnailFishElemental && !has_boomed_left ){
        System.out.println("In left boom");
        ((SnailFishElemental)ancestory.left.right).elemental_value += left.getValue();
         has_boomed_left = true;
        }

    if(!is_direct_ancestor(ancestory.right) && ancestory.right instanceof SnailFishPair && ancestory.right.left instanceof SnailFishElemental && ! has_boomed_right){
      System.out.println("in right boom");
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
    protected int getValue(){
        System.out.println("NUUUUUUUU");
        return left.getValue() + right.getValue();
    }
    @Override
    public void setParent(SnailFishNumber parent){
        left.setParent(this);
        right.setParent(this);
        if(parent != null){
            this.parent = parent;
        }
    }
}
