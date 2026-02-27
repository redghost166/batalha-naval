public enum Casa {
    VAZIA("Vazia","~"), NAVIO("Navio","N"), TIRO_ERRADO("Tiro Errado","X"), TIRO_ACERTADO("Tiro Acertado","O");


    private final String descricao;
    private final String representacao;

    Casa(String descricao, String representacao) {
        this.descricao = descricao;
        this.representacao = representacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getRepresentacao() {
        return representacao;
    }
}
