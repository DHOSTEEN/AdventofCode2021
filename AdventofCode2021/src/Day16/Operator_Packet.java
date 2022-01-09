/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day16;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */


public class Operator_Packet extends Packet{

    public Packet[] getPackets() {
        return packets;
    }

    public void setPackets(Packet[] packets) {
        this.packets = packets;
    }

    private Packet[] packets;

    public Operator_Packet(int version, int type_ID){
        super(version, type_ID);
    }

    public static Operator_Packet decode(String packet, int version, int type_ID){
        char mode = packet.charAt(OPERATOR_MODE_BIT);
        return packet.charAt(6) == '0' ? fifteen_Bit(packet, version, type_ID) : eleven_bit(packet, version, type_ID);
    }
    public static Operator_Packet fifteen_Bit(String packet, int version, int type_ID){

        //System.out.println("Knows how long it is");
        int bit_length = Integer.parseInt(packet.substring(BIT_LENGTH_START, BIT_LENGTH_START + ZERO_OPERATOR_MODE_LENGTH),2);
        int start_pos = BIT_LENGTH_START + ZERO_OPERATOR_MODE_LENGTH;
        int num_parsed = 0;
        Operator_Packet op_packet = new Operator_Packet(version, type_ID);
        ArrayList<Packet> all_sub = new ArrayList<>();
        while(num_parsed < bit_length){

            Packet sub_packet =  Packet.decode(packet.substring(num_parsed + start_pos));
            num_parsed+=sub_packet.getBits_parsed();
            all_sub.add(sub_packet);
        }

        op_packet.setBits_parsed(bit_length + ZERO_OPERATOR_MODE_LENGTH + BIT_LENGTH_START);
        op_packet.setPackets(all_sub.toArray(new Packet[0]));
        return op_packet;
    }

    public static Operator_Packet eleven_bit(String packet, int version, int type_ID){

        //System.out.println("Knows how mnay sub");
        int num_packets = Integer.parseInt(packet.substring(BIT_LENGTH_START, BIT_LENGTH_START + ONE_OPERATOR_MODE_LENGTH),2);
        int start_pos = BIT_LENGTH_START + ONE_OPERATOR_MODE_LENGTH;
        int num_parsed =0;
        Operator_Packet op_packet = new Operator_Packet(version, type_ID);
        op_packet.setPackets(new Packet[num_packets]);

        for(int i =0; i<num_packets; i++){
            op_packet.getPackets()[i] = Packet.decode(packet.substring(num_parsed + 7 + 11));
            num_parsed += op_packet.getPackets()[i].getBits_parsed();
        }
        op_packet.setBits_parsed(num_parsed + BIT_LENGTH_START + ONE_OPERATOR_MODE_LENGTH);
        return op_packet;
    }

    public int versionSum()
    {
        int sum = 0;
        for (Packet packet : packets) {
            sum += packet.versionSum();
        }
        return sum + version;
    }
@Override
public long getValue(){
long val = 0L;
    switch(type_ID){
        case 0:
 
            for(Packet packet : packets){
                val += packet.getValue();
            }
        break;
        case 1:
        val = 1L;
            for(Packet packet: packets){
                val *= packet.getValue();
            }
        break;
        case 2:
            long min = Long.MAX_VALUE;
            for(Packet packet : packets){
                if(packet.getValue()<min){
                    min = packet.getValue();
                }
            }
            val = min;
        break;
        case 3:
            long max = Long.MIN_VALUE;
            for(Packet packet : packets){
                if(packet.getValue()>max){
                    max = packet.getValue();
                }
            }
            val = max;
        break;
        case 4:
            val = getValue();
        break;
        case 5:
            val = (packets[0].getValue() > packets[1].getValue()) ? 1L : 0L;
        break;
        case 6:
            val = (packets[0].getValue() < packets[1].getValue()) ? 1L : 0L;
        break;
        case 7:
            val = (packets[0].getValue() == packets[1].getValue()) ? 1L : 0L;
        break;

    }
return val;
}

/* @Override
    public long getValue()
    {
        switch (typeID)
        {
            case 0: // sum packet
                long sum = 0;
                for (Cheaty_Packet packet : packets) {
                    sum += packet.getValue();
                }
                return sum;

            case 1: // product packet
                long prod = 1;
                for (Cheaty_Packet packet : packets) {
                    prod *= packet.getValue();
                }
                return prod;

            case 2: // minimum packet
                long minval = packets[0].getValue();
                int minidx = 0;
                for (int i = 1; i < packets.length; i++) {
                    long curval = packets[i].getValue();
                    if (curval < minval) {
                        minval = curval;
                        minidx = i;
                    }
                }
                return packets[minidx].getValue();

            case 3: // maximum packet
                long maxval = packets[0].getValue();
                int maxidx = 0;
                for (int i = 1; i < packets.length; i++) {
                    long curval = packets[i].getValue();
                    if (curval > maxval) {
                        maxval = curval;
                        maxidx = i;
                    }
                }
                return packets[maxidx].getValue();

            case 5: // greater than packet
                return packets[0].getValue() > packets[1].getValue() ? 1:0;

            case 6: // less than packet
                return packets[0].getValue() < packets[1].getValue() ? 1:0;

            case 7: // equal to packet
                return packets[0].getValue() == packets[1].getValue() ? 1:0;

            default: throw new IllegalArgumentException("What the packet doing");
        }
    }*/
}