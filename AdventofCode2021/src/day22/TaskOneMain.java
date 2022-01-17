package day22;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import InputReaders.AdventInputReader;

public class TaskOneMain {	
	
	private static AdventInputReader obj;
	private static Scanner scan;
	private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput21_testdata.txt";
	private static String filename = "test_data.txt";
	
	public static void main(String[] args){
		
		try {
            List<String> lines = Files.readAllLines(Paths.get(filename));
            
            
        } catch(IOException e) {
            e.printStackTrace();
        }
	}

}
