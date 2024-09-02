public class Purse {
    public static void main(String[] args) {
        Coin[] coins = new Coin[]{
            new Coin(Denomination.PENNY, 2020),
            new Coin(Denomination.NICKEL, 1889),
            new Coin(Denomination.DIME, 1996),
            new Coin(Denomination.QUARTER, 2004),
        };

        int totalValue = 0;
        int earliestYear = Integer.MAX_VALUE;
        int latestYear = Integer.MIN_VALUE;

        for (Coin coin : coins) {
            totalValue += coin.getDenomination().getValue();
            int year = coin.getYear();
            if (year < earliestYear) {
                earliestYear = year;
            }
            if (year > latestYear) {
                latestYear = year;
            }
        }

        System.out.println("Total Value: " + totalValue + " cents");
        System.out.println("Earliest Year: " + earliestYear);
        System.out.println("Latest Year: " + latestYear);
    }
}
