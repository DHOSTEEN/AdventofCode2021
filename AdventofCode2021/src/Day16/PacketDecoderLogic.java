/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day16;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Daniel
 */
public class PacketDecoderLogic {

    private final int TYPE_ID_LENGTH = 3;//for use in futureproofing
    private final int VERSION_END = 3;
    private final int TYPE_ID_END = VERSION_END + TYPE_ID_LENGTH;//6
    private final int OPERATOR_MODE_BIT = TYPE_ID_END;
    private final int ZERO_OPERATOR_MODE_LENGTH = 15;
    private final int ONE_OPERATOR_MODE_LENGTH = 11;
    private final int BIT_LENGTH_START = TYPE_ID_END + 1;

    private final int LITERAL_PACKET_DESIGNATION = 4;

    private long version_sum;
    
    private long outer_sum;

    public long getVersion_sum() {
        return version_sum;
    }


    public PacketDecoderLogic(){
        version_sum = 0L;
        outer_sum = 0L;
    }

    public int readOperatorPacket(List<String> all_packets, int limit){
    //TYPE IDS CAN BE STORED IN HASHMAP if needed

    int version = Integer.parseInt(all_packets.subList(0, VERSION_END).stream().collect(Collectors.joining()), 2);
    int type_ID = Integer.parseInt(all_packets.subList(VERSION_END,TYPE_ID_END).stream().collect(Collectors.joining()),2);
    
    int num_bits_read =0;

    if(type_ID != LITERAL_PACKET_DESIGNATION){

        version_sum += version;
        //System.out.println("Version in Operator" + version);
        
        int sub_packets_length =0;
        
        if(all_packets.get(OPERATOR_MODE_BIT).equals("0")){
            sub_packets_length = ZERO_OPERATOR_MODE_LENGTH;
        }
        else{
            sub_packets_length = ONE_OPERATOR_MODE_LENGTH;
        }        
        String sub_packet_switch = all_packets.get(OPERATOR_MODE_BIT);
        int bit_length = Integer.parseInt(all_packets.subList(BIT_LENGTH_START, BIT_LENGTH_START + sub_packets_length).stream().collect(Collectors.joining()),2);
        
   // for(int i =0; i<num_of_sub_packets; i++){
        int starting_pos = BIT_LENGTH_START + sub_packets_length;
        if(sub_packet_switch.equals("0")){
            
            //System.out.println("Knows how long it is");
            while(num_bits_read != bit_length){
                //System.out.println("Attempting 15bit: " + all_packets.subList(starting_pos + num_bits_read, all_packets.size()).stream().collect(Collectors.joining()));
                num_bits_read += readOperatorPacket(all_packets.subList(starting_pos + num_bits_read, all_packets.size()), bit_length);
            }
            num_bits_read += BIT_LENGTH_START+sub_packets_length;//THIS-- Need to account for its own length
        }
        else{   
            
            int bit_counter =0;
            //System.out.println("Knows how many sub");
            for(int i =0; i<bit_length; i++){

                //System.out.println("Attempting 11bit: " + all_packets.subList(starting_pos, all_packets.size()).stream().collect(Collectors.joining()));
                bit_counter = readOperatorPacket(all_packets.subList(starting_pos, all_packets.size()), 0);
                starting_pos += (bit_counter );
                num_bits_read = starting_pos;
            }
        }        
    }//end of if ID != 4
    else{
        //System.out.println("literal sublist: " + all_packets.stream().collect(Collectors.joining()));
        num_bits_read += readLiteral(all_packets.subList(num_bits_read, all_packets.size()));      
    }
    //System.out.println("RETURN VAL: " + num_bits_read);
    return num_bits_read;
}
    public int readLiteral(List<String> literal_packet){

    int version = Integer.parseInt(literal_packet.subList(0, VERSION_END).stream().collect(Collectors.joining()), 2);
    version_sum+=version;
    //System.out.println("VERSION: " + version);

    char head = literal_packet.get(TYPE_ID_END).charAt(0);
    int pos = TYPE_ID_END;//ie zero if 
    pos++; //ignore head
    String actual_bit = "";
    boolean keep_parsing = true;
    int num_parsed = 0;
    
    while(keep_parsing){
        
        if(head == '0'){
           //keep_parsing = !keep_parsing; -- possible better because it doesnt require the check
            num_parsed = pos +4;
            break;
        }
        pos = pos +4;
        head = literal_packet.get(pos).charAt(0);
        pos++;
    }

    return num_parsed;
}

    private int notStream(List<String> list){
        String s = "";
        for(String str: list){
            s+= str;
        }
        return Integer.parseInt(s, 2);
    }

}

//11 bit
//00000000000000000101100001000101010110001011001000100000000010000100011000111000110100
//00000000000000000101100001000101010110001011001000100000000010000100011000111000110100

//15 bit
//0001000101010110001011001000100000000010000100011000111000110100
//0001000101010110001011001000100000000010000100011000111000110100

//15 bit
//10110001011001000100000000010000100011000111000110100
//10110001011001000100000000010000100011000111000110100


//11 bit
//001000100000000010000100011000111000110100
///0001000101010110001011001000100000000010000100011000111000110100