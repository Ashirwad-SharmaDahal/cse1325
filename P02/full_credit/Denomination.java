 public enum Denomination {
    PENNY(1), NICKEL(5), DIME(10), QUARTER(25);

    private int value;

    Denomination(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return this.name() 
    }
}
