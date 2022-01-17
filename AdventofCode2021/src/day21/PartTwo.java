package day21;

public class PartTwo {
	
	

	public static void main(String[] args) {
		
		Pawn player1 = new Pawn(6);
		Pawn player2 = new Pawn(7);
		
		QuantumDice game = new QuantumDice();
		game.quantumGame(player1, player2, 0, 0, 0,0);
		System.out.println(game.p1_wins);
		System.out.println(game.p2_wins);
		System.out.println("recursed: " + game.times_recursed);
	}
}

//129240319
//129240319
//big issue