package category.trie;

/**
 * 01字典树
 *
 * @author lipeng
 */
public class Trie01 {
    private static class TrieNode {
        TrieNode[] next = new TrieNode[2];
        int val = -1;
    }

    TrieNode root;

    public Trie01() {
        this.root = new TrieNode();
    }

    public void insert(int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; --i) {
            int val = (num >>> i) & 1;
            if (node.next[val] == null) {
                node.next[val] = new TrieNode();
            }
            node = node.next[val];
        }
        node.val = num;
    }

    public int search(int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; --i) {
            int val = (num >>> i) & 1;
            int rval = val == 0 ? 1 : 0;
            if (node.next[rval] != null) {
                node = node.next[rval];
            } else {
                node = node.next[val];
            }
        }
        return node.val;
    }
}
