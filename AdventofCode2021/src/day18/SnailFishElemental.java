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

    private int elemental_value;

    public SnailFishElemental(int elemental_value, int depth) {
        this.elemental_value = elemental_value;
        if(depth == 4){is_Four_deep = true;}
        else{is_Four_deep = false;}
    }
@Override
protected String printNumber(){
    return elemental_value + "";
}

}
