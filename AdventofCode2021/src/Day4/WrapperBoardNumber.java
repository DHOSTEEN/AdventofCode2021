/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day4;

/**
 *
 * @author Daniel
 */
public class WrapperBoardNumber {

    public BingoBoard getWinning_board() {
        return winning_board;
    }

    public int getWinning_number() {
        return winning_number;
    }

private int winning_number;
private BingoBoard winning_board;

public WrapperBoardNumber(int winning_number, BingoBoard winning_board){
    this.winning_number = winning_number;
    this.winning_board = winning_board;
}
    
}
