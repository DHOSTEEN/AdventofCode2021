/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package day17;

/**
 *
 * @author Daniel
 */
public class TrickShotMain {
    
public static void main(String[] args){

//target area: x=20..30, y=-10..-5
//target area: x=185..221, y=-122..-74

   Probe probe = new Probe(185, 221, -122, -74);
   // Probe probe = new Probe(20,30,-10,-5);
    //System.out.println("end: " + probe.step(6, 0));
    System.out.println(probe.higestStep());
    System.out.println("all:" + probe.getAll_success().size());
}
}
