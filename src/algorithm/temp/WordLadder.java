package src.algorithm.temp;
import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int j = 0;
        for (; j < wordList.size(); j++) {
            if (wordList.get(j).equals(endWord)) break;
        }
        if (j == wordList.size()) return 0;

        HashMap<String, Integer> map = new HashMap<>();
        map.put(endWord, 2);

        Queue<String> testWords = new LinkedList<>();
        testWords.add(endWord);

        String nextWord;
        while (testWords.size() > 0) {
            nextWord = testWords.poll();
            for (String s: wordList) {
                if (!map.containsKey(s)&&checkDiff(nextWord, s)) {
                    map.put(s, map.get(nextWord) + 1);
                    testWords.add(s);
                } else if (map.containsKey(s) && map.get(s) > map.get(nextWord) + 1) {
                    map.put(s, map.get(nextWord) + 1);
                    testWords.add(s);
                }
            }
        }

        int shortest = Integer.MAX_VALUE;
        boolean found = false;
        for (String s: map.keySet()) {
            if (checkDiff(s, beginWord)) {
                if (map.get(s) < shortest) {
                    shortest = map.get(s);
                    found = true;
                }
            }
        }
        if (!found) return 0;
        return shortest;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> graph = new HashMap<>();
        for (String s: wordList) {
            graph.put(s, new ArrayList<>());
        }

        graph.put(beginWord, new ArrayList<>());

        for (String key: graph.keySet()) {
            for (String word: wordList) {
                if (checkDiff(key, word) && !key.equals(word)) {
                    graph.get(key).add(word);
                }
            }
        }

        if (!graph.containsKey(endWord)) return 0;

        Set<String> visited = new HashSet<>();
        Queue<String> wordQF = new LinkedList<>();
        Queue<String> wordQB = new LinkedList<>();
        Queue<String> nextWordQF = new LinkedList<>();
        Queue<String> nextWordQB = new LinkedList<>();
        wordQF.add(beginWord);
        wordQB.add(endWord);
        String wordF;
        String wordB;

        int frontLength = 0;
        int backLength = 0;

        while (wordQF.size() > 0) {
            wordF = wordQF.poll();
            if (visited.contains(wordF)) return frontLength + backLength;
            visited.add(wordF);
            for (String child: graph.get(wordF)) {
                if (!visited.contains(child)) {
                    nextWordQF.add(child);
                     visited.add(child);
                }
            }
            if (wordQF.size() == 0) {
                frontLength += 1;
                while (nextWordQF.size() > 0) wordQF.add(nextWordQF.poll());
                while (wordQB.size() > 0) {
                    wordB = wordQB.poll();
                    if (visited.contains(wordB)) return frontLength + backLength;
                    visited.add(wordB);
                    for (String child: graph.get(wordB)) {
                        if (!visited.contains(child)) {
                            nextWordQB.add(child);
                            visited.add(child);
                        }
                    }
                    if (wordQB.size() == 0) {
                        backLength += 1;
                        while (nextWordQB.size() > 0) wordQB.add(nextWordQB.poll());
                        break;
                    }
                }
            }
        }
        return 0;
    }

    public boolean checkDiff(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i)!=s2.charAt(i)) count++;
            if (count == 2) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String beginWord = "ymain";
        String endWord = "oecij";
        String[] words = {"ymann","yycrj","oecij","ymcnj","yzcrj","yycij","xecij","yecij","ymanj","yzcnj","ymain"};
        List<String> wordList = Arrays.asList(words);
        System.out.println(new WordLadder().ladderLength2(beginWord, endWord, wordList));
    }
}
