/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day5;

import com.sun.org.apache.xerces.internal.parsers.IntegratedParserConfiguration;

/**
 *
 * @author Daniel
 */
public class Coodinates {

    public Begin_End_Coordinates getBegin() {
        return begin;
    }

    public Begin_End_Coordinates getEnd() {
        return end;
    }

private final Begin_End_Coordinates begin;
private final Begin_End_Coordinates end;

    public Coodinates(String first, String second){

        String[] first_raw = first.split(",");
        String[] second_raw = second.split(",");
        begin = new Begin_End_Coordinates(Integer.parseInt(first_raw[0]),Integer.parseInt(first_raw[1]));
        end = new Begin_End_Coordinates(Integer.parseInt(second_raw[0]), Integer.parseInt(second_raw[1]));

    }

    public class Begin_End_Coordinates{

        public int getX_val() {
            return x_val;
        }

        public int getY_val() {
            return y_val;
        }

        private final int x_val;
        private final int y_val;

        private Begin_End_Coordinates(int x_val, int y_val){

            this.x_val = x_val;
            this.y_val = y_val;
        }

    }//end private class
}//end main class
