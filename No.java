public class No {
    private Integer conteudo;
    private No filhoEsquerdo;
    private No filhoDireito;
    private int fatorBalanceamento;

    public No(Integer conteudo) {
        this.conteudo = conteudo;
        this.filhoDireito = null;
        this.filhoEsquerdo = null;
        this.fatorBalanceamento = 0;
    }

    public Integer getConteudo() {
        return this.conteudo;
    }

    public void setConteudo(Integer conteudo) {
        this.conteudo = conteudo;
    }

    public No getFilhoEsquerdo() {
        return this.filhoEsquerdo;
    }

    public void setFilhoEsquerdo(No filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public No getFilhoDireito() {
        return this.filhoDireito;
    }

    public void setFilhoDireito(No filhoDireito) {
        this.filhoDireito = filhoDireito;
    }

    public int getFatorBalanceamento() {
        return this.fatorBalanceamento;
    }

    public void setFatorBalanceamento(int fatorBalanceamento) {
        this.fatorBalanceamento = fatorBalanceamento;
    }

    public void inserir(Integer conteudo) {
        if (conteudo < this.conteudo) {
            if (this.filhoEsquerdo == null) {
                this.filhoEsquerdo = new No(conteudo);
            } else {
                this.filhoEsquerdo.inserir(conteudo);
            }
        } else if (conteudo > this.conteudo) {
            if (this.filhoDireito == null) {
                this.filhoDireito = new No(conteudo);
            } else {
                this.filhoDireito.inserir(conteudo);
            }
        }
    }
}