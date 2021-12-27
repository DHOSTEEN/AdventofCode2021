/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day4;

/**
 *
 * @author Daniel
 */
public class UnwinningBoard extends BingoBoard{

    private boolean has_won;

    public UnwinningBoard(){
        super();
        has_won = false;
    }

    public boolean isHas_won() {
        return has_won;
    }

    public void setHas_won(boolean has_won) {
        this.has_won = has_won;
    }


}
