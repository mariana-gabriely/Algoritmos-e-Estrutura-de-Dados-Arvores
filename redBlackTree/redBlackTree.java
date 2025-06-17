package redBlackTree;

public class redBlackTree {

    No raiz;

    public No getRaiz() {
        return raiz;
    }

    public void inserir(int valor) {
        raiz = inserir(raiz, valor);
    }

    public No inserir(No no, int valor) {
        if (no == null) {
            No novoNo = new No(valor);

            if (raiz == null) {
                novoNo.setCor(No.PRETO);
                raiz = novoNo;
            }
            return novoNo;
        } else {
            if (valor >= no.getConteudo()) {
                No filho = inserir(no.getFilhoDireito(), valor);
                if (filho != null) {
                    filho.setPai(no);
                    no.setFilhoDireito(filho);
                    corrigirCor(filho);
                }
            } else {
                No filho = inserir(no.getFilhoEsquerdo(), valor);
                if (filho != null) {
                    filho.setPai(no);
                    no.setFilhoEsquerdo(filho);
                    corrigirCor(filho);
                }
            }
        }
        return no;
    }

    public No rotacaoSimplesEsquerda(No no) {
        No novoNo = no.getFilhoDireito();
        no.setFilhoDireito(novoNo.getFilhoEsquerdo());
        if (novoNo.getFilhoEsquerdo() != null) {
            novoNo.getFilhoEsquerdo().setPai(no);
        }
        novoNo.setPai(no.getPai());
        if (no.getPai() != null) {
            if (no == no.getPai().getFilhoEsquerdo()) {
                no.getPai().setFilhoEsquerdo(novoNo);
            } else {
                no.getPai().setFilhoDireito(novoNo);
            }
        } else {
            raiz = novoNo;
        }
        novoNo.setFilhoEsquerdo(no);
        no.setPai(novoNo);
        return novoNo;
    }

    public No rotacaoSimplesDireita(No no) {
        No novoNo = no.getFilhoEsquerdo();
        no.setFilhoEsquerdo(novoNo.getFilhoDireito());
        if (novoNo.getFilhoDireito() != null) {
            novoNo.getFilhoDireito().setPai(no);
        }
        novoNo.setPai(no.getPai());
        if (no.getPai() != null) {
            if (no == no.getPai().getFilhoDireito()) {
                no.getPai().setFilhoDireito(novoNo);
            } else {
                no.getPai().setFilhoEsquerdo(novoNo);
            }
        } else {
            raiz = novoNo;
        }
        novoNo.setFilhoDireito(no);
        no.setPai(novoNo);
        return novoNo;
    }

    //corrigir cor caso inserção
    public void corrigirCor(No filho) {
        if (filho.getPai() == null || filho.getPai().getPai() == null)
            return;

        //cor do pai eh vermelha
        if (filho.getPai().isVermelho()) {
            // Pai à esquerda
            if (filho.getPai() == filho.getPai().getPai().getFilhoEsquerdo()) {
                No tio = filho.getPai().getPai().getFilhoDireito();
                //se tio a direita existe e se for vermelho CASO 2
                if (tio != null && tio.isVermelho()) {
                    filho.getPai().setCor(No.PRETO);
                    tio.setCor(No.PRETO);
                    if (filho.getPai().getPai() != raiz) {
                        filho.getPai().getPai().setCor(No.VERMELHO);
                        corrigirCor(filho.getPai().getPai());
                    }
                } else if (filho == filho.getPai().getFilhoEsquerdo()) {
                    No novo = rotacaoSimplesDireita(filho.getPai().getPai());
                    novo.getFilhoDireito().setCor(No.VERMELHO);
                    novo.getFilhoEsquerdo().setCor(No.VERMELHO);
                    novo.setCor(No.PRETO);
                } else {
                    No novo = rotacaoSimplesEsquerda(filho.getPai());
                    No n = rotacaoSimplesDireita(novo.getPai());
                    n.getFilhoDireito().setCor(No.VERMELHO);
                    n.getFilhoEsquerdo().setCor(No.VERMELHO);
                    n.setCor(No.PRETO);
                }
            } else {
                // pai à direita
                No tio = filho.getPai().getPai().getFilhoEsquerdo();
                //se tio a esquerda existe e for vermelho CASO 2
                if (tio != null && tio.isVermelho()) {
                    filho.getPai().setCor(No.PRETO);
                    tio.setCor(No.PRETO);
                    if (filho.getPai().getPai() != raiz) {
                        filho.getPai().getPai().setCor(No.VERMELHO);
                        corrigirCor(filho.getPai().getPai());
                    }
                } else if (filho == filho.getPai().getFilhoDireito()) {
                    // Rotação simples esquerda 3b
                    No novo = rotacaoSimplesEsquerda(filho.getPai().getPai());
                    novo.getFilhoDireito().setCor(No.VERMELHO);
                    novo.getFilhoEsquerdo().setCor(No.VERMELHO);
                    novo.setCor(No.PRETO);
                } else {
                    // Rotação dupla direita 3d
                    No novo = rotacaoSimplesDireita(filho.getPai());
                    No n = rotacaoSimplesEsquerda(novo.getPai());
                    n.getFilhoDireito().setCor(No.VERMELHO);
                    n.getFilhoEsquerdo().setCor(No.VERMELHO);
                    n.setCor(No.PRETO);
                }
            }
        }
    }
}
