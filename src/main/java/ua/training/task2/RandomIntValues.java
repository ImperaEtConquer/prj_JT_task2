package ua.training.task2;

public enum RandomIntValues {
	A(0), B(25), C(35), D(150), E(90), F(2), G(30);

	private final int value;

	private RandomIntValues(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
