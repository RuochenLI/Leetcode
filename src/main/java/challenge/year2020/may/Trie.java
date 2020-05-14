package challenge.year2020.may;

/**
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */
class Trie {

    private Trie[] children;
    private boolean containsWord;

    /** Initialize your data structure here. */
    public Trie() {
        this.children = new Trie[26];
        this.containsWord = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        insertNode(word.toCharArray(), 0);
    }

    private void insertNode(final char[] chars, int pointer) {
        if (pointer == chars.length) {
            this.containsWord = true;
            return;
        }

        int childIndex = getChildIndex(chars[pointer]);
        if (this.children[childIndex] != null) {
            this.children[childIndex].insertNode(chars, pointer + 1);
            return;
        }

        Trie newNode = new Trie();
        this.children[childIndex] = newNode;
        newNode.insertNode(chars, pointer + 1);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return this.searchInTrie(word.toCharArray(), 0, false);
    }

    private boolean searchInTrie(final char[] chars, final int pointer, final boolean withPrefix) {
        if (pointer == chars.length) return this.containsWord || withPrefix;

        Trie child = this.children[getChildIndex(chars[pointer])];
        if (child == null) return false;

        return child.searchInTrie(chars, pointer + 1, withPrefix);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return  this.searchInTrie(prefix.toCharArray(), 0, true);
    }

    private int getChildIndex(char value) {
        return value - 'a';
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

/** 1st version
 class Trie {

 private Node root;

public Trie() {
    this.root = new Node(null);
}

    public void insert(String word) {
        insertNode(this.root, word.toCharArray(), 0);
    }

    private void insertNode(final Node node, final char[] chars, int pointer) {
        if (pointer == chars.length) {
            Node newNode = new Node(null);
            node.addChild('$', newNode);
            return;
        }

        if (node.getChildren().containsKey(chars[pointer])) {
            insertNode(node.getChildren().get(chars[pointer]), chars, pointer + 1);
            return;
        }

        Node newNode = new Node(chars[pointer]);
        node.addChild(chars[pointer], newNode);
        insertNode(newNode, chars, pointer + 1);
    }

    public boolean search(String word) {
        return searchInTrie(this.root, word.toCharArray(), 0, false);
    }

    private boolean searchInTrie(final Node node, final char[] chars, final int pointer, final boolean withPrefix) {
        if (pointer == chars.length) return node.getChildren().containsKey('$') || withPrefix;

        if (node.getChildren().get(chars[pointer]) == null) return false;

        return searchInTrie(node.getChildren().get(chars[pointer]), chars, pointer + 1, withPrefix);
    }

    public boolean startsWith(String prefix) {
        return  searchInTrie(this.root, prefix.toCharArray(), 0, true);
    }

class Node {
    private Character value;
    private Map<Character, Node> children;

    Node(Character value) {
        this.value = value;
        this.children = new HashMap<>();
    }

    char getValue() {
        return this.value;
    }

    Map<Character, Node> getChildren() {
        return this.children;
    }

    void addChild(Character key, Node child) {
        this.children.put(key, child);
    }
}
}

 */
