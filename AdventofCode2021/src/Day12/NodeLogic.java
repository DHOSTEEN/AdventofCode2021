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
    private ArrayList<String> paths;
    ArrayList<Node> nodes;

public Node getTree(){return root;}

    public NodeLogic(Node root){
        this.root = root;
        paths = new ArrayList<>();
        nodes = new ArrayList<>();
        nodes.add(root);
        nodes.add((Node)root.getChildren().get(0));
    }

    public void add(String parent, String child){
    
        TuppleNodeBoolean parent_tupple = searchArrayNodes(parent);
        TuppleNodeBoolean child_tupple= searchArrayNodes(child);
        if(parent_tupple.is_true() && !child_tupple.is_true()){
            System.out.println("TUPPLE: " + parent_tupple.getNode().getElement() + " ID: " + parent_tupple.getNode().toString());
            Node node = new Node(child);
            parent_tupple.getNode().addChild(node);
            node.setParent(parent_tupple.getNode());
            node.addChild(parent_tupple.getNode());
            nodes.add(node);

        }
        else if(parent_tupple.is_true() && child_tupple.is_true()){
            System.out.println("REPEATED TUPPLE: ");
            System.out.println("TUPPLE: " + parent_tupple.getNode().getElement() + " ID: " + parent_tupple.getNode().toString());
            System.out.println("LOW TUPPLE: " + child_tupple.getNode().getElement() + " ID: " + child_tupple.getNode().toString());
            System.out.println("END REPEATED");
            parent_tupple.getNode().addChild(child_tupple.getNode());
            child_tupple.getNode().setParent(parent_tupple.getNode());

            parent_tupple.getNode().setParent(child_tupple.getNode());
            child_tupple.getNode().addChild(parent_tupple.getNode());
        }//repeat
        else if(!parent_tupple.is_true() && child_tupple.is_true()){
            System.out.println("LOW TUPPLE: " + child_tupple.getNode().getElement() + " ID: " + child_tupple.getNode().toString());
            Node node = new Node(parent);
            //root.addChild(node);
            node.addChild(child_tupple.getNode());
            child_tupple.getNode().setParent(node);
            child_tupple.getNode().addChild(node);
            nodes.add(node);
        }
        else{
            Node node = new Node(parent);
            root.addChild(node);
            nodes.add(node);

            Node child_node = new Node(child);
            node.addChild(child_node);
            nodes.add(child_node);

        }
    }
//iterate child, if lower repeat, FAIL, if end 1= END FAIL
    public ArrayList<String> buildPaths(){
        String append = "-";
        pathBuilder("", root, new ArrayList<>(), true);
        return paths;
    }
    private void pathBuilder(String path, Node node, ArrayList<String> duplicates, boolean is_start){

        path += " " + node.getElement();
       // for(int i =0; i<duplicates.size();i++){System.out.println(duplicates.get(i));}
        if(node.getElement().equals("end")){
            //success
if(!paths.contains(path)){
            paths.add(path);
}
            return;
        }
        
        String node_elem = (String)node.getElement();
        if(duplicates.contains(node_elem) || (node_elem.equals("start") && !is_start)){
            System.out.println("duplicate: " + node_elem);
            System.out.println("On path: " + path);
            System.out.println(duplicates.toString());
            return;
        }
    
        String str = (String)node.getElement();
        if(Character.isLowerCase(str.toCharArray()[0]) && !str.equals("start")){
            duplicates.add((String)node.getElement());
        }
        if(node.getParent()!=null){
            if(!node.getParent().getElement().equals("start")){
                pathBuilder(path, node.getParent(), copy(duplicates), false);
            }
        }
        for(int i =0; i<node.getChildren().size(); i++){
            pathBuilder(path, (Node)node.getChildren().get(i), copy(duplicates), false);
            
        }    
//TUPPLE: dc ID: Node [Id=-724128201044487329]
//TUPPLE: dc ID: Node [Id=-724128201044487329]
    }
private ArrayList<String> copy(ArrayList<String> list){
        ArrayList<String> new_list = new ArrayList<>();
        for(int i =0;i<list.size();i++){new_list.add(list.get(i));}
        return new_list;
}
           
private TuppleNodeBoolean searchArrayNodes(String target){

    TuppleNodeBoolean node = new TuppleNodeBoolean(false, null);
    System.out.println("TARGET: " + target);
    for(int i =0; i< nodes.size(); i++){
        String test = (String)nodes.get(i).getElement();
        if(test.equals(target)){
            System.out.println("TEST: " + test);
            node = new TuppleNodeBoolean(true, nodes.get(i));
        }
    }

   // System.out.println("END SEARCH");
   /*
    boolean found = false;
    int i =0;
while(!found && i<nodes.size()){
      
        String test = (String)nodes.get(i).getElement();
        System.out.println("IN SEARCH: " + target + " - " + test);
        found = target.equals(test);
        if(found){
                node = new TuppleNodeBoolean(true, nodes.get(i));
        }
        i++;
    }*/
    
    return node;
}

    private TuppleNodeBoolean searchNodes(String target, Node node){


        if(target.equals((String)node.getElement())){
            return new TuppleNodeBoolean(true, node);
        }
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
