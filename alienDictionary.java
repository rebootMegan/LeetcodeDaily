import java.util.*;


public class alienDictionary {
    /**
     * You are given a list of strings words from the alien language's dictionary. Now it is claimed that the strings in words are
     * sorted lexicographically
     *  by the rules of this new language.
     *
     * If this claim is incorrect, and the given arrangement of string in words cannot correspond to any order of letters, return "".
     *
     * Otherwise, return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. If there are multiple solutions, return any of them.
     */
    public String alienOrder(String[] words) {
        //step 0 create data structures and find all unique letters
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> counts = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                counts.put(c,0);
                adjList.put(c, new ArrayList<>());
            }
        }
        //step 1 find all edges
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            //check that word2 is not a prefix of word1
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            //find the first non match and insert the corresponding relation
            for (int j =0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    counts.put(word2.charAt(j), counts.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }
        //step2 bfs
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (Character c : counts.keySet()) {
            if (counts.get(c).equals(0)) {
                queue.add(c);
            }
        }
        while (!queue.isEmpty()) {
            Character c = queue.remove();
            sb.append(c);
            for (Character next : adjList.get(c)) {
                counts.put(next, counts.get(next) - 1);
                if (counts.get(next).equals(0)) {
                    queue.add(next);
                }
            }
        }
        if (sb.length() < counts.size()) {
            return "";
        }
        return sb.toString();
    }
}
