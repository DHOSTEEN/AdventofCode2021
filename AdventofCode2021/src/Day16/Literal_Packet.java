/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day16;

/**
 *
 * @author Daniel
 */
public class Literal_Packet extends Packet{

@Override
    public long getValue() {
        return packet_val;
    }

    public void setPacket_val(long packet_val) {
        this.packet_val = packet_val;
    }

private int num_parsed;

    public Literal_Packet(int version, int type_ID){
        super(version, type_ID);
        packet_val = 0;
        num_parsed = 0;
    }

    public static Literal_Packet decode(String bits, int version, int type_ID){

        int num_parsed =0;
        long val =0;
        int pos = TYPE_ID_END;
        StringBuilder parsed_bit = new StringBuilder();

        while(bits.charAt(pos) != '0'){
            parsed_bit.append(bits.substring(pos +1 , pos + BIT_SIZE +1));
            pos += BIT_SIZE + 1;
        }
        parsed_bit.append(bits.substring(pos + 1, pos + BIT_SIZE + 1));
        val = Long.parseLong(parsed_bit.toString(), 2);

        num_parsed = TYPE_ID_END + pos -1;

        Literal_Packet lit = new Literal_Packet(version, type_ID);
        lit.setBits_parsed(num_parsed);
        lit.setPacket_val(val);
        return lit;

    }
/*long value;
    public static Literal decode(int version, String bin)
    {
        //System.out.println("Am literal");
        Literal outp = new Literal();
        outp.version = version;
        
        StringBuilder builder = new StringBuilder();
        int i = 6;
        while (bin.charAt(i) == '1')
        {
            builder.append(bin.substring(i+1,i+5));
            i+=5;
        }
        builder.append(bin.substring(i+1,i+5));
        outp.value = Long.parseLong(builder.toString(),2);

        outp.len = 6 + i-1;

        return outp; 
    }
    @Override
    public long getValue()
    {
        return value;
    }*/
}