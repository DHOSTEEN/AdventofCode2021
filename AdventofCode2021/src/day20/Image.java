package day20;

import java.util.ArrayList;


public class Image {
	
	private ArrayList<String> infinate_image_view;
	private ArrayList<String> image_step;
	private final String image_enhancement_algorithm;
	private String blank_line;
	
	private boolean up_lim;
	private boolean down_lim;
	private boolean left_lim;
	private boolean right_lim;
	
	public ArrayList<String> getView(){return infinate_image_view;}
	
	public Image(String  image_enhancement_algorithm, ArrayList<String> infinate_image_view) {
	
		this.image_enhancement_algorithm = image_enhancement_algorithm;
		this.infinate_image_view = infinate_image_view;
		blank_line = "...";
		//expandView();
		image_step = new ArrayList<>();
		up_lim = true;
		down_lim = true;
		right_lim = true;
		left_lim = true;
		
		
	}

	public void add(String arr) {
		infinate_image_view.add(arr);
	}
	/**actual pixel is col-1, row-1*/
	public void enhanceImage(int i) {
		
		expandView(i);
		image_step = new ArrayList<>(infinate_image_view);
		
		
		
		up_lim = false;
		down_lim = false;
		right_lim = false;
		left_lim = false;
		
		
		
		for(int x = 0; x<infinate_image_view.size(); x++) {
			if(x+2<infinate_image_view.size()) {
				for(int y =0; y<infinate_image_view.get(x).length(); y++) {
					if(y+2<infinate_image_view.get(x).length()) {
						modifyPixel(x, y);
					}
				}
			}
		}

		infinate_image_view = image_step;
		//if(must_expand) {
		//	expandView(i);
		//}
		
	}
	public void modifyPixel(int col, int row){
		//must modify and save all changes in temp ArrayList<>
		int index = getIndexNumber(col, row);
		
	
		String line = image_step.get(col+1);
		//System.out.println("line: "+line + " size: " + line.length());
		String half_line = line.substring(0,row+1);
		//System.out.println("half: " + half_line+ " size: " + half_line.length());
		//System.out.println(image_enhancement_algorithm.charAt(index));
		//System.out.println("other half: " + line.substring(row +2)  + " size: " +  line.substring(row +2).length());
		char ch = image_enhancement_algorithm.charAt(index);
		line = half_line + image_enhancement_algorithm.charAt(index) + line.substring(row +2);
		//System.out.println("Final line; " + line + " size: " + line.length());
		image_step.set(col+1, line);
		
		if(col +1 <2) {
			up_lim = true;
		}
		if(row + 1 < 2) {
			left_lim = true;
		}
		if(row + 1 > (image_step.get(0).length() -3)) {
			System.out.println("I BE TRUE");
			right_lim = true;
		}
		if(col + 1 > (image_step.size()-2)) {
			down_lim = true;
		}
	
		
	}
	

	public int getIndexNumber(int col, int row){
		
		String binary = threeBythree(col, row);
		binary = binaryConverter(binary);
		return Integer.parseInt(binary,2);
	}
	
	private String binaryConverter(String raw) {
		String binary = "";
		for(int i =0; i<raw.length(); i++) {
			binary += raw.charAt(i) == '.'? "0" : "1";
		}
		return binary;
	}

	private String threeBythree(int col, int row) {
		
		String index = "";		
		String head = "";
		/*
		int col_itr = col-2;
		
		while(col_itr <0) {
			index+= "...";
			col_itr++;
		}
		
		int row_itr = row-2;
		int row_count =0;
		
		while(row_itr<0) {
			head += ".";
			row_itr++;
			row_count++;
		}
		
		while(col_itr<=col) {
			index += head + infinate_image_view.get(col_itr).substring((row-2) + row_count, row +1);
			col_itr++;
		}*/
		for(int i =col; i<col+3;i++) {
			index += infinate_image_view.get(i).substring(row, row +3);
		}
		
		//////System.out.println("index: " + index);
		ArrayList<String >rebuild = new ArrayList<>();
		//rebuild.add(index.substring(0,3));
		//rebuild.add(index.substring(3,6));
		//rebuild.add(index.substring(6,9));
		for(String str : rebuild) {
			//////System.out.println(str);
		}
		return index;
	}

	public void showImage() {
		for(String str: infinate_image_view) {
			System.out.println(str);
		}
	}
	public int count() {
		int count =0;
		for(String line : infinate_image_view) {
			for(int i =0; i<line.length();i++) {
				if(line.charAt(i) == '#') {
					count++;
				}
			}
		}
		return count;
	}
	
private void expandView(int pos){
	
	String padding = "";
	if(pos % 2 == 1) {
		padding = ".";
	}
	else {padding = ".";}
	blank_line = "";
	
	//infinate_image_view.forEach(str -> str += "..");
	if(left_lim) {
		System.out.println("HI");
		for(int i =0; i<infinate_image_view.size(); i++) {
			infinate_image_view.set(i, padding + padding+ infinate_image_view.get(i));
		}
	}
	//showImage();
	if(right_lim) {
		for(int i =0; i<infinate_image_view.size(); i++) {
			infinate_image_view.set(i, infinate_image_view.get(i) + padding + padding);
		}
	}
	while(blank_line.length() < infinate_image_view.get(0).length()) {
		blank_line += padding;
	}
	//showImage();
	if(down_lim) {
		for(int i =0; i<2; i++) {
			infinate_image_view.add(blank_line);
		}
	}
	//System.out.println("me?");showImage();
	ArrayList<String> temp = new ArrayList<>(infinate_image_view.size()+2);
	if(up_lim) {
		for(int i =0; i<2; i++) {
			temp.add(blank_line);
		}
		temp.addAll(infinate_image_view);
		infinate_image_view = temp;
	}
	//showImage();
	
	replace(padding);
	
}
private void replace(String padding) {

	for(int i =0; i<2;i++) {
		infinate_image_view.set(i,blank_line);
	}
	showImage();
	infinate_image_view.set(infinate_image_view.size()-1, blank_line);
	infinate_image_view.set(infinate_image_view.size()-2, blank_line);
	//to do left/right
	showImage();
	for(int i =0; i<infinate_image_view.size();i++) {
		String remove_left = infinate_image_view.get(i).substring(2);
		String remove_right = remove_left.substring(0, remove_left.length()-2);
		System.out.println("left: " + remove_left + " right: " + remove_right);
		infinate_image_view.set(i, padding + padding + remove_right + padding + padding);
	}
	System.out.println("HOI");showImage();
}
	public boolean isAbove(int col) {
		return col-2<0;
	}
	public boolean isBelow(int col, int limit) {
		return col>=limit;
	}
	public boolean isLeft(int row) {
		return row-2<0;
	}
	public boolean isRight(int row, int limit) {
		return row>=limit;
	}



}
