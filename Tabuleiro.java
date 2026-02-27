public class Tabuleiro {
    private Casa[][] casas;
    private int tamanhoTabuleiro;
    private int naviosRestantes;

    public Tabuleiro(int tamanhoTabuleiro, int quantidadeNavios) {
        this.tamanhoTabuleiro = tamanhoTabuleiro;
        this.naviosRestantes = quantidadeNavios;
        this.casas = new Casa[this.tamanhoTabuleiro][this.tamanhoTabuleiro];
        for (int i = 0; i < this.tamanhoTabuleiro; i++) {
            for (int j = 0; j < this.tamanhoTabuleiro; j++) {
                this.casas[i][j] = Casa.VAZIA;
            }
        }
    }

    public void imprimirTabuleiro(Boolean descrição) {
        if (descrição) {
            System.out.println("Tabuleiro (Debug):");
            for (int i = 0; i < this.tamanhoTabuleiro; i++) {
                for (int j = 0; j < this.tamanhoTabuleiro; j++) {
                    System.out.print(this.casas[i][j].getDescricao() + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        if (!descrição) {
            for (int i = 0; i < this.tamanhoTabuleiro; i++) {
                for (int j = 0; j < this.tamanhoTabuleiro; j++) {
                    System.out.print(this.casas[i][j].getRepresentacao() + " ");
                }
                System.out.println();
            }
        }
    }

    public void posicionarNavio(int linha, int coluna) {
        this.casas[linha][coluna] = Casa.NAVIO;
    }

    public void posicionarNavioAleatoriamente(int quantidadeNavios) {
        for (int i = 0; i < quantidadeNavios; i++) {
            int linha = (int) (Math.random() * this.tamanhoTabuleiro);
            int coluna = (int) (Math.random() * this.tamanhoTabuleiro);
            while (this.casas[linha][coluna] != Casa.VAZIA) {
                linha = (int) (Math.random() * this.tamanhoTabuleiro);
                coluna = (int) (Math.random() * this.tamanhoTabuleiro);
            }
            this.casas[linha][coluna] = Casa.NAVIO;
        }
    }

    public Casa getCasa(int linha, int coluna) {
        return this.casas[linha][coluna];
    }

    public void setCasa(int linha, int coluna, Casa valor) {
        this.casas[linha][coluna] = valor;
    }

    public void bombardiar(Tabuleiro adversario, int linha, int coluna) {
       if (linha >= tamanhoTabuleiro || coluna >= tamanhoTabuleiro || linha < 0 || coluna < 0) {
           System.out.println("Coordenadas inválidas!");
           return;
       }
       
        if (adversario.getCasa(linha, coluna) == Casa.NAVIO) {
            this.setCasa(linha, coluna, Casa.TIRO_ACERTADO);
            adversario.naviosRestantes--;
            if (adversario.naviosRestantes <= 0) {
                System.out.println("Parabéns! Você venceu!");
                System.exit(0);
            }
        }
        else {
            this.setCasa(linha, coluna, Casa.TIRO_ERRADO);
        }

    }
}