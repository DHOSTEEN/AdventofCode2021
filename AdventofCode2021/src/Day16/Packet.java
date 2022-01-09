/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day16;

/**
 *
 * @author Daniel
 */
public class Packet {

    protected static final int BIT_SIZE = 4;
    protected static final int TYPE_ID_LENGTH = 3;//for use in futureproofing
    protected static final int VERSION_END = 3;
    protected static final int TYPE_ID_END = VERSION_END + TYPE_ID_LENGTH;//6
    protected static final int OPERATOR_MODE_BIT = TYPE_ID_END;
    protected static final int ZERO_OPERATOR_MODE_LENGTH = 15;
    protected static final int ONE_OPERATOR_MODE_LENGTH = 11;
    protected static final int BIT_LENGTH_START = TYPE_ID_END + 1;

    protected int version;
    protected int type_ID;
    protected long packet_val;

public int getTypeID(){return type_ID;}

    public int getBits_parsed() {
        return bits_parsed;
    }

    public void setBits_parsed(int bits_parsed) {
        this.bits_parsed = bits_parsed;
    }
    protected int bits_parsed;

    public Packet(int version, int type_ID){

        this.version = version;
        this.type_ID = type_ID;

    }

    public static Packet decode(String packet){

        int version = Integer.parseInt(packet.substring(0,VERSION_END),2);
        int type_ID = Integer.parseInt(packet.substring(VERSION_END, TYPE_ID_END),2);
  
    //return typeID == 4 ? Literal.decode(version,bin) : Operator.decode(version,typeID,bin);
        return type_ID == 4 ? Literal_Packet.decode(packet, version, type_ID) : Operator_Packet.decode(packet, version, type_ID);
    }

public int versionSum(){return version;}
public long getValue(){return 0L;}

/*int len;
    int version;
    public static Cheaty_Packet decode(String bin)
    {
        int version = Integer.parseInt(bin.substring(0,3),2);
        int typeID = Integer.parseInt(bin.substring(3,6),2);
        return typeID == 4 ? Literal.decode(version,bin) : Operator.decode(version,typeID,bin);
    }
    public int versionSum()
    {
        return version;
    }
    public long getValue()
    {
        return 0;
    }*/

}

    
