public class Prize {
    private double prize;
    private double percent;
    private double reduced;

    /*
     * 1 - Valor original do prêmio;
     * 2 - Valor do prêmio na rodada que está
     * 3 - Nome e CPF e valor do Prêmio dos vencedores
     */
    public Prize() {
        this.prize = 50000000;
        this.percent = 0.95;
    }

    public double getPrize() {
        return prize;
    }

    public double getReduced() {
        return reduced;
    }

    public void reducedPrize(int rounds) {
        this.reduced = prize * Math.pow(percent, rounds);
    }

    public double distributePrize(int winners, double prize) {
        double distributed;

        distributed = prize / winners;
        return distributed;
    }
}
