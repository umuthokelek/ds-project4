public class Trie {
    private class TrieNode {
        private TrieNode[] child;
        private boolean end;

        public TrieNode() {
            child = new TrieNode[26];
            end = false;
        }
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode newNode = current.child[word.charAt(i) - 'a'];
            if (newNode == null) {
                newNode = new TrieNode();
                current.child[word.charAt(i) - 'a'] = newNode;
            }
            current = newNode;
        }
        current.end = true;
    }

}
