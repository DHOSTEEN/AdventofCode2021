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
public class LanternFishReader extends AdventInputReader{

public LanternFishReader(String file_path){
    super(file_path);
}
    public ArrayList<Integer> fish_inputList(){

        ArrayList<Integer> list = new ArrayList<>();
        String raw_list = obj_Reader.nextLine();
        String[] split_list = raw_list.split(",");
        for(String str : split_list){
            list.add(Integer.parseInt(str));
        }
        return list;
    }
}
