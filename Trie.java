import java.util.ArrayList;
import java.util.List;

public class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode('0');
    }

    public void insert(String word) {
        root.insert(0, word);
    }

    public boolean search(String word) {
        return root.search(0, word);
    }

    public boolean startsWith(String prefix) {
        return root.startsWith(0, prefix);
    }

    class TrieNode {
        List<String> words;
        char c;
        TrieNode[] nodes;
        boolean wordEnd;

        TrieNode(char c) {
            this.c = c;
            words = new ArrayList<>();
            nodes = new TrieNode[26];
        }

        void insert(int i, String s) {
            if(i == s.length()) {
                wordEnd = true;
                return;
            }
            char c = s.charAt(i);
            int idx = c-'a';
            if(nodes[idx] == null) {
                nodes[idx] = new TrieNode(c);
            }
            words.add(s);
            nodes[idx].insert(i+1, s);
        }

        boolean search(int i, String s) {
            if(i == s.length() && wordEnd) {
                return true;
            }
            if(i == s.length()) {
                return false;
            }

            char c = s.charAt(i);
            int idx = c-'a';
            if(nodes[idx] != null) {
                return nodes[idx].search(i+1, s);
            } else {
                return false;
            }
        }

        boolean startsWith(int i, String prefix)  {
            if(i == prefix.length()) {
                return true;
            }

            char c = prefix.charAt(i);
            int idx = c-'a';
            if(nodes[idx] != null) {
                return nodes[idx].startsWith(i+1, prefix);
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        boolean res = trie.startsWith("app");
        System.out.println(res);
    }
}
