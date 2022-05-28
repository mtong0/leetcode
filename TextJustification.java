import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> arr = new ArrayList<>();
        List<Integer> lengths = new ArrayList<>();
        arr.add(new ArrayList<>());

        boolean empty = true;
        List<String> layer;
        int count;

        layer = arr.get(0);
        count = 0;
        for (int j = 0; j < words.length; j++) {
            String word = words[j];
            if (empty) {
                layer.add(word);
                count += word.length();
                empty = false;
            } else if (count + word.length() + 1 <= maxWidth) {
                layer.add(word);
                count += (word.length() + 1);
            }
            if (j + 1 < words.length) {
                String nextWord = words[j + 1];
                if (count + nextWord.length() + 1 > maxWidth) {
                    lengths.add(count);
                    layer = new ArrayList<>();
                    count = 0;
                    arr.add(layer);
                    empty = true;
                }
            }
        }

        List<String> res = new ArrayList<>();
        List<String> l;
        int wordNum ;
        int chCount;
        int divideSpace;
        int remainSpace;
        for (int i = 0; i < arr.size()-1; i++) {
            l = arr.get(i);
            wordNum = l.size();
            chCount = lengths.get(i);
            divideSpace = (maxWidth-chCount+wordNum-1)/(wordNum-1);
            remainSpace = (maxWidth-chCount+wordNum-1)%(wordNum-1);
            StringBuilder ans = new StringBuilder(l.get(0));
            for (int j = 1; j < l.size(); j++) {
                if (remainSpace > 0) {
                    ans.append(" ");
                    remainSpace--;
                }
                ans.append(" ".repeat(divideSpace)).append(l.get(j));
            }
            res.add(ans.toString());
        }
        l = arr.get(arr.size()-1);
        StringBuilder lastLine = new StringBuilder(l.get(0));

        for (int i = 1; i < l.size(); i++) {
            lastLine.append(" ");
            lastLine.append(l.get(i));
        }
        if (lastLine.length() < maxWidth) {
            lastLine.append(" ".repeat(maxWidth-lastLine.length()));
        }
        res.add(lastLine.toString());
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        new TextJustification().fullJustify(words, maxWidth);

    }
}
