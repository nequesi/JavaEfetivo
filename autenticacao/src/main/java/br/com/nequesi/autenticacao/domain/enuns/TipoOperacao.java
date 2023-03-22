package br.com.nequesi.autenticacao.domain.enuns;

public enum TipoOperacao {
    LEITURA(1, "Leitura"),
    ESCRITA(2, "Escrita"),
    EXECUCAO(3, "Execução");

    private final int id;
    private final String descricao;

    TipoOperacao(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoOperacao fromId(int id) {
        for (TipoOperacao operacao : TipoOperacao.values()) {
            if (operacao.getId() == id) {
                return operacao;
            }
        }
        throw new IllegalArgumentException("Id de operação inválido: " + id);
    }
}
