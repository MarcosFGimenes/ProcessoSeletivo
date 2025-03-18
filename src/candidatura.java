import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class candidatura {
    public static void main(String[] args) throws Exception {
        String [] candidatos = {"João", "Maria", "José", "Ana", "Carlos", "Mariana", "Pedro", "Paula", "Lucas", "Juliana", "Fernando", "Marta", "Ricardo", "Cristina", "Felipe", "Sandra", "Rafael", "Camila", "Gustavo", "Larissa"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioPretendido;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            salarioPretendido = valorPretendido();
            System.out.println("Candidato: " + candidato);
            System.out.println("Salário pretendido: " + salarioPretendido);

            if (salarioPretendido <= salarioBase) {
                System.out.println("Candidato selecionado.");
                candidatosSelecionados++;
            } else {
                System.out.println("Candidato não selecionado.");
            }
            candidatosAtual++;            
        }
    }
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