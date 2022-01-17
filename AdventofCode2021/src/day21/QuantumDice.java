package day21;

import java.util.HashSet;
import java.util.Set;

public class QuantumDice {
	
	long p1_wins = 0L;
	long p2_wins = 0L;
	long times_recursed;

	
	public void quantumGame(Pawn player1, Pawn player2, int p1_num_rolled, int p2_num_rolled, int depth, int dicerolled) {
		
		//System.out.println("P1: " + player1.score + " at depth " + depth + " dice rolled" + dicerolled);
		//System.out.println("P2: " + player2.score);
		//System.out.println("first player rolls: " + p1_num_rolled + " score: " + player1.score);
		//System.out.println("Second: " + p2_num_rolled);
		//System.out.println("dice: " + dicerolled);
		times_recursed++;
		if(p1_num_rolled==3) {
		//	return;
		}
		if(p2_num_rolled ==3) {
			//return;
		}
		if(player1.score>=21 && p1_num_rolled == 3) {
			p1_wins++;
			return;
		}
		if(player2.score>=21 && p2_num_rolled == 3) {
			p2_wins++;
			return;
		}
		
		//for(int i =p1_num_rolled; i<3; i++) {			
			
		if(p1_num_rolled < 3) {
		
			for(int quantum = 1; quantum<3; quantum++) {
				Pawn quantum_player1 = new Pawn(player1.current_pos, player1.score);
				quantum_player1.addVal(quantum);
				
				Pawn quantum_player2 = new Pawn(player2.current_pos, player2.score);
				quantumGame(quantum_player1, quantum_player2, p1_num_rolled +1, p2_num_rolled, depth +1, quantum);
			}
			player1.addVal(3);
		}
		//}
		if(p2_num_rolled < 3) {
			for(int quantum = 1; quantum<3; quantum++) {
				Pawn quantum_player1 = new Pawn(player1.current_pos, player1.score);				
				
				Pawn quantum_player2 = new Pawn(player2.current_pos, player2.score);
				quantum_player2.addVal(quantum);
				quantumGame(quantum_player1, quantum_player2, p1_num_rolled, p2_num_rolled +1, depth +1, quantum);
			}
			player2.addVal(3);
		}
				
		
		if(p1_num_rolled == 3 && p2_num_rolled == 3) {
		//	System.out.println("MEEEEEEEEEEE");
			quantumGame(player1, player2, 0 , 0 , depth +1, 0);
		}
		if(p1_num_rolled != 3 && p2_num_rolled !=3 && player1.score<21 && player2.score<21) {
			quantumGame(player1, player2, p1_num_rolled + 1, p2_num_rolled + 1, depth +1, 0);
		}
	
		
	}
	
	
}
