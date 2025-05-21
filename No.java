public class No {
    private Integer conteudo;
    private No filhoEsquerdo;
    private No filhoDireito;



    public No(Integer conteudo) {
        this.conteudo = conteudo;
        this.filhoDireito = null;
        this.filhoEsquerdo = null;
    }

    public Integer getConteudo() {
        return conteudo;
    }

    public void setConteudo(Integer conteudo) {
        this.conteudo = conteudo;
    }

    public No getFilhoEsquerdo() {
        return filhoEsquerdo;
    }

    public void setFilhoEsquerdo(No filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public No getFilhoDireito() {
        return filhoDireito;
    }

    public void setFilhoDireito(No filhoDireito) {
        this.filhoDireito = filhoDireito;
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