/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day16;

/**
 *
 * @author Kristóf Hoffmann - gitHub username: Sycix-HK -- ty so much!
 */
/**NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE --- NOT MY CODE
**/

import InputReaders.PacketDecoderReader;
import java.io.*;
import java.util.*;

public class CheatyMcCheaty 
{

    private static PacketDecoderReader obj_Reader;
    private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput16_data.txt";

    public static void main(String[] args) 
    {
        obj_Reader = new PacketDecoderReader(file_location);
        String input = obj_Reader.getFileHexTrans();
        long start = System.nanoTime();
        Message m = new Message("A059141803C0008447E897180401F82F1E60D80021D11A3DC3F300470015786935BED80A5DB5002F69B4298A60FE73BE41968F48080328D00427BCD339CC7F431253838CCEFF4A943803D251B924EC283F16D400C9CDB3180213D2D542EC01092D77381A98DA89801D241705C80180960E93469801400F0A6CEA7617318732B08C67DA48C27551C00F972830052800B08550A277416401A5C913D0043D2CD125AC4B1DB50E0802059552912E9676931530046C0141007E3D4698E20008744D89509677DBF5759F38CDC594401093FC67BACDCE66B3C87380553E7127B88ECACAD96D98F8AC9E570C015C00B8E4E33AD33632938CEB4CD8C67890C01083B800E5CBDAB2BDDF65814C01299D7E34842E85801224D52DF9824D52DF981C4630047401400042E144698B2200C4328731CA6F9CBCA5FBB798021259B7B3BBC912803879CD67F6F5F78BB9CD6A77D42F1223005B8037600042E25C158FE0008747E8F50B276116C9A2730046801F29BC854A6BF4C65F64EB58DF77C018009D640086C318870A0C01D88105A0B9803310E2045C8CF3F4E7D7880484D0040001098B51DA0980021F17A3047899585004E79CE4ABD503005E610271ED4018899234B64F64588C0129EEDFD2EFBA75E0084CC659AF3457317069A509B97FB3531003254D080557A00CC8401F8791DA13080391EA39C739EFEE5394920C01098C735D51B004A7A92F6A0953D497B504F200F2BC01792FE9D64BFA739584774847CE26006A801AC05DE180184053E280104049D10111CA006300E962005A801E2007B80182007200792E00420051E400EF980192DC8471E259245100967FF7E6F2CF25DBFA8593108D342939595454802D79550C0068A72F0DC52A7D68003E99C863D5BC7A411EA37C229A86EBBC0CB802B331FDBED13BAB92080310265296AFA1EDE8AA64A0C02C9D49966195609C0594223005B80152977996D69EE7BD9CE4C1803978A7392ACE71DA448914C527FFE140");
        long end = System.nanoTime();
        System.out.println("Sum of version numbers " + m.main.versionSum());
        System.out.println("TIME: " + (end - start)/1000000 + "ms");
        System.out.println("Value of outer packet" + m.main.getValue());

    }
}
class Message
{
    String hex;
    String bin;
    Cheaty_Packet main;
    public Message(String hexadecimal)
    {
        hex = hexadecimal;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hex.length(); i++)
        {
            sb.append(hexToBin(hex.charAt(i)));
        }
        bin = sb.toString();
        main = Cheaty_Packet.decode(bin);
    }

    private static String hexToBin(char h)
    {
        switch (h)
        {
            case '0': return "0000";
            case '1': return "0001";
            case '2': return "0010";
            case '3': return "0011";
            case '4': return "0100";
            case '5': return "0101";
            case '6': return "0110";
            case '7': return "0111";
            case '8': return "1000";
            case '9': return "1001";
            case 'A': return "1010";
            case 'B': return "1011";
            case 'C': return "1100";
            case 'D': return "1101";
            case 'E': return "1110";
            case 'F': return "1111";
            default: throw new IllegalArgumentException("What the elves doing");
        }
    }
}

class Cheaty_Packet
{
    int len;
    int version;
    public static Cheaty_Packet decode(String bin)
    {
        int version = Integer.parseInt(bin.substring(0,3),2);
        int typeID = Integer.parseInt(bin.substring(3,6),2);
        System.out.println("INPUT : " + bin);
        return typeID == 4 ? Literal.decode(version,bin) : Operator.decode(version,typeID,bin);
    }
    public int versionSum()
    {
        return version;
    }
    public long getValue()
    {
        return 0;
    }
}

class Literal extends Cheaty_Packet
{
    long value;
    public static Literal decode(int version, String bin)
    {
        System.out.println("Am literal");
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
    }
}

class Operator extends Cheaty_Packet
{
    int typeID;
    Cheaty_Packet[] packets;

    public static Operator decode(int version, int typeID, String bin)
    {
        //System.out.println("AM Operator");
        return bin.charAt(6) == '0' ? fifteenBit(version, typeID, bin) : elevenBit(version, typeID, bin);
    }
    public static Operator fifteenBit(int version, int typeID, String bin)
    {
        System.out.println("Knows how long it is");
        Operator outp = new Operator();
        outp.version = version;
        outp.typeID = typeID;
        List<Cheaty_Packet> packetlist = new ArrayList<>();

        int packetslen = Integer.parseInt(bin.substring(7,7+15),2);
        int packetcursor = 0;
        while (packetcursor < packetslen)
        {
            //System.out.println("Attempting 15bit: " + bin.substring(packetcursor+7+15));
            Cheaty_Packet p = Cheaty_Packet.decode(bin.substring(packetcursor+7+15));
            //System.out.println("p.len: " + p.len);
            packetcursor += p.len;
            packetlist.add(p);
        }

        outp.packets = packetlist.toArray(new Cheaty_Packet[0]);
        outp.len = 7 + 15 + packetslen;

        return outp;
    }

    public static Operator elevenBit(int version, int typeID, String bin)
    {
        System.out.println("Knows how many sub");
        Operator outp = new Operator();
        outp.version = version;
        outp.typeID = typeID;

        int packetcount = Integer.parseInt(bin.substring(7,7+11),2);
        int packetcursor = 0;
        outp.packets = new Cheaty_Packet[packetcount];
        for (int i = 0; i < packetcount; i++)
        {
            //System.out.println("11 bit starting pos: " + (packetcursor+7+11));
            //System.out.println("Attempting 11bit: " + bin.substring(packetcursor+7+11));
            outp.packets[i] = Cheaty_Packet.decode(bin.substring(packetcursor+7+11));
            packetcursor += outp.packets[i].len;
        }

        outp.len = 7 + 11 + packetcursor;
        
        return outp;
    }

    @Override
    public int versionSum()
    {
        int sum = 0;
        for (Cheaty_Packet packet : packets) {
            sum += packet.versionSum();
        }
        return sum + version;
    }

    @Override
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
    }
}
