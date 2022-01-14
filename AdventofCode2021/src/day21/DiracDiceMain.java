package day21;


import InputReaders.AdventInputReader;


public class DiracDiceMain {
	
	 private static AdventInputReader obj;
	    private static String file_location = "E:\\Netbeans\\AdventofCode2021\\AdventInputs\\AdventInput21_data.txt";
	
	public static void main(String[] args) {

		Pawn player1 = new Pawn(6);
		Pawn player2 = new Pawn(7);
		DeterministicDice dice = new DeterministicDice(100);		
		
		int count =0;
		boolean p1_wins = false;
		
		while(player2.score <1000 && player1.score< 1000){
		
			
			for(int i =0; i<3; i++) {
				long roll = dice.nextRoll();
				player1.current_pos += roll;
				count++;
			}
			if(player1.current_pos >10) {
				player1.current_pos = player1.current_pos % 10 == 0 ? 10: player1.current_pos % 10;
			}
			player1.score += player1.current_pos;
			
			if(player1.score>=1000) {
				p1_wins = true;
				break;
			}
			for(int i =0; i<3; i++) {
				long roll = dice.nextRoll();
				player2.current_pos += roll;
				count++;			
			}
			if(player2.current_pos>10) {
				player2.current_pos = player2.current_pos % 10 == 0 ? 10 : player2.current_pos % 10;
			}
			player2.score += player2.current_pos;		
			
		}
		System.out.println("PLAYER ONE SCORE: " + player1.score);
		System.out.println("PLAYER TWO SCORE: " + player2.score);
		System.out.println("DICE ROLLED: " + count);
		long score = count * (p1_wins == true ? player2.score : player1.score);
		System.out.println("score: " + score );

	
	}
}