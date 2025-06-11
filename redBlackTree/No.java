package redBlackTree;

public class No {
    
    private int conteudo;
    private No pai;
    private No filhoDireito;
    private No filhoEsquerdo;
    private boolean cor; 

    public static final boolean VERMELHO = true;
    public static final boolean PRETO = false;

    public No(int conteudo) {
        this.conteudo = conteudo;
        this.cor = VERMELHO;
        this.pai = null;
        this.filhoDireito = null;
        this.filhoEsquerdo = null;
    }

    public No getPai() {
        return pai;
    }
    
    public void setPai(No pai) {
        this.pai = pai;
    }
    
    public boolean isVermelho() {
        return cor == VERMELHO;
    }
    
    public void setCor(boolean cor) {
        this.cor = cor;
    }

    public No getFilhoDireito() {
        return filhoDireito;
    }
    
    public void setFilhoDireito(No filhoDireito) {
        this.filhoDireito = filhoDireito;
    }

    public No getFilhoEsquerdo() {
        return filhoEsquerdo;
    }
    
    public void setFilhoEsquerdo(No filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public int getConteudo() {
        return conteudo;
    }
    
    public void setConteudo(int conteudo) {
        this.conteudo = conteudo;
    }
}
