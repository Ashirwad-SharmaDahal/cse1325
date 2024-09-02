public class Coin {
    private Denomination denomination;
    private int year;

    public Coin(Denomination denomination, int year) {
        this.denomination = denomination;
        this.year = year;
    }

    public Denomination getDenomination() {
        return denomination;
    }

    public int getYear() {
        return year;
    }
}
