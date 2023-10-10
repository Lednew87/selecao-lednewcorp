import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        System.out.println("PROCESSO SELETIVO LEDNEWCORP");

        analisarCandidato(1400.0);
        analisarCandidato(2200.0);
        analisarCandidato(2000.0);

        System.out.println("\n** Seleção de Candidatos **");
        selecaoCandidatos();

        System.out.println("\n** Os candidatos selecionados foram: **");
        imprimirSelecionados();

        String[] candidatos = {"Maria", "João", "Ana", "Pedro", "Clara", "Lucas", "Isabella", "Bruno", "Carolina", "Gustavo"};
        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato!");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com maior oferta!");
        } else {
            System.out.println("Aguardar os outros candidatos!");
        }
    }
    static void selecaoCandidatos() {
        String[] candidatos = {"Maria", "João", "Ana", "Pedro", "Clara", "Lucas", "Isabella", "Bruno", "Carolina", "Gustavo"};
        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;

        while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("Candidato: " + candidato + " - valor: " + salarioPretendido);

            if(salarioBase >= salarioPretendido) {
                System.out.println(candidato + " selecionado para a vaga!");
                candidatosSelecionados++;
            }

            candidatosAtual++;
        }

    }
        static double valorPretendido() {
            return ThreadLocalRandom.current().nextDouble(1500, 2500);
        }

        static void imprimirSelecionados() {
            String[] candidatos = {"Maria", "João", "Ana", "Pedro", "Clara", "Lucas", "Isabella", "Bruno", "Carolina", "Gustavo"};
                System.out.println("Imprimindo o nome dos candidatos.");
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuaContato = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuaContato = !atendeu;
            if (continuaContato) {
                tentativasRealizadas++;
            } else {
                System.out.println("Contato realizado com sucesso!");
            }
        } while (continuaContato && tentativasRealizadas < 3);

        if (atendeu) {
            System.out.println("Conseguimos o contato com " + candidato + " com " + tentativasRealizadas + " tentativas!");
        } else {
            System.out.println("NÃO conseguimos o contato com " + candidato + " com " + tentativasRealizadas + " tentativas!");

        }
    }
}