public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        arvore.inserir(6);
        arvore.inserir(4);
        arvore.inserir(2);
        arvore.inserir(5);
        arvore.inserir(7);
        arvore.inserir(9);
        arvore.inserir(11);

        System.out.println("Árvore criada com sucesso!");

        arvore.contarNos();
        
        System.out.println("\nNós em pré-ordem: ");
        arvore.preOrdem(arvore.getRaiz());

        System.out.println("\nNós em em-ordem: ");
        arvore.emOrdem(arvore.getRaiz());
    }
}