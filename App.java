import java.awt.Dimension;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class App {
    private static Bet bets = new Bet();
    private static JTextArea textArea;
    private static JScrollPane scrollPane;
    private static App app = new App();
    private static DecimalFormat df;

    public static void main(String args[]) {
        // ArrayList<Integer> numbers = new ArrayList<>();
        // ArrayList<Integer> numbers1 = new ArrayList<>();
        // ArrayList<Integer> numbers2 = new ArrayList<>();
        // ArrayList<Integer> numbers3 = new ArrayList<>();

        // ArrayList<Integer> lottery = new ArrayList<>();
        // lottery.add(1);
        // lottery.add(2);
        // lottery.add(3);
        // lottery.add(4);
        // lottery.add(5);

        // numbers.add(1);
        // numbers.add(2);
        // numbers.add(3);
        // numbers.add(4);
        // numbers.add(5);
        // numbers1.add(1);
        // numbers1.add(2);
        // numbers1.add(3);
        // numbers1.add(4);
        // numbers1.add(5);
        // numbers2.add(1);
        // numbers2.add(2);
        // numbers2.add(3);
        // numbers2.add(4);
        // numbers2.add(5);
        // numbers3.add(1);
        // numbers3.add(2);
        // numbers3.add(3);
        // numbers3.add(4);
        // numbers3.add(5);

        // Bet bet = new Bet("Nicolas Marques", "03046456050", numbers);
        // Bet bet1 = new Bet("Nicolas Marques", "03046456050", numbers1);
        // Bet bet2 = new Bet("Nathan Marques", "02046456050", numbers2);
        // Bet bet3 = new Bet("Norton Moises", "03043456050", numbers3);

        // bets.insertBets(bet);
        // bets.insertBets(bet1);
        // bets.insertBets(bet2);
        // bets.insertBets(bet3);

        // while(lottery.size() < 30 && bets.getWinners().isEmpty()) {
        //     if(bets.getWinners().isEmpty()) {
        //         for (int i = 0; i < bets.getBets().size(); i++) {
        //             if(lottery.containsAll(bets.getBet(i).getNumbers())) {
        //                 bets.insertWinners(bets.getBet(i));
        //             }
        //         }
        //     }
        // }

        // Prize prize = new Prize();
        // String answer = app.buildVerification(lottery, 1, bets.getWinners());
        // String answer2 = app.buildPrize(prize, (lottery.size() - 4), bets.getWinners());

        // System.out.println(answer);
        // System.out.println("\n\n");
        // System.out.println(answer2);

        String[] options = {"Iniciar", "Cancelar"};
        int opt = -1;
        List<Integer> lottery = new ArrayList<>();

        int init = JOptionPane.showOptionDialog(
                null
                , "Botão Iniciar - Pressione para iniciar uma nova edição\n" + 
                    "Botão Cancelar - Pressione para cancelar a operação"        // Mensagem
                , "Bem vindo ao Sistema de Apostas"               // Titulo
                , JOptionPane.YES_NO_OPTION  
                , JOptionPane.QUESTION_MESSAGE                              
                , null// Icone. Você pode usar uma imagem se quiser, basta carrega-la e passar como referência
                , options // Array de strings com os valores de cada botão. Veja o exemplo abaixo **
                , null    // Label do botão Default
        );

        if(init != 1) {

            while (opt != 0 && opt != 1) {
                String[] options2 = {"Finalizar Programa", "Realizar Sorteio", "Listar Apostas", "Registrar Aposta"};
                opt = JOptionPane.showOptionDialog(
                        null
                        , "Botão Registrar Aposta - Pressione para registrar uma nova aposta!\n" 
                            + "Botão Listar Apostas - Pressione para listar as apostas!\n" 
                            + "Botão Realizar Sorteio - Pressione para finalizar as apostas e iniciar o sorteio!\n" 
                            + "Botão Finalizar Programa - Pressione para finalizar o programa!\n"         // Mensagem
                        , "Sistema de Apostas"               // Titulo
                        , JOptionPane.YES_NO_OPTION  
                        , JOptionPane.QUESTION_MESSAGE                               
                        , null// Icone. Você pode usar uma imagem se quiser, basta carrega-la e passar como referência
                        , options2 // Array de strings com os valores de cada botão. Veja o exemplo abaixo **
                        , null    // Label do botão Default
                );
                
    
                switch (opt) {

                    case 3 -> {
                        String name = "";
                        String cpf = "";
                        ArrayList<Integer> numbers = new ArrayList<>();
                        boolean isCorrect = true;
                        do {
                            name = JOptionPane.showInputDialog ("Informe o seu nome", "Nicolas Marques");
                            if(name == null) 
                                break;
                            if(!name.matches("^(([A-zÀ-ú']{2,})\s{0,1}){1,}$")) { // ^(([A-zÀ-ú']{2,40})\s{0,1}){1,}$  ^((\\b[A-zÀ-ú']{2,40}\\b)\\s*){1,}$
                                JOptionPane.showMessageDialog(null, "Formato do nome é inválido!" ,"Sistema de Apostas", JOptionPane.INFORMATION_MESSAGE);
                            } else isCorrect = false;
                        } while (isCorrect);
                        if(name == null) break;
                        isCorrect = true;
                        
                        do {
                            cpf = JOptionPane.showInputDialog ("Informe o seu CPF apenas com os números", "11111111111");
                            if(cpf == null) 
                                break;
                            if(!cpf.matches("^([0-9]{11})$")) {
                                JOptionPane.showMessageDialog(null, "CPF informado é inválido!" ,"Sistema de Apostas", JOptionPane.INFORMATION_MESSAGE);
                            } else isCorrect = false;
                        } while (isCorrect);
                        if(cpf == null) break;
                        
                        String[] options3 = {"Surpresinha", "Escolher"};
                        int decision = JOptionPane.showOptionDialog(
                            null
                            , "Botão Escolher - Pressione para escolher seus números\n" + 
                                "Botão Surpresinha - Pressione para os números serem sorteados"        // Mensagem
                            , "Sistema de Apostas"               // Titulo
                            , JOptionPane.YES_NO_OPTION  
                            , JOptionPane.QUESTION_MESSAGE                              
                            , null// Icone. Você pode usar uma imagem se quiser, basta carrega-la e passar como referência
                            , options3 // Array de strings com os valores de cada botão. Veja o exemplo abaixo **
                            , null    // Label do botão Default
                        );

                        if(decision == 1) {
                            int cont = 1;
                            while(cont < 6) {
                                String number = JOptionPane.showInputDialog ("Informe seu " + cont + " número que tem que estar no intervalo de [1,50]", 1);
                                if(number == null) break;
                                if(number.matches("^([0-9]{1,2})$")) {
                                    int val = Integer.parseInt(number);
                                    if(val >= 1 && val <= 50) {
                                        if(!numbers.contains(val)) {
                                            numbers.add(val);
                                            cont++;
                                        } else JOptionPane.showMessageDialog(null, "Números informados não podem ser repetitidos!" ,"Sistema de Apostas", JOptionPane.INFORMATION_MESSAGE);
                                    } else JOptionPane.showMessageDialog(null, "Número informado é inválido!" ,"Sistema de Apostas", JOptionPane.INFORMATION_MESSAGE);
                                } else JOptionPane.showMessageDialog(null, "Número informado é inválido!" ,"Sistema de Apostas", JOptionPane.INFORMATION_MESSAGE);
                            }
                            if(cont != 6) break;

                            Bet bet = new Bet(name, cpf, numbers);
                            bets.insertBets(bet);
                            JOptionPane.showMessageDialog(null, "Aposta registrada com sucesso!" ,"Sistema de Apostas", JOptionPane.INFORMATION_MESSAGE);
                                
                        } else {
                            Bet bet = new Bet(name, cpf, numbers);
                            bets.insertBets(bet);
                            JOptionPane.showMessageDialog(null, "Aposta registrada com sucesso!" ,"Sistema de Apostas", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    }

                    case 2 -> {
                        if(!bets.allBets().isEmpty()) {
                            textArea = new JTextArea(bets.allBets());
                            scrollPane = new JScrollPane(textArea);
                            textArea.setLineWrap(true);//indica mudança automática de linha
                            textArea.setWrapStyleWord(true);//configura o estilo de quebra de linha
                            scrollPane.setPreferredSize( new Dimension( 400, 150 ) );
                            
                            JOptionPane.showMessageDialog(null, scrollPane, "Sistema de Apostas", JOptionPane.INFORMATION_MESSAGE);
                        } else 
                            JOptionPane.showMessageDialog(null, "Não foi registrada nenhuma aposta!","Sistema de Aposta", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }

                    case 1 -> {
                        int opt1 = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja iniciar o sorteio?", "Sistema de Apostas", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
                        if(opt1 == 0) {
                            Raffle raffle = new Raffle();
                            lottery = raffle.get5Numbers();
                            while(lottery.size() < 30 && bets.getWinners().isEmpty()) {
                                if(bets.getWinners().isEmpty()) {
                                    for (int i = 0; i < bets.getBets().size(); i++) {
                                        if(lottery.containsAll(bets.getBet(i).getNumbers())) {
                                            bets.insertWinners(bets.getBet(i));
                                        }
                                    }
                                    raffle.addNumber();
                                }
                            }
                            if(bets.getWinners().isEmpty()) {
                                textArea = new JTextArea(app.buildVerification(lottery, (lottery.size() - 4), bets.getWinners()));
                                scrollPane = new JScrollPane(textArea);
                                textArea.setLineWrap(true);//indica mudança automática de linha
                                textArea.setWrapStyleWord(true);//configura o estilo de quebra de linha
                                scrollPane.setPreferredSize( new Dimension( 600, 250 ) );
                                
                                JOptionPane.showMessageDialog(null, scrollPane, "Sistema de Apostas", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                Prize prize = new Prize();
                                textArea = new JTextArea(app.buildVerification(lottery, (lottery.size() - 4), bets.getWinners()));
                                scrollPane = new JScrollPane(textArea);
                                textArea.setLineWrap(true);//indica mudança automática de linha
                                textArea.setWrapStyleWord(true);//configura o estilo de quebra de linha
                                scrollPane.setPreferredSize( new Dimension( 600, 250 ) );

                                JOptionPane.showMessageDialog(null, scrollPane,"Sistema de Apostas", JOptionPane.INFORMATION_MESSAGE);

                                // A partir daqui é a parte do prêmio, estou montando a visualização do prêmio 
                                textArea = new JTextArea(app.buildPrize(prize, (lottery.size() - 4), bets.getWinners()));
                                scrollPane = new JScrollPane(textArea);
                                textArea.setLineWrap(true);//indica mudança automática de linha
                                textArea.setWrapStyleWord(true);//configura o estilo de quebra de linha
                                scrollPane.setPreferredSize( new Dimension( 600, 250 ) );

                                JOptionPane.showMessageDialog(null, scrollPane,"Sistema de Apostas", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else opt = -1;
                        break;
                    }
                }
            }

            JOptionPane.showMessageDialog(null, "Programa Encerrado!" ,"Sistema de Apostas", JOptionPane.WARNING_MESSAGE);
        } else
            JOptionPane.showMessageDialog(null, "Programa Encerrado!" ,"Sistema de Apostas", JOptionPane.WARNING_MESSAGE);
    }

    private String buildVerification(List<Integer> lottery, int round, ArrayList<Bet> winners) {
        ArrayList<String> verification = new ArrayList<>();
        
        if(winners.isEmpty()) {
            verification.add("Lista de números sorteados: " + lottery.toString());
            verification.add("Quantidade de rodadas: " + String.valueOf(round));
            verification.add("Quantidade de apostas vencedoras: " + String.valueOf(winners.size()));
            verification.add("Não houve apostas vencedoras!");
            verification.add("Lista de números apostados:\n---------------------------\n" 
                + bets.buildOccurenceNumbers() + "\n---------------------------");
        } else {
            verification.add("Lista de números sorteados: " + lottery.toString());
            verification.add("Quantidade de rodadas: " + String.valueOf(round));
            verification.add("Quantidade de apostas vencedoras: " + String.valueOf(winners.size()));
            verification.add("Lista de apostas vencedoras:\n{\n" + bets.buildBetWinners(winners) + "\n}");
            verification.add("Lista de números apostados:\n---------------------------\n" 
                + bets.buildOccurenceNumbers() + "\n---------------------------");
        }

        return String.join("\n", verification);
    }

    private String buildPrize(Prize val, int round, ArrayList<Bet> winners) {
        ArrayList<String> prize = new ArrayList<>();
        ArrayList<String> cpfs = bets.verifyCpf(winners);
        String format = "R$ #,##0.00";
        df = new DecimalFormat(format);

        if(round == 1) {
            prize.add("                 PARABÉNS VENCEDOR(ES)!!");
            prize.add("\n\nValor original do prêmio: " + df.format(val.getPrize()));
            prize.add("Os 5 números sorteados foram acertados na 1 rodada, por isso o valor do prêmio continua inalterado!!");
            prize.add("Vencedor(es):\n" + bets.buildWinnersWithNameCpfPrize(winners, val.distributePrize(cpfs.size(), val.getPrize()), cpfs));
        } else {
            val.reducedPrize(round);
            prize.add("                 PARABÉNS VENCEDOR(ES)!!");
            prize.add("\n\nValor original do prêmio: " + df.format(val.getPrize()));
            prize.add("Valor do prêmio na rodada " + round + ": " + df.format(val.getReduced()));
            prize.add("Vencedor(es):\n" + bets.buildWinnersWithNameCpfPrize(winners, val.distributePrize(cpfs.size(), val.getReduced()), cpfs));
        }
        
        
        return String.join("\n", prize);
    }
}