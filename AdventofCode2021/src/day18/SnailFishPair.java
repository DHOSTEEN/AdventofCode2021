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

private SnailFishNumber first;
private SnailFishNumber second;

    public SnailFishPair(SnailFishNumber first, SnailFishNumber second){

        this.first = first;
        this.second = second;
    }
@Override
protected String printNumber(){
    return "[" + first.printNumber() + "," + second.printNumber() + "]";
}
}
