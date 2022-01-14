package day21;

public class DeterministicDice {
	
	private long highest_val;
	private long starting_val;
	private long current_val;

	public DeterministicDice(long highest_val) {
		this.highest_val = highest_val;
		starting_val = 1L;
		current_val = starting_val;
	}
	
	public long nextRoll() {
		long val = current_val;
		current_val++;
		if(current_val>highest_val) {
			current_val = starting_val;
		}
		return val;
	}
}
