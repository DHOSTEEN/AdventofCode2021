/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day12;

import java.util.ArrayList;
import java.util.Random;

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

private final Long id;

    public Node(T element){
        this.element = element;
        children = new ArrayList<>();
        Random random = new Random();
        id = random.nextLong();
    }
    public void addChild(Node node){

        children.add(node);
    }
    public void setParent(Node node){
        parent = node;
    }
  
//custom contains
        @Override
        public String toString() {
                return "Node [Id=" + id  +"]";
        }
 
        @Override
        public int hashCode() {
            int hash = 7;
            hash = 17 * hash + (this.id != null ? this.id.hashCode() : 0);
            return hash;
        }
 
        @Override
        public boolean equals(Object obj) {
            boolean retVal = false;
            if (obj instanceof Node){
                Node ptr = (Node)obj;
                retVal = ptr.id.longValue() == this.id;
            }
            return retVal;
        }
}
