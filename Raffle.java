import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public List<Integer> get5Numbers() {
        for (int i = 0; i < 5; i++) {
            this.subList.add(getNumbers().get(i));
        }
        return this.subList;
    }

    public void addNumber() {
        int number = getNumbers().get(this.cont);
        this.subList.add(number);
        // sortNumbers(this.subList);
        this.cont++;
    }

    private void generateNumbers() {
        for (int i = 1; i < 51; i++) {
            this.numbers.add(i);
        }
    }

    private void shuffleNumbers() {
        Collections.shuffle(getNumbers());
    }
}
