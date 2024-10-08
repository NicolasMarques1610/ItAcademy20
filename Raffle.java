import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Classe do sorteio 
public class Raffle {
    private ArrayList<Integer> numbers;
    private List<Integer> subList;
    private int cont = 5;

    public Raffle() {
        this.numbers = new ArrayList<>();
        this.subList = new ArrayList<>();
        generateNumbers();
        shuffleNumbers();
    }

    public ArrayList<Integer> getNumbers() {
        return this.numbers;
    }

    // Nesse método eu pego os primeiros 5 números da lista e adiciono em uma sublista 
    //para começar o sorteio
    public List<Integer> get5Numbers() {
        for (int i = 0; i < 5; i++) {
            this.subList.add(getNumbers().get(i));
        }
        return this.subList;
    }

    // Nesse método eu adiciono um número a mais na lista de números do sorteio
    public void addNumber() {
        int number = getNumbers().get(this.cont);
        this.subList.add(number);
        // sortNumbers(this.subList);
        this.cont++;
    }

    // Nesse método eu gero todos os números de 1 a 50 e adiciono-os na lista
    private void generateNumbers() {
        for (int i = 1; i < 51; i++) {
            this.numbers.add(i);
        }
    }

    // Nesse método eu embaralho os números da lista
    private void shuffleNumbers() {
        Collections.shuffle(getNumbers());
    }
}
