package ua.training.task2;

import java.util.ArrayList;

public class Model {
	private int mysteryNumber;
	private ArrayList<Integer> playerAttempts = new ArrayList<>();
	private int min;
	private int max;

	public int getMysteryNumber() {
		return mysteryNumber;
	}

	public void setMysteryNumber() {
		this.mysteryNumber = rand(getMin(), getMax());
	}
	
	public void setMysteryNumber(int value){
		this.mysteryNumber = value;
	}

	public void setRange(int minValue, int maxValue) {
		setMin(minValue);
		setMax(maxValue);
	}

	public void addPlayerGuessToSet(int value) {
		playerAttempts.add(value);
	}

	public ArrayList<Integer> getPlayerAttempts() {
		return playerAttempts;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	private int rand(int min, int max) {
		return (min + (int) (Math.random() * ((max - min) + 1)));
	}

	private void setMax(int max) {
		this.max = max;
	}

	private void setMin(int min) {
		this.min = min;
	}

	@SuppressWarnings("unused")
	private int rand() {
		return (int) (Math.random() * ((Integer.MAX_VALUE) + 1));
	}

}
