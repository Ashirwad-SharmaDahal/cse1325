public enum Denomination{
	PENNY(1), NICKLE(5), DIME(10), QUARTER(25);
	private int value;
	Denomination(int value) {
	this.value = value;
	}
	public int getValue() {
	return value;
	}
}