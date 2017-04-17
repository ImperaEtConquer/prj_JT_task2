package ua.training.task2;

public class View {
	
	/* SYSTEM MESSAGES */
	
	static String LESS_GUESS = "The number you wrote is less than desired.";
	static String MORE_GUESS = "The number you wrote is greater than desired.";
	static String CORRECT_GUESS = "Congratulations! You won.";
	static String STATISTICS = "Here's all your attempts:";
	static String OUT_OF_RANGE = "Your number is out of range.";

	/* ERROR MESSAGES */

	static String WRONG_INPUT = "Error. Please enter integer value next time.";
	static String ALREADY_EXISTS = "The number you wrote is already exists.";

	/* GREETINGS MESSAGES */

	static String GREETINGS_PART_1 = "Welcome to the Guessing Game! I've picked a random number between ";
	static String GREETINGS_PART_2 = " and ";
	static String GREETINGS_PART_3 = ". Can you try to guess it?";

	public void printSystemMessage(String message) {
		System.out.println(message);
	}

	public void printIntegerElements(int element) {
		System.out.print(element + " ");
	}

	public void printErrorMessage(String errorMessage) {
		System.err.println(errorMessage);
	}

	public void printGreetingMessage(int min, int max) {
		printSystemMessage(GREETINGS_PART_1 + min + GREETINGS_PART_2 + max + GREETINGS_PART_3);
	}

	public void printPreviousAttempts(Model model) {
		printSystemMessage(View.STATISTICS);
		model.getPlayerAttempts().forEach(ele -> {
			printIntegerElements(ele);
		});
	}

}
