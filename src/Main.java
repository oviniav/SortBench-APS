
public class Main {

    public static void main(String[] args) {
        int[] vetor = {5, 2, 4, 1, 9, 3};

        algoritmos.InsertionSort insertion = new algoritmos.InsertionSort();
        insertion.ordenar(vetor);

        System.out.println(java.util.Arrays.toString(vetor));
        System.out.println("Comparações: " + insertion.getComparacoes()
                + " | Trocas: " + insertion.getTrocas());

        int[] vetor2 = {5, 2, 4, 1, 9, 3};
        algoritmos.HeapSort heap = new algoritmos.HeapSort();
        heap.ordenar(vetor2);
        System.out.println(java.util.Arrays.toString(vetor2));
        System.out.println("Comparações: " + heap.getComparacoes() + " | Trocas: " + heap.getTrocas());
        
        // ↓↓↓ TRECHO NOVO ↓↓↓
        int[] vetor4 = {5, 2, 4, 1, 9, 3};
        algoritmos.QuickSortDualPivot quick = new algoritmos.QuickSortDualPivot();
        quick.ordenar(vetor4);
        System.out.println(java.util.Arrays.toString(vetor4));
        System.out.println("Comparações: " + quick.getComparacoes() + " | Trocas: " + quick.getTrocas());

        int[] vetor5 = {5, 2, 4, 1, 9, 3};
        algoritmos.RadixSortLSD radix = new algoritmos.RadixSortLSD();
        radix.ordenar(vetor5);
        System.out.println(java.util.Arrays.toString(vetor5));
        System.out.println("Comparações: " + radix.getComparacoes() + " | Trocas: " + radix.getTrocas());

        int[] vetor6 = {-5, 3, -2, 0, -40, 17, 3, -5};
        algoritmos.RadixSortLSD radixNeg = new algoritmos.RadixSortLSD();
        radixNeg.ordenar(vetor6);
        System.out.println(java.util.Arrays.toString(vetor6));
        // FIM DO TRECHO NOVO 
    }
}
