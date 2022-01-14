package day20;

import java.util.ArrayList;

import InputReaders.AdventInputReader;

public class TaskOne {
	
	private static AdventInputReader obj;
    private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput20_data.txt";
	
	public static void main(String[] args) {
		
		obj = new AdventInputReader(file_location);
		String algorithm = obj.getFile_obj().nextLine();
		System.out.println(algorithm.length());
		obj.getFile_obj().nextLine();//skipsblank
		
		ArrayList<String> list = new ArrayList<>();
		while(obj.getFile_obj().hasNext()) {
			list.add(obj.getFile_obj().nextLine());
		}
		System.out.println(list);
		Image inf_image = new Image(algorithm, list);
		
		//System.out.println(inf_image.getIndexNumber(3, 1));
		inf_image.showImage();
		for(int i =0; i<2; i++) {
			//System.out.println(i % 2 == 1);
			inf_image.enhanceImage(i);
			inf_image.showImage();
		}
	
		//inf_image.showImage();
		System.out.println("count: " + inf_image.count());
	}

}
