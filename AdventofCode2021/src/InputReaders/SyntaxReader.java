/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InputReaders;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class SyntaxReader extends AdventInputReader{

    ArrayList<String[]> all_lines;

    public SyntaxReader(String file_path){
        super(file_path);
        all_lines = new ArrayList<>();
    }

public String[] getLine(){

    return obj_Reader.nextLine().split("");
}
    public ArrayList<String[]> getAllLines(){
        while(obj_Reader.hasNext()){
            all_lines.add(getLine());
        }
        return all_lines;
    }
}
