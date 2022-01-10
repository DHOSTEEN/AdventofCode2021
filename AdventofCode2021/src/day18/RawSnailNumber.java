/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day18;

/**
 *
 * @author Daniel
 */
public class RawSnailNumber {

    public String getRaw_number() {
        return raw_number;
    }

    public int getStart_pos() {
        return start_pos;
    }

    public int getEnd_pos() {
        return end_pos;
    }

private final String raw_number;
private final int start_pos;
private final int end_pos;

public RawSnailNumber(String raw_number, int start_pos, int end_pos){

    this.raw_number = raw_number;
    this.start_pos = start_pos;
    this.end_pos = end_pos;
}
    
}
