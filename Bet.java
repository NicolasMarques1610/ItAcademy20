import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

//Classe de aposta que está implementando a interface Comparable com objetivo de ordena os nomes 
// dos apostadores
public class Bet implements Comparable<Bet>{
    private String name;
    private String cpf;
    private ArrayList<Integer> numbers;
    private ArrayList<Bet> bets;
    private ArrayList<Bet> winners;
    private int id = 999;
    private DecimalFormat df;
    // É estático para mudar o valor ao longo da execução independente de novas instâncias
    private static int count = 0;

    // Construtor para iniciar a lista de apostas e lista de vencedores
    public Bet() {
        this.bets = new ArrayList<>();
        this.winners = new ArrayList<>();
    }
    
    public Bet(String name, String cpf, ArrayList<Integer> numbers) {
        this.name = name;
        this.cpf = cpf;
        this.numbers = new ArrayList<>();
        incrementCount();
        this.id += Bet.count;
        
        if(numbers.isEmpty()) {
            randomNumbers();
        } else {
            insertNumbers(numbers);
        }
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public int getId() {
        return id;
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

    // Método para retornar uma String de todas as apostas com as informações de cada aposta
    public String allBets() {
        ArrayList<String> allBets = new ArrayList<>();
        Bet bet;
        
        for (int i = 0; i < this.bets.size(); i++) {
            bet = this.bets.get(i);
            allBets.add("Nome: " + bet.getName() + "\nCPF: " + bet.getCpf() + "\nNúmeros: " 
                + bet.getNumbers() + "\nID: " + bet.getId()); 
        }
        return String.join(";\n\n", allBets);
    }

    // Método para inserir a aposta na lista de apostas
    public void insertBets(Bet bet) {
        bets.add(bet);
    }
    
    // Método para inserir as apostas vencedoras na lista de vencedores
    public void insertWinners(Bet bet) {
        winners.add(bet);
    }

    // Método para retornar uma String de todos os vencedores com nome e os números dele
    // Monta a lista de apostas vencedoras
    public String buildBetWinners(ArrayList<Bet> winners) {
        ArrayList<String> saveWinners = new ArrayList<>();
        // essa lista já recebe a lista de vencedores ordenada pelo nome
        ArrayList<Bet> sortedWinners = new ArrayList<>(sortedNames());
        
        for (Bet bet : sortedWinners) {
            saveWinners.add("ID: " + bet.getId() + ", Nome: " + bet.getName() + ", Números: " + bet.getNumbers());
        }
        return String.join("\n", saveWinners);
    }

    // Método para retornar uma String de todos os vencedores com o nome, cpf e o valor do prêmio
    // Monta a lista de vencedores juntamente com o prêmio recebido
    public String buildWinnersWithNameCpfPrize(ArrayList<Bet> winners, double val) {
        ArrayList<String> saveWinners = new ArrayList<>();
        // Um formatador de decimais para formatar o valor do prêmio
        String format = "R$ #,##0.00";
        df = new DecimalFormat(format);

        for (Bet bet : winners) {
            saveWinners.add("ID: " + bet.getId() + ", Nome: " + bet.getName() + ", Prêmio: " + df.format(val));
        }
        return String.join("\n", saveWinners);
    }

    // Método para retornar uma String de todos os números apostados com a ocorrência de cada número
    // Monta a lista de ocorrência de números apostados
    public String buildOccurenceNumbers() {
        ArrayList<Integer> allNumbers = new ArrayList<>();
        ArrayList<String> buildedNumbers = new ArrayList<>();
        buildedNumbers.add("Nro apostado        Qtd de Apostas");
        // adiciona na lista todos os números apostados 
        allNumbers = addAllNumbers();
        // adiciona na lista os números apostados juntamente com sua ocorrência
        buildedNumbers.addAll(sortedOcurrenceNumber(allNumbers));

        return String.join("\n", buildedNumbers);
    }

    // Método para adicionar todos os números apostados em uma lista 
    private ArrayList<Integer> addAllNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (Bet bet : bets) {
            numbers.addAll(bet.getNumbers());
        }
        
        return numbers;
    }

    // Método para ordenar a ocorrência dos números pelos que mais ocorrem até os que menos ocorrem
    private ArrayList<String> sortedOcurrenceNumber(ArrayList<Integer> allNumbers) {
        ArrayList<String> buildedNumbers = new ArrayList<>();

        Map<Integer,Integer> occurrence = new HashMap<>();
        for (int number : allNumbers) {
            // Aqui está sendo adicionado o número como key do map, e o número de ocorrências dele no valor
            // É utilizado o getOrDefault para verificar se essa chave já está no mapa, se não estiver o 
            // valor default é 0 + 1, agora se já estiver adiciona 1 ao valor já existente, funciona como um contador
            occurrence.put(number, occurrence.getOrDefault(number, 0) + 1);
        }
        
        // Aqui eu inicializo a lista de map.entry com os pares de chave e valor do map occurrence
        List<Map.Entry<Integer, Integer>> sortedOccurrence = new ArrayList<>(occurrence.entrySet());

        // Aqui está sendo ordenado a lista sortedOccurrence a partir do novo objeto comparator,
        // depois ocorre uma comparação entre dois objetos map.entry, em que se está sendo pego o valor
        // de cada map e comparado, assim ordenando de forma decrescente, pois é invertido a ordem dos 
        // valores map1 e map2
        Collections.sort(sortedOccurrence, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> map1, Map.Entry<Integer, Integer> map2) {
                return map2.getValue().compareTo(map1.getValue()); 
            }
        });

        // Aqui está sendo montado a lista de Strings com o número e sua ocorrência
        for (Map.Entry<Integer,Integer> entry : sortedOccurrence) {
            if(entry.getKey().toString().length() == 2) {
                buildedNumbers.add(entry.getKey() + "                              " + entry.getValue());
            } else buildedNumbers.add(entry.getKey() + "                                " + entry.getValue());
        }

        return buildedNumbers;
    }

    // Método para ordena os nomes dos vencedores
    private ArrayList<Bet> sortedNames() {
        ArrayList<Bet> sortedWinners = new ArrayList<>();
        winners.forEach(w -> sortedWinners.add(w));

        Collections.sort(sortedWinners);
        return sortedWinners;
    }

    // Método para incrementar o contador que é somado ao id
    private void incrementCount() {
        Bet.count++;
    }

    // Método para geração de 5 números aleatórios entre 1 a 50 sem poder repetir os números 
    private void randomNumbers() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int number = random.nextInt(1, 51);
            if(!this.numbers.contains(number)) {
                this.numbers.add(number);
            } else i--;
        }
    }
    
    // Método para inserir os números escolhidos na lista de números apostados
    private void insertNumbers(ArrayList<Integer> numbers) {
        numbers.forEach(n -> this.numbers.add(n));
    }

    // Método implementado e sobrescrito da interface Comparable, nesse método é comparado os 
    // objetos Bet com base nos nomes
    @Override
    public int compareTo(Bet bet) {
        // TODO Auto-generated method stub
        return this.name.compareTo(bet.getName());
    }
}