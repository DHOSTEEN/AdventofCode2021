package day21;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pawn {
	
	private int starting_pos;
	public int current_pos;
	public int score;
	
	public Pawn(int starting_pos) {
		this.starting_pos = starting_pos;
		current_pos = starting_pos;
		score = 0;
	}
	
	public Pawn(int starting_pos, int score) {
		this.starting_pos = starting_pos;
		current_pos = starting_pos;
		this.score = score;
	}
	
	public void addVal(int val) {
		
		List<Pawn> list = new ArrayList<>();
		
		current_pos+=val;
		if(current_pos > 10) {
			current_pos = current_pos % 10 == 0 ? 10 : current_pos % 10;
		}
		score += current_pos;
		score+=val;
		if(score ==0) {
			System.err.print("WTFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
		}
	}
	

}
