/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InputReaders;

/**
 *
 * @author Daniel
 */
public class Seven_Segment_Search_Reader extends AdventInputReader{

    public Seven_Segment_Search_Reader(String file_path){
        super(file_path);
    }

    public String[] patternAndOutput(){

       return obj_Reader.nextLine().split("\\|");
    }
    
}
