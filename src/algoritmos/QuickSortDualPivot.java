package algoritmos;
//QuickSort com dois pivos: divide o trecho em tres partes
//menores que pivoMenor | entre os dois | maior que pivoMaior
//e ordena cada parte do msm jetio (recursao)

public class QuickSortDualPivot extends AlgoritmoOrdenacao {
    
    @Override
    public String getNome() {
        return "QuickSort (Dual-Pivot)";
    }
    
    @Override
    public String getComplexidade() {
        return "O(n log n)";
    }
    
    @Override
    public void ordenar(int[] vetor) {
        quickSort(vetor, 0, vetor.length - 1);
    }
    
    private void quickSort(int[] vetor, int inicio, int fim) {
        //treco com 1 elemento ou vazio
        if(inicio >= fim) {
            return;
        }
        
        //leva os elementos a 1/3 e 2/3 do trecho p as pontas, para servir de pivo (evita pior caso com vetor ja ordenado)
        int terco = (fim - inicio) / 3;
        trocar(vetor, inicio, inicio + terco);
        trocar(vetor, fim, fim - terco);
        
        //garante pivoMenor <= pivoMaior
        comparacoes++;
        if(vetor[inicio] > vetor[fim]) {
            trocar(vetor, inicio, fim);
        }
        
        int pivoMenor = vetor[inicio];
        int pivoMaior = vetor[fim];
        int limiteMenores = inicio + 1; //fim regiao menore
        int limiteMaiores = fim - 1; //começa da regiao dos maior
        int atual = inicio + 1; //elem analisa agr
        
        while(atual <= limiteMaiores) {
            comparacoes++;
            if(vetor[atual] < pivoMenor) {
                //e menor, vai para esquerda
                trocar(vetor, atual, limiteMenores);
                limiteMenores++;
            } else {
                comparacoes++;
                if(vetor[atual] > pivoMaior) {
                    //e maior vai p direita
                    while(atual < limiteMaiores) {
                        comparacoes++;
                        if(vetor[limiteMaiores] > pivoMaior) {
                            limiteMaiores++;
                        }else {
                            break;
                        }
                    }
                    //manda maior para dir
                    trocar(vetor, atual, limiteMaiores);
                    limiteMaiores--;
                    
                    //o elem que veio da dir pode ser menor q o pivoMenor
                    comparacoes++;
                    if(vetor[atual] < pivoMenor) {
                        trocar(vetor, atual, limiteMenores);
                        limiteMenores++;
                    }
                }
                //se n for menor nem maior fica no meio
            }
            atual++;
        }
        //coloca os 2 pivo nos lugares definitivos
        limiteMenores--;
        limiteMaiores++;
        trocar(vetor, inicio, limiteMenores);
        trocar(vetor, fim, limiteMaiores);
        
        //ordem as tres partes
        quickSort(vetor, inicio, limiteMenores - 1);
        if(pivoMenor < pivoMaior){
            //se o pivo é igual, o meio e todo igual e ja esta ordenado
            quickSort(vetor, limiteMenores + 1, limiteMaiores  - 1);
        }
        quickSort(vetor, limiteMaiores + 1, fim);
    }
}
