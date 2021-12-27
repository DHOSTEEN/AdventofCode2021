/*
 * Click nbfs://nbhost///SystemFile//System/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost///SystemFile//System/Templates/Classes/Class.java to edit this template
 */
package Day5;

/**
 *
 * @author Daniel
 */
public class DiagramLogic {

private String[][] diagram;
private Diagram big_D;

    public DiagramLogic(Diagram diagram) {
        big_D = diagram;
        this.diagram = diagram.getDiagram();
    }

    
    public boolean is_Not_dia(Coodinates coords){
        return coords.getBegin().getX_val() == coords.getEnd().getX_val() || coords.getBegin().getY_val() == coords.getEnd().getY_val();
    }

    public void markLine(Coodinates coords){

        if(is_X_axis(coords)){
            int y = coords.getBegin().getY_val();
            //System.out.println("I R y: " + y);
            if(y<=coords.getEnd().getY_val()){
                while(y <= coords.getEnd().getY_val()){
                    diagram[y][coords.getBegin().getX_val()] = increment(y, coords.getBegin().getX_val());
                    y++;
                ;}
            }
            else{
                while(y>= coords.getEnd().getY_val()){
                    diagram[y][coords.getBegin().getX_val()] = increment(y, coords.getBegin().getX_val());
                    y--;
                }
            }
        }
        else{
            int x = coords.getBegin().getX_val();
            //System.out.println("I R x: " + x);
            //System.out.println("I am: " + (x<=coords.getEnd().getX_val()) + " end x is: " + coords.getEnd().getX_val());
            if(x<=coords.getEnd().getX_val()){
                while(x<=coords.getEnd().getX_val()){
                    diagram[coords.getBegin().getY_val()][x] = increment(coords.getBegin().getY_val(), x);
                    x++;
                }
            }   
            else{
                while(x>=coords.getEnd().getX_val()){
                    diagram[coords.getBegin().getY_val()][x] = increment(coords.getBegin().getY_val(), x);
                    x--;
                }
                   
            }        
        }
    }

    public void markDiagonalLine(Coodinates coords){
        boolean is_done = false;
        int x =0;
        int y =0;

        y = coords.getBegin().getY_val();
        x = coords.getBegin().getX_val();
        if(is_up(coords)){

            if(is_forward(coords)){
                //y--, x++
                while(y>=coords.getEnd().getY_val()){
                    diagram[y][x] = increment(y, x);
                    y--;
                    x++;
                }
            }
            else{
                //y--, x--
                while(y>=coords.getEnd().getY_val()){
                diagram[y][x] = increment(y, x);
                y--;
                x--;
                }
            }
        }
        else{
            if(is_forward(coords)){
                //y++, x++
                while(y<=coords.getEnd().getY_val()){
                    diagram[y][x] = increment(y, x);
                    y++;
                    x++;
                }   
            }
            else{
                //y++, x--;
                while(y<=coords.getEnd().getY_val()){
                    diagram[y][x] = increment(y, x);
                    y++;
                    x--;
                }
            }
            
        }
}//end of markDiagonalLine
    private boolean is_up(Coodinates coords){
        return coords.getBegin().getY_val()>=coords.getEnd().getY_val();
    }
    private boolean is_forward(Coodinates coords){
        return  coords.getBegin().getX_val()<=coords.getEnd().getX_val();
    }
    private boolean is_X_axis(Coodinates coords){
        return coords.getBegin().getX_val() == coords.getEnd().getX_val();
    }

    private String increment(int y, int x){
        String str = "";
        int val = 0;
        if(diagram[y][x].equals(".")){str = "1";}
        else{
            val = Integer.parseInt(diagram[y][x]);
            val++;
            str = "" + val;
        }
        //System.out.println("String is: " + str + "coords: " + x + "," + y);
        ////System.out.println(big_D.printDia());
        return str;
    }
}
