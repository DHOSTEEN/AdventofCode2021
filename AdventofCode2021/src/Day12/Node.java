/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day12;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Node <T> {

    public T getElement() {
        return element;
    }

    public Node getParent() {
        return parent;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }
    
    private T element;
    private Node parent;
    private ArrayList<Node> children;

    public Node(T element){
        this.element = element;
        children = new ArrayList<>();
    }
    public void addChild(Node node){

        children.add(node);
    }
    public void setParent(Node node){
        parent = node;
    }

}
