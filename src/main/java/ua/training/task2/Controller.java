package ua.training.task2;

import java.util.Scanner;

public class Controller {
	private Model model;
	private View view;
	private boolean isGameFinished;

	public Controller(Model model, View view) {
		super();
		this.model = model;
		this.view = view;
	}

	public void processUser() {
		model.setRange(GlobalConstants.MIN_VALUE, GlobalConstants.MAX_VALUE);
		model.setMysteryNumber();

		view.printGreetingMessage(model.getMin(), model.getMax());

		Scanner sc = new Scanner(System.in);
		startGame(sc);

		view.printPreviousAttempts(model);
	}

	private void startGame(Scanner sc) {
		while (!isGameFinished) {
			if (sc.hasNextInt()) {
				int playerInput = sc.nextInt();
				if (isInRange(playerInput, model)) {
					model.addPlayerGuessToSet(playerInput);
					isGameFinished = compareValues(playerInput, model.getMysteryNumber());
				} else {
					view.printErrorMessage(View.OUT_OF_RANGE);
				}
			} else {
				view.printErrorMessage(View.WRONG_INPUT);
				sc.next();
			}
		}
		view.printSystemMessage(View.CORRECT_GUESS);
	}

	private boolean isInRange(int value, Model model) {
		return ((value >= model.getMin()) && (value <= model.getMax()));
	}

	private boolean compareValues(int compareWhat, int compareWith) {
		if (compareWhat > compareWith) {
			view.printSystemMessage(View.MORE_GUESS);
			return false;
		}
		if (compareWhat < compareWith) {
			view.printSystemMessage(View.LESS_GUESS);
			return false;
		} else {
			return true;
		}
	}

}
