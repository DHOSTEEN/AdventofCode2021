/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day4;

/**
 *
 * @author Daniel
 */
public class PairBoolString {

    private boolean is_marked;
    private String num;

    public PairBoolString(String num){
        this.num = num;
        is_marked = false;
    }

    public String getNum(){return num;}
    public boolean isMarked(){return is_marked;}
    public void setMarked(){is_marked = true;}

    
}
