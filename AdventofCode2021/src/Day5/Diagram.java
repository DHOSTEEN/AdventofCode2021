/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day5;

/**
 *
 * @author Daniel
 */
public class Diagram{

    public String[][] getDiagram() {
        return diagram;
    }
    
    private String[][] diagram;

    public Diagram(int ARR_SIZE){

        diagram = new String[ARR_SIZE][ARR_SIZE];
        initDia();
    }

    private void initDia(){

        for(int i =0; i<diagram.length; i++){
            for(int j=0; j< diagram[i].length; j++){
                diagram[i][j] = ".";
            }
        }   
        /*for(String[] str_ar : diagram){
            for(String str : str_ar){
                str = "."  ;
            }
        }IS CONSTRUCTIVE */
    }
    public String printDia(){
        String str = "";
        for(String[] str_ar : diagram){
            for(String dia : str_ar){
                str += dia  ;
            }
str += "\n";
        }
        return str;
    }
    public int countOverlap(){
        int count =0;
        for(String[] str_ar: diagram){
            for(String str: str_ar){
                if(overlapCheck(str)){
                    count++;
                }
            }
        }
        return count;
    }
    private boolean overlapCheck(String str){
        if(str.equals(".")){return false;}
        if(str.equals("1")){return false;}
        return true;
    }
}
