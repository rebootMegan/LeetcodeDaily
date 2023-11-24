import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        List<List<String>> result = new ArrayList<>();
        for (String w : products) {
            trie.insert(w);
        }
        String prefix = new String();
        for (char c: searchWord.toCharArray()) {
            prefix += c;
            result.add(trie.getWordsStartWith(prefix));
        }
        return result;
    }
}
class Trie {
    class Node {
        boolean isWord = false;
        List<Node> children = Arrays.asList(new Node[26]);
    }
    Node root, curr;
    List<String> result;
    public Trie() {
        root = new Node();
    }
    ////runs a DFS on trie starting with given prefix and adds all the words in the resultBuffer, limiting result size to 3
    public void dfsWithPrefix(Node curr, String word) {
        if (result.size() == 3) return;
        if (curr.isWord) {
            result.add(word);
        }
        for (char c = 'a'; c <='z'; c++) {
            if(curr.children.get(c- 'a') != null) {
                dfsWithPrefix(curr.children.get(c-'a'), word + c);
            }
        }
    }
    public void insert(String s) {
        curr =root;

        for (char c : s.toCharArray()) {
            if (curr.children.get(c - 'a') == null) {
                curr.children.set(c - 'a', new Node());
            }
            curr = curr.children.get(c - 'a');
        }
        curr.isWord = true;
    }
    public List<String> getWordsStartWith(String prefix) {
        curr =root;
        result = new ArrayList<>();
        for (char c : prefix.toCharArray()) {
            if (curr.children.get(c- 'a') == null) {
                return result;
            }
            curr = curr.children.get(c - 'a');
        }
        dfsWithPrefix(curr, prefix);
        return result;
    }
}
