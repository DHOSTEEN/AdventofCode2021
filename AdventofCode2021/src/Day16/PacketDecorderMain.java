/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day16;

import InputReaders.PacketDecoderReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class PacketDecorderMain {

    //LEARNING! substring is efficent! dont need to use arr

    private static PacketDecoderReader obj_Reader;
    private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput16_data.txt";
    public static void main(String[] args){
        
        obj_Reader = new PacketDecoderReader(file_location);
        String literal = obj_Reader.getFileHexTrans();
        long start = System.nanoTime();
        //String literal = obj_Reader.getHexTrans("A0016C880162017C3686B18A3D4780");
        
        List<String> list = Arrays.asList(literal.split(""));
        PacketDecoderLogic logic = new PacketDecoderLogic();
        //logic.readOperatorPacket(list, 0);
        long end = System.nanoTime();
        System.out.println("SUM: " + logic.getVersion_sum());
        System.out.println("TIME: " + (end - start)/1000000 + "ms");
        Packet_Decoder decoder = new Packet_Decoder();
        decoder.decode(literal);

    }
}
//D2FE28 - success
//38006F45291200 - success
//EE00D40C823060 - success
//620080001611562C8802118E34 - success(sum 12)
//C0015000016115A2E0802F182340 success (sum 23)
//8A004A801A8002F478 - success (sum 16)
//A0016C880162017C3686B18A3D4780 - success (sum 31)
//110100101111111000101000
//110100101111111000101000

//01100010000000010111110000110110100001101011000110001010001111010100011110000000
//01100010000000010111110000110110100001101011000110001010001111010100011110000000

//11110000110110100001101011000110001010001111010100011110000000
//11110000110110100001101011000110001010001111010100011110000000

//11110000110110100001101011000110001010001111010100011110000000
//11110000110110100001101011000110001010001111010100011110000000

//010100011110000000
//010100011110000000

//470949537659
//470949537659