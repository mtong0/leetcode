package src.algorithm.temp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSquares {
    int length;
    List<List<String>> res;
    char[][] square;

    public List<List<String>> wordSquares(String[] words) {
        length = words[0].length();
        res = new ArrayList<>();

        Trie trie = new Trie(Arrays.asList(words));
        for (String s: words) {
            trie.insert(s);
        }
        square = new char[length][length];
        backtrack(0, trie, "");
        return res;
    }

    public void backtrack(int idx, Trie trie, String prefix) {
        if (idx == length) {
            List<String> ans = new ArrayList<>();
            for (char[] word: square) {
                ans.add(String.copyValueOf(word));
            }
            res.add(ans);
            return;
        }
        List<String> list = trie.prefix(prefix);
        if (list == null)
            return;
        for (String s: list) {
            for (int i = 0; i < length; i++) {
                char ch = s.charAt(i);
                square[idx][i] = ch;
                square[i][idx] = ch;
            }

            StringBuilder nextPrefix = new StringBuilder();
            if (idx + 1 < length) {
                for (int i = 0; i < idx + 1; i++) {
                    nextPrefix.append(square[idx+1][i]);
                }
            }

            backtrack(idx + 1, trie, nextPrefix.toString());
        }
    }

    class Trie {
        TrieNode root;
        Trie(List<String> l) {
            root = new TrieNode(l);
        }
        void insert(String s) {
            root.insert(0, s);
        }
        boolean search(String s) {
            return root.search(0, s);
        }
        List<String> prefix(String s) {
            return root.prefix(0, s);
        }
        class TrieNode {
            char c;
            List<String> words;
            TrieNode[] children;
            boolean isWord;
            TrieNode(char c) {
                this.c = c;
                words = new ArrayList<>();
                children = new TrieNode[26];
            }

            TrieNode(List<String> l) {
                this.c = '0';
                words = l;
                children = new TrieNode[26];
            }

            void insert(int idx, String s) {
                if (idx == s.length()) {
                    isWord = true;
                    return;
                }
                char ch = s.charAt(idx);
                if (children[ch-'a'] == null) {
                    children[ch-'a'] = new TrieNode(ch);
                }
                children[ch-'a'].words.add(s);
                children[ch-'a'].insert(idx+1, s);
            }

            boolean search(int idx, String s) {
                if (idx == s.length() && isWord) {
                    return true;
                }
                if (idx == s.length()) {
                    return false;
                }
                char ch = s.charAt(idx);
                if (children[ch-'a'] == null) {
                    return false;
                } else {
                    return children[ch-'a'].search(idx + 1, s);
                }
            }

            List<String> prefix(int idx, String s) {
                if (s.equals("")) {
                    return words;
                }

                if (idx == s.length()) return words;

                char ch = s.charAt(idx);
                if (children[ch-'a'] == null) return null;
                return children[ch-'a'].prefix(idx+1, s);
            }
        }
    }
    public static void main(String[] args) {
        String[] words = {"area","lead","wall","lady","ball"};
        List<List<String>> res = new WordSquares().wordSquares(words);
        for(List<String> s: res) {
            System.out.println(s);
        }
    }
}
