/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day18;

/**
 *
 * @author Daniel
 */
public class SnailFishElemental extends SnailFishNumber {

    public int getElemental_value() {
        return elemental_value;
    }

    public void setElemental_value(int elemental_value) {
        this.elemental_value = elemental_value;
    }

    protected int elemental_value;

    public SnailFishElemental(int elemental_value) {
        this.elemental_value = elemental_value;
    }
@Override
protected String printNumber(){
    return elemental_value + "";
}
@Override
protected int getValue(){return elemental_value;}
@Override
protected void setParent(SnailFishNumber parent){
    this.parent = parent;
}

    @Override
    protected void explode(){
        System.out.println("BOOM!!");
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
            //parent.left += left; 
    }
    private void explodeHelper(){
    }

}
    

