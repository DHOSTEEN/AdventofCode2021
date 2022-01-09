/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InputReaders;

import java.math.BigInteger;

/**
 *
 * @author Daniel
 */
public class PacketDecoderReader extends AdventInputReader{

public PacketDecoderReader(String file_path){
    super(file_path);

}

public String getFileHexTrans(){
    return getHexTrans(obj_Reader.nextLine());
}
    public String getHexTrans(String single_hex){
//possible issue in calling NEW constantly
    String hex = new BigInteger(single_hex, 16).toString(2);//takes String as number arg, uses a regex to transform into specifical decimal, ie HEX, etc... then returns as string with a given regex representation
    String append = "";
    while(!(hex.length() % 4 == 0)){

        hex = "0"+ hex;
    }
    return append + hex;
//return hex;
    }




    
}
