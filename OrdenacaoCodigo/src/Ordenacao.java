public class Ordenacao {

    static long[] bubbleSort(int[] vetor, int tamanho) {
        long tempoInicial = System.nanoTime();
        long[] resultados = new long[3];
        resultados[1] = 0; // Inicializa total de trocas
        resultados[2] = 0; // Inicializa total de iterações

        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - i - 1; j++) {
                resultados[2]++; // Incrementa o total de iterações
                if (vetor[j] > vetor[j + 1]) {
                    // Troca os elementos
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                    resultados[1]++; // Incrementa o total de trocas
                }
            }
        }


        long tempoFinal = System.nanoTime();
        resultados[0] = tempoFinal - tempoInicial; // Tempo de execução

        return resultados;
    }

    static long[] shellSort(int[] nums, int tamanho) {
        long[] resultados = new long[3];
        resultados[1] = 0; // Inicializa total de trocas
        resultados[2] = 0; // Inicializa total de iterações

        long inicioT = System.nanoTime();
        //System.out.println("------------------------------------");
        //System.out.println("Shell sort");
        //System.out.println("Tamanho do vetor: " + tamanho);
        int h = 1;

        while (h < tamanho) {
            h = h * 3 + 1;
        }

        h = h / 3;
        int c, j;

        while (h > 0) {
            for (int i = h; i < tamanho; i++) {
                resultados[2]++; // Incrementar o contador de iterações
                c = nums[i];
                j = i;
                while (j >= h && nums[j - h] > c) {
                    resultados[1]++; // Incrementar o contador de trocas
                    nums[j] = nums[j - h];
                    j = j - h;
                }
                nums[j] = c;
            }
            h = h / 2;
        }

        long fimT = System.nanoTime();
        resultados[0] = fimT - inicioT; // Tempo de execução

        //System.out.println("Tempo de execução em (ns): " + resultados[0]);
        //System.out.println("Número de iterações: " + resultados[2]);
        //System.out.println("Número de trocas: " + resultados[1]);
        //System.out.println("------------------------------------");

        return resultados;
    }



    static long[] heapSort(int[] vetor, int tamanho) {
        long[] resultados = new long[3];
        resultados[1] = 0; // Inicializa total de trocas
        resultados[2] = 0; // Inicializa total de iterações

        long inicioT = System.nanoTime();

        int i = tamanho / 2, pai, filho, t;

        while (true) {
            resultados[2]++; // Incrementa o contador de iterações
            if (i > 0) {
                i--;
                t = vetor[i];
            } else {
                tamanho--;
                if (tamanho <= 0) {
                    break; // Usamos 'break' em vez de 'return'
                }
                t = vetor[tamanho];
                vetor[tamanho] = vetor[0];
                resultados[1]++; // Incrementa o contador de trocas
            }

            pai = i;
            filho = (i * 2) + 1;
            while (filho < tamanho) {
                resultados[2]++; // Incrementa o contador de iterações
                if (filho + 1 < tamanho && vetor[filho + 1] > vetor[filho]) {
                    filho++;
                }
                if (vetor[filho] > t) {
                    vetor[pai] = vetor[filho];
                    pai = filho;
                    filho = pai * 2 + 1;
                    resultados[1]++; // Incrementa o contador de trocas
                } else {
                    break;
                }
            }
            vetor[pai] = t;
        }

        long fimT = System.nanoTime();
        resultados[0] = fimT - inicioT; // Tempo de execução

        return resultados;
    }

}
