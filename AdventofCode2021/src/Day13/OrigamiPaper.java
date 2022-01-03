/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class OrigamiPaper {

private String[] paper_row;
private ArrayList<ArrayList<String>> orginal_paper;

    public OrigamiPaper(int col, int row){
        paper_row = new String [row];
        orginal_paper = new ArrayList<>();
Arrays.fill(paper_row, ".");
        for(int i =0; i<col; i++){
            //Arrays.fill(paper[i], ".");
           // for(int j =0; j<row; j++){paper_row[j] = i + "";}
            orginal_paper.add(new ArrayList<>(Arrays.asList(paper_row)));
        }

    }

    public void printPaper(){
        for(int i=0; i<orginal_paper.size(); i++){
            System.out.println(orginal_paper.get(i).toString());}
    }

    public void splitPaperOnY(int pos){
        List<ArrayList<String>> test = new ArrayList<>();
        test = orginal_paper.subList(pos + 1, orginal_paper.size());
        //for(int i =(pos +1); i<orginal_paper.size();i++){
            //System.out.println("HI" + i);
            combineRows(test, orginal_paper, pos);
            /*for(int j =0; j<orginal_paper.get(i).size(); j++){

            orginal_paper.get(i).set(j, (test.get(i-(pos +1)).get(j) + " - " + orginal_paper.get(i).get(j)));
           // orginal_paper.get(i)[j] = test.get(i-8)[j] + "-" + orginal_paper.get(i)[j];
            }*/
       // }
        ///System.out.println("BOOL" +orginal_paper.removeAll(test));
       // orginal_paper.remove(0);
    }
private void combineRows(List<ArrayList<String>> fold, ArrayList<ArrayList<String>> orginal, int lim){

    Collections.reverse(fold);

    for(int col = 0; col<fold.size();col++){
        for(int row =0; row<fold.get(col).size(); row++){
            if(fold.get(col).get(row).equals("#")){
                orginal.get(col).set(row, "#");
            }
        //orginal_paper.get(i).set(j, (fold.get(i).get(j) + " - " + orginal_paper.get(i).get(j)));
       // orginal_paper.get(i)[j] = test.get(i-8)[j] + "-" + orginal_paper.get(i)[j];
        }
    }
    for(int i =lim; i<orginal.size(); i++){orginal.remove(i); i--;}
}
    public void splitPaperOnX(int pos){
// need to split inner arr in half, add both halves, remove one
        List<String> line = new ArrayList();
        for(int i =0; i<orginal_paper.size();i++){
            line = orginal_paper.get(i).subList(pos, orginal_paper.get(i).size());
            combineLines(line,orginal_paper.get(i), pos);
            //removeDuplicates(orginal_paper.get(i), line);

        }
    }
    private void combineLines(List<String> fold, ArrayList<String> orginal, int lim){

        //System.out.println("fold: " + fold.toString());
        Collections.reverse(fold);
        for(int i =0; i<fold.size(); i++){

            if(fold.get(i).equals("#")){
                orginal.set(i, "#");
            }
            //orginal.set(i, (fold.get(i) + " - " + orginal.get(i)) + "WIBS");
        }
        for(int i =lim; i<orginal.size(); i++){
            orginal.remove(i);
        i--;}
    }
    public void add(int col, int row){
        orginal_paper.get(col).set(row, "#");
    }

    public int countPoints(){
        int count =0;
        for(ArrayList<String> list : orginal_paper){
            for(String str : list){
                if(str.equals("#")){
                    count++;
                }
            }
        }
        return count;
    }
}
