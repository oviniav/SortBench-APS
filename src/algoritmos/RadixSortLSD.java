package algoritmos;

public class RadixSortLSD extends AlgoritmoOrdenacao {

    @Override
    public String getNome() {
        return "RadixSortLSD";
    }

    @Override
    public String getComplexidade() {
        return "O(d.n)";
    }

    @Override
    public void ordenar(int[] vetor) {
        int n = vetor.length;
        if (n <= 1);

        int menor = vetor[0];
        int maior = vetor[0];

        for (int i = 1; i < n; i++) {
            if (vetor[i] < menor) {
                menor = vetor[i];
            }
            if (vetor[i] > maior) {
                maior = vetor[i];
            }
        }
        for (int i = 0; i < n; i++) {
            vetor[i] = vetor[i] - menor;
        }
        int maiorDeslocado = maior - menor;

        int[] saida = new int[n]; //vetor auxiliar usado em cada passada

        for (long posicao = 1; maiorDeslocado / posicao > 0; posicao = posicao * 10) {
            ordenarPorDigito(vetor, saida, posicao);
        }
        //desfaz o deslocamento: soma o menor de volta
        for (int i = 0; i < n; i++) {
            vetor[i] = vetor[i] + menor;
        }

    }

    private void ordenarPorDigito(int[] vetor, int[] saida, long posicao) {
        int n = vetor.length;
        int[] contagem = new int[10]; 
        
        for(int i = 0; i < n; i++) {
            int digito = (int) (vetor[i] / posicao % 10);
            contagem[digito]++;
        }
        
        for(int d = 1; d < 10; d++) {
            contagem[d] += contagem[d - 1];
        }
        
        for (int i = n - 1; i >= 0; i--) {
            int digito = (int) (vetor [i] / posicao % 10);
            saida[contagem[digito] - 1] = vetor[i];
            contagem[digito]--;         
        }
        
        for (int i = 0; i < n; i++) {
            vetor[i] = saida[i];
        }
         
    }

}
