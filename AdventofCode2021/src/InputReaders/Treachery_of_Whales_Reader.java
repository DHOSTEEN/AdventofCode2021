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
public class Treachery_of_Whales_Reader extends AdventInputReader{

    public Treachery_of_Whales_Reader(String file_path){
        super(file_path);
    }

    public ArrayList<Integer> integerList(){

        ArrayList<Integer> list = new ArrayList<>();
        String[] str_ar = obj_Reader.nextLine().split(",");
        for(int i =0; i< str_ar.length;i++){
            list.add(Integer.parseInt(str_ar[i]));
        }
        return list;
    }

}
