import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class candidatura {
    public static void main(String[] args) {
        // Primeiro, seleciona os candidatos
        String[] selecionados = selecaoCandidatos();

        // Depois, imprime os selecionados com índice
        imprimirSelecionados(selecionados);

        // Por fim, entra em contato com os candidatos
        entrandoEmContato(selecionados);
    }
    //Ligando para os candidatos selecionados
    static void entrandoEmContato (String[] selecionados) {
        for (String candidato : selecionados) { // Percorre todos os candidatos selecionados
            int tentativasRealizadas = 0;
            boolean candidatoAtendeu = false;

            System.out.println("\n Ligando para " + candidato + "...");

            do {
                candidatoAtendeu = atender(); // Tenta ligar
                tentativasRealizadas++;

                if (candidatoAtendeu) {
                    System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " na tentativa " + tentativasRealizadas);
                } else {
                    System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + " (tentativa " + tentativasRealizadas + ")");
                }

            } while (!candidatoAtendeu && tentativasRealizadas < 3); // Tenta no máximo 3 vezes

            if (!candidatoAtendeu) {
                System.out.println("NÃO FOI POSSÍVEL CONTATAR " + candidato + " APÓS 3 TENTATIVAS.");
            }
        }
    }

        //Método atender
        static boolean atender() {
            return new Random().nextInt(3) == 1; // Retorna true apenas se for 1
        }        

    
    // Método para selecionar candidatos e retornar um array dos selecionados
    static String[] selecaoCandidatos() {
        String[] candidatos = {
            "João", "Maria", "José", "Ana", "Carlos", "Mariana", "Pedro", "Paula", "Lucas", "Juliana",
            "Fernando", "Marta", "Ricardo", "Cristina", "Felipe", "Sandra", "Rafael", "Camila", "Gustavo", "Larissa"
        };

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioPretendido;
        double salarioBase = 2000.0;
        String[] selecionadosTemp = new String[5]; // Array temporário para armazenar os selecionados

        System.out.println("=== Processo de Seleção de Candidatos ===");

        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            salarioPretendido = valorPretendido();
            
            System.out.println("\nCandidato: " + candidato);
            System.out.println("Salário pretendido: " + salarioPretendido);

            if (salarioPretendido <= salarioBase) {
                System.out.println("Candidato selecionado.");
                selecionadosTemp[candidatosSelecionados] = candidato;
                candidatosSelecionados++;
            } else {
                System.out.println("Candidato não selecionado.");
            }
            candidatosAtual++;
        }

        // Retorna um array apenas com os selecionados (sem null)
        String[] selecionados = new String[candidatosSelecionados];
        System.arraycopy(selecionadosTemp, 0, selecionados, 0, candidatosSelecionados);
        return selecionados;
    }

    // Método para imprimir os candidatos selecionados com índice
    static void imprimirSelecionados(String[] selecionados) {
        System.out.println("\n=== Lista de Candidatos Selecionados ===");
        for (int i = 0; i < selecionados.length; i++) {
            System.out.println((i + 1) + " - " + selecionados[i]);
        }
    }

    // Método para gerar um valor de salário aleatório
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800.0, 2200.0);
    }

    static void analisarCandiato(double salarioPretendido, double salarioBase) {  
        if (salarioPretendido < salarioBase) {
            System.out.println("Ligar para o candidato.");
        } else if (salarioPretendido == salarioBase) {
            System.out.println("Entrar em contato com o candidato com contra proposta.");
        }
        else {
            System.out.println("Aguardando resultado dos demais candidatos.");
        }
    }
}