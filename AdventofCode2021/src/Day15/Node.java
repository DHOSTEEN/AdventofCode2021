/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day15;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Node {
 

    private Long cost;
    private long f;
    private ArrayList<Node> path;
    private int col;
    private int row;
    private Node parent;

    public Node(Long cost, int col, int row){
        this.cost = cost;
        this.col = col;
        this.row = row;
        this.f = 0;
    }
    public Node(Long cost, int col, int row, Node parent){
        this.cost = cost;
        this.col = col;
        this.row = row;
        this.parent = parent;
    }

    public Long getCost(){return cost;}
    public void setF(Long f){this.f = f;}
    public Long getF(){return f;}
    public int getCol(){return col;}
    public int getRow(){return row;}
    public void addPath(Node node){path.add(node);}
public Node getParent(){return parent;}
}
