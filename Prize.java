// Classe do Prêmio 
public class Prize {
    private double prize;
    private double percent;
    private double reduced;

    /*
     * Eu escolhi realizar o prêmio no formato de um valor único que na primeira rodada se mantém,
     * nas demais rodadas vai ocorrendo uma redução de 5% em cima do valor na rodada, ou seja, na 1 
     * rodada os ganhadores ganham os 50 milhões, já na segunda vão ganhar 47 milhões e 500 mil, na 
     * terceira vão ganhar 45 milhões e 125 mil e assim por diante. 
     * 
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

    // Nesse método é realizado o cálculo de redução do prêmio
    public void reducedPrize(int rounds) {
        // Aqui eu faço o cálculo do valor do prêmio vezes a porcentagem elevada na quantidade de rodadas
        this.reduced = prize * Math.pow(percent, rounds);
    }

    // Nesse método é realizado o calculo da distribuição do prêmio pelos vencedores
    public double distributePrize(int winners, double prize) {
        double distributed;

        distributed = prize / winners;
        return distributed;
    }
}
