# SortBench 📊

Sistema de **benchmarking de algoritmos de ordenação** em Java, desenvolvido como APS da disciplina de **Estrutura de Dados** (UNIP).

Cada algoritmo conta quantas **comparações** e **trocas** faz durante a ordenação, o que permite comparar o desempenho de cada um na prática, além da complexidade teórica.

> 🚧 Projeto em desenvolvimento.

## 🧮 Algoritmos implementados

| Algoritmo | Complexidade | Ideia |
|---|---|---|
| **InsertionSort** | O(n²) | Pega um elemento por vez e encaixa no lugar certo entre os já ordenados, como cartas na mão |
| **HeapSort** | O(n log n) | Monta um heap máximo dentro do próprio vetor e manda o maior elemento para o fim a cada passo |
| **QuickSort (Dual-Pivot)** | O(n log n) | Usa dois pivôs para dividir o trecho em três partes (menores, entre os pivôs, maiores) e ordena cada uma recursivamente |
| **RadixSort LSD** | O(d·n) | Ordena dígito a dígito, do menos significativo ao mais significativo, usando contagem; aceita números negativos |

## 🏗️ Estrutura

```
src/
├── Main.java                         # Demonstração: ordena vetores de exemplo e mostra as métricas
└── algoritmos/
    ├── AlgoritmoOrdenacao.java       # Classe abstrata base (contadores, troca, nome, complexidade)
    ├── InsertionSort.java
    ├── HeapSort.java
    ├── QuickSortDualPivot.java
    └── RadixSortLSD.java
```

Todos os algoritmos herdam de `AlgoritmoOrdenacao`, que define:

- `ordenar(int[] vetor)`: o algoritmo em si
- `getNome()` e `getComplexidade()`: identificação do algoritmo
- `getComparacoes()` e `getTrocas()`: métricas coletadas (em `long`, porque passam de 2 bilhões com vetores grandes)
- `zerarContadores()`: reinicia as métricas entre um teste e outro

Assim, adicionar um novo algoritmo é só criar uma classe filha e implementar esses métodos.

## ▶️ Como rodar

Requer **Java 21**.

**NetBeans:** abra a pasta do projeto e execute (`F6`).

**Terminal:**

```bash
git clone https://github.com/oviniav/SortBench-APS.git
cd SortBench-APS
javac -d out src/Main.java src/algoritmos/*.java
java -cp out Main
```

Exemplo de saída:

```
[1, 2, 3, 4, 5, 9]
Comparações: 11 | Trocas: 13
```

## 🛠️ Tecnologias

Java 21 · NetBeans (Ant)

## 🚧 Próximos passos

- [ ] MergeSort
- [ ] Geração de vetores de teste (aleatório, ordenado, inverso) em vários tamanhos
- [ ] Medição de tempo de execução
- [ ] Tabela/relatório comparando todos os algoritmos
- [ ] Testes automatizados

## 👤 Autor

**Vinicius Alberto**, estudante de TI na UNIP
[GitHub](https://github.com/oviniav) · [LinkedIn](https://www.linkedin.com/in/vini0209vicente)
