/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day12;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Daniel
 */
public class NodeLogic {

     private Node root;
    private ArrayList<TuppleBooleanString> paths;

public Node getTree(){return root;}

    public NodeLogic(Node root){
        this.root = root;
        paths = new ArrayList<>();
    }

    public void add(String parent, String child){
    
        TuppleNodeBoolean parent_tupple = searchNodes(parent, root);
        TuppleNodeBoolean child_tupple= searchNodes(child, root);
        if(parent_tupple.is_true() && !child_tupple.is_true()){
            System.out.println("TUPPLE: " + parent_tupple.getNode().getElement() + " ID: " + parent_tupple.getNode().toString());
            Node node = new Node(child);
            parent_tupple.getNode().addChild(node);
            node.setParent(parent_tupple.getNode());

        }
        else if(parent_tupple.is_true() && child_tupple.is_true()){
            System.out.println("REPEATED TUPPLE: ");
            System.out.println("TUPPLE: " + parent_tupple.getNode().getElement() + " ID: " + parent_tupple.getNode().toString());
            System.out.println("LOW TUPPLE: " + child_tupple.getNode().getElement() + " ID: " + child_tupple.getNode().toString());
            System.out.println("END REPEATED");
            parent_tupple.getNode().addChild(child_tupple.getNode());
            child_tupple.getNode().setParent(parent_tupple.getNode());
        }//repeat
        else if(!parent_tupple.is_true() && child_tupple.is_true()){
            System.out.println("LOW TUPPLE: " + child_tupple.getNode().getElement() + " ID: " + child_tupple.getNode().toString());
            Node node = new Node(parent);
            root.addChild(node);
            node.addChild(child_tupple.getNode());
            child_tupple.getNode().setParent(node);
        }
        else{
            Node node = new Node(parent);
            root.addChild(node);
            node.addChild(new Node(child));
        }
    }
//iterate child, if lower repeat, FAIL, if end 1= END FAIL
    public ArrayList<TuppleBooleanString> buildPaths(){
        String append = "-";
        pathBuilder("", root, new ArrayList<>());
        return paths;
    }
    private void pathBuilder(String path, Node node, ArrayList<String> duplicates){

        path += " " + node.getElement();
       // for(int i =0; i<duplicates.size();i++){System.out.println(duplicates.get(i));}
        if(node.getElement().equals("end")){
            //success
            paths.add(new TuppleBooleanString(true, path));
            return;
        }
        
        String node_elem = (String)node.getElement();
        if(duplicates.contains(node_elem)){
            System.out.println("duplicate: " + node_elem);
            System.out.println("On path: " + path);
            System.out.println(duplicates.toString());
            return;
        }
    
        String str = (String)node.getElement();
        if(Character.isLowerCase(str.toCharArray()[0]) && !str.equals("start")){
            duplicates.add((String)node.getElement());
        }
        if(node.getParent()!=null){pathBuilder(path, node.getParent(), copy(duplicates));}
        for(int i =0; i<node.getChildren().size(); i++){
            pathBuilder(path, (Node)node.getChildren().get(i), copy(duplicates));
            
        }    

    }
private ArrayList<String> copy(ArrayList<String> list){
        ArrayList<String> new_list = new ArrayList<>();
        for(int i =0;i<list.size();i++){new_list.add(list.get(i));}
        return new_list;
}
           

    private TuppleNodeBoolean searchNodes(String target, Node node){


        if(target.equals((String)node.getElement())){
            return new TuppleNodeBoolean(true, node);
        }
        if("end".equals((String)node.getElement())){return new TuppleNodeBoolean(false, node);}
        if("start".equals((String)node.getElement())){return new TuppleNodeBoolean(false, node);}
        TuppleNodeBoolean tupple = new TuppleNodeBoolean(false, null);
        int i =0;
        boolean found = false;

        while(!found && i<node.getChildren().size()){
            tupple = searchNodes(target, (Node)node.getChildren().get(i));
            found = tupple.is_true();
            i++;
        }

        return tupple;
    }
    public String printTree(){
        String str = "-";
        str = treeStringBuilder(str, root);
        return str;
    }
    private String treeStringBuilder(String append, Node node){
        String str = "\n" +append + "Node: " + node.getElement() + " ID" + node.toString();

        for(int i =0; i<node.getChildren().size(); i++){
            str += treeStringBuilder(append + append, (Node)node.getChildren().get(i));
        }
  
        return str;
    }

    

}
