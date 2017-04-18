package ua.training.task2;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class ModelTest {

	private boolean allElementsAreInRange;

	@Test
	public void checkRandomFunctionOnce() {

		Model model = new Model();
		model.setRange(1, 1);
		model.setMysteryNumber();

		int expectedResult = 1;
		int actualResult = model.getMysteryNumber();

		Assert.assertEquals(actualResult, expectedResult);

	}

	@Test
	public void checkRandomFunctionMultipleTimes() {

		Model model = new Model();
		model.setRange(0, 5);
		ArrayList<Integer> actualResultsArray = new ArrayList<>();

		for (int i = 0; i < 50; i++) {
			model.setMysteryNumber();
			actualResultsArray.add(model.getMysteryNumber());
		}

		allElementsAreInRange = true;
		actualResultsArray.forEach(ele -> {
			if (ele < 0 || ele > 5) {
				allElementsAreInRange = false;
			}
		});

		Assert.assertTrue(allElementsAreInRange);
	}

	@Test
	public void checkGameWithEnum() {
		Model model = new Model();
		View view = new View();

		model.setRange(0, 100);
		model.setMysteryNumber(RandomIntValues.values()[RandomIntValues.values().length - 1].getValue());

		
		boolean valueGuessed = false;
		Controller controller = new Controller(model, view);
		for (RandomIntValues obj : RandomIntValues.values()) {
			valueGuessed = controller.guessValueFromEnum(obj.getValue());
		}
		
		Assert.assertTrue(valueGuessed);

	}
}
