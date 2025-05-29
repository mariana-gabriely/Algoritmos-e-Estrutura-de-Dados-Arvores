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

        System.out.println("\nContagem de nós: " + arvore.contarNosIterativo());

        System.out.println("\nNós em pré-ordem: ");
        arvore.preOrdemIterativo();

        System.out.println("\nNós em em-ordem: ");
        arvore.emOrdemIterativo();

        System.out.println("\nNós em pós-ordem: ");
        arvore.posOrdemIterativo();

        System.out.println("\nNós em nível: ");
        arvore.emNivel();

        System.out.println("Nós folha: " + arvore.contarNosFolha(arvore.getRaiz()));
        System.out.println("Nós folha: " + arvore.contarNosFolhaIterativo());
    }
}