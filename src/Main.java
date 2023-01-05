public class Main {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();

        avlTree.add(10);
        avlTree.add(20);
        avlTree.add(30);
        avlTree.add(40);
        avlTree.add(50);
        avlTree.add(25);
        avlTree.printPreOrder();

        Trie trie = new Trie();
        trie.insert("deneme");
        
    }
}
