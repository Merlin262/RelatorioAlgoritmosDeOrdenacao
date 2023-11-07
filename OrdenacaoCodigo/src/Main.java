import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] sizes = {50, 500, 1000, 5000, 10000};

        for (int i = 0; i < 5; i++) {

            int repeticoes = 5; // Número de repetições

            long totalTempoBBS = 0;
            int totalTrocasBBS = 0;
            int totalIteracoesBBS = 0;

            long totalTempoSS = 0;
            int totalTrocasSS = 0;
            int totalIteracoesSS = 0;

            long totalTempoHS = 0;
            int totalTrocasHS = 0;
            int totalIteracoesHS = 0;

            for (int j = 0; j < repeticoes; j++) {
                int[] vetorBBS = generateRandomArray(sizes[i]); // Crie um vetor aleatório
                long[] resultadosBBS = Ordenacao.bubbleSort(vetorBBS, sizes[i]);
                totalTempoBBS += resultadosBBS[0];
                totalTrocasBBS += resultadosBBS[1];
                totalIteracoesBBS += resultadosBBS[2];

                int[] vetorSS = generateRandomArray(sizes[i]); // Crie um vetor aleatório
                long[] resultadosSS = Ordenacao.shellSort(vetorSS, sizes[i]);
                totalTempoSS += resultadosSS[0];
                totalTrocasSS += resultadosSS[1];
                totalIteracoesSS += resultadosSS[2];

                int[] vetorHS = generateRandomArray(sizes[i]); // Crie um vetor aleatório
                long[] resultadosHS = Ordenacao.heapSort(vetorHS, sizes[i]);
                totalTempoHS += resultadosHS[0];
                totalTrocasHS += resultadosHS[1];
                totalIteracoesHS += resultadosHS[2];
            }

            double mediaTempo = (double) totalTempoBBS / repeticoes;
            double mediaTrocas = (double) totalTrocasBBS / repeticoes;
            double mediaIteracoes = (double) totalIteracoesBBS / repeticoes;

            System.out.println("Bubble Sort");
            System.out.println("Vetor de tamanho: " + sizes[i]);
            System.out.println("Média de tempo de execução em (ns): " + mediaTempo);
            System.out.println("Média de número de iterações: " + mediaIteracoes);
            System.out.println("Média de número de trocas: " + mediaTrocas);
            System.out.println("-------------------------------------------------------");

            double mediaTempoSS = (double) totalTempoSS / repeticoes;
            double mediaTrocasSS = (double) totalTrocasSS / repeticoes;
            double mediaIteracoesSS = (double) totalIteracoesSS / repeticoes;

            System.out.println("Shell Sort");
            System.out.println("Vetor de tamanho: " + sizes[i]);
            System.out.println("Média de tempo de execução em (ns): " + mediaTempoSS);
            System.out.println("Média de número de iterações: " + mediaIteracoesSS);
            System.out.println("Média de número de trocas: " + mediaTrocasSS);
            System.out.println("-------------------------------------------------------");

            double mediaTempoHS = (double) totalTempoHS / repeticoes;
            double mediaTrocasHS = (double) totalTrocasHS / repeticoes;
            double mediaIteracoesHS = (double) totalIteracoesHS / repeticoes;

            System.out.println("Heap Sort");
            System.out.println("Vetor de tamanho: " + sizes[i]);
            System.out.println("Média de tempo de execução em (ns): " + mediaTempoHS);
            System.out.println("Média de número de iterações: " + mediaIteracoesHS);
            System.out.println("Média de número de trocas: " + mediaTrocasHS);
            System.out.println("-------------------------------------------------------");
        }
    }


    static int[] generateRandomArray(int n) {
        int[] arr = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(n); // Gere números aleatórios entre 0 e 99 (você pode ajustar o intervalo conforme necessário)
        }

        return arr;
    }
}
