import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Bet implements Comparable<Bet>{
    private String name;
    private String cpf;
    private ArrayList<Integer> numbers;
    private ArrayList<Bet> bets;
    private ArrayList<Bet> winners;
    private int id = 1000;
    private static int count = 0;

    public Bet() {
        this.bets = new ArrayList<>();
        this.winners = new ArrayList<>();
    }
    
    public Bet(String name, String cpf, ArrayList<Integer> numbers) {
        this.name = name;
        this.cpf = cpf;
        this.numbers = new ArrayList<>();
        this.id += Bet.count;
        incrementCount();
        
        if(numbers.isEmpty()) {
            randomNumbers();
            // Collections.sort(numbers);
        } else {
            insertNumbers(numbers);
            // Collections.sort(numbers);
        }
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public ArrayList<Bet> getBets() {
        return bets;
    }

    public ArrayList<Bet> getWinners() {
        return winners;
    }

    public Bet getBet(int pos) {
        return getBets().get(pos);
    }

    public String allBets() {
        ArrayList<String> allBets = new ArrayList<>();
        Bet bet;
        
        for (int i = 0; i < this.bets.size(); i++) {
            bet = this.bets.get(i);
            allBets.add("Nome: " + bet.getName() + "\nCPF: " + bet.getCpf() + "\nNúmeros: " + bet.getNumbers() + "\nID: " + bet.id); //= "Nome: " + bet.name + "\nCPF: " + bet.cpf + "Números: " + bet.numbers + "ID: " + bet.id;
        }
        return String.join(";\n\n", allBets);
    }

    public void insertBets(Bet bet) {
        bets.add(bet);
    }
    
    public void insertWinners(Bet bet) {
        winners.add(bet);
    }

    public String buildBetWinners(ArrayList<Bet> winners) {
        ArrayList<String> printWinners = new ArrayList<>();
        sortedNames();
        for (int i = 0; i < winners.size(); i++) {
            printWinners.add("Nome: " + winners.get(i).name + ", Números: " + winners.get(i).numbers);
        }
        return String.join("\n", printWinners);
    }

    public String buildSortedNumbers() {
        ArrayList<Integer> allNumbers = new ArrayList<>();
        ArrayList<String> buildedNumbers = new ArrayList<>();
        buildedNumbers.add("Nro apostado        Qtd de Apostas");
        allNumbers = addAllNumbers();
        buildedNumbers.addAll(sortedNumbers(allNumbers));

        return String.join("\n", buildedNumbers);
    }

    private ArrayList<Integer> addAllNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (Bet bet : bets) {
            numbers.addAll(bet.getNumbers());
        }
        
        return numbers;
    }

    private ArrayList<String> sortedNumbers(ArrayList<Integer> allNumbers) {
        ArrayList<String> buildedNumbers = new ArrayList<>();

        Map<Integer,Integer> occurrence = new HashMap<>();
        for (int number : allNumbers) {
            occurrence.put(number, occurrence.getOrDefault(number, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> sortedOccurrence = new ArrayList<>(occurrence.entrySet());
        Collections.sort(sortedOccurrence, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> map1, Map.Entry<Integer, Integer> map2) {
                return map2.getValue().compareTo(map1.getValue()); // Decrescente
            }
        });

        for (Map.Entry<Integer,Integer> entry : sortedOccurrence) {
            if(entry.getKey().toString().length() == 2) {
                buildedNumbers.add(entry.getKey() + "                              " + entry.getValue());
            } else buildedNumbers.add(entry.getKey() + "                                " + entry.getValue());
        }

        return buildedNumbers;
    }

    private void sortedNames() {
        Collections.sort(winners);
    }

    private void incrementCount() {
        Bet.count++;
    }

    private void randomNumbers() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int number = random.nextInt(1, 51);
            if(!this.numbers.contains(number)) {
                this.numbers.add(number);
            } else i--;
        }
    }
    
    private void insertNumbers(ArrayList<Integer> numbers) {
        numbers.forEach(n -> this.numbers.add(n));
    }

    @Override
    public int compareTo(Bet bet) {
        // TODO Auto-generated method stub
        return this.name.compareTo(bet.getName());
    }
}
