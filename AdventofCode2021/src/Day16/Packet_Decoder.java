/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day16;

/**
 *
 * @author Daniel
 */
public class Packet_Decoder {

private Packet root;

public void decode(String all_packet){


    root = Packet.decode(all_packet);
    System.out.println(root instanceof Operator_Packet);
    System.out.println("IS: " + root.versionSum());
    System.out.println("part 2:  " + root.getValue());
    //root = type_ID == 4 ? new 

}
    
}
