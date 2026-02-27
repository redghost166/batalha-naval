import java.lang.foreign.SymbolLookup;
import java.util.Scanner;

public static void main(String[] args) {

    int tamanhoTabuleiro = 8;
    Tabuleiro tabuleiroJogador = new Tabuleiro(tamanhoTabuleiro,0);
    Tabuleiro tabuleiroComputador = new Tabuleiro(tamanhoTabuleiro,10);
    
    tabuleiroComputador.posicionarNavioAleatoriamente(10);

    //debug
    System.out.println("Tabuleiro do Computador:");
    tabuleiroComputador.imprimirTabuleiro(false);

    System.out.println("Tabuleiro do Jogador:");
    tabuleiroJogador.imprimirTabuleiro(false);

    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("Digite a linha e coluna para atacar (0-7):");
        int linha = scanner.nextInt();
        int coluna = scanner.nextInt();
        tabuleiroJogador.bombardiar(tabuleiroComputador, linha, coluna);
        System.out.println("Tabuleiro do Jogador:");
        tabuleiroJogador.imprimirTabuleiro(false);
    }

}