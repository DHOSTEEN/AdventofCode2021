/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day9;

/**
 *
 * @author Daniel
 */
public class LastNinePos {

    private int col;
    private int row;

    public LastNinePos(int col, int row){
        this.col=col;
        this.row = row;
    }
}
//cycle through


/*
1   1   |   |   |   2   2   2   2   2
1   |   b   b   b   |   2   |   2   2
|   b   b   b   b   b   |   c   |   2
b   b   b   b   b   |   b   b   b   |
|   b   |   |   |   b   b   b   b   b

//tree?
a   b   |   |   |   a   b   c   d   e
b   |   a   b   c   |   c   |   e   f
|   c   b   c   d   e   |   c   |   2
e   d   c   d   e   |   b   b   b   |
|   e   |   |   |   b   b   b   b   b
*/
