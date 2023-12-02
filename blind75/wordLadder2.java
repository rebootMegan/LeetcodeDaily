//package blind75;
//
//import java.util.*;
//
//public class wordLadder2 {
//    /**
//     * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
//     * Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
//     * Explanation: There are 2 shortest transformation sequences:
//     * "hit" -> "hot" -> "dot" -> "dog" -> "cog"
//     * "hit" -> "hot" -> "lot" -> "log" -> "cog"
//     * @param beginWord
//     * @param endWord
//     * @param wordList
//     * @return
//     */
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        Set<String> dict = new HashSet<>(wordList);
//        if (!dict.contains(endWord)) {
//            return new ArrayList<>();
//        }
//        Map<String, List<String>> adjacency = new HashMap<>();
//        Queue<String> queue = new LinkedList<>();
//        boolean found = false;
//        queue.offer(beginWord);
//        dict.remove(beginWord);
//        while (!found && !queue.isEmpty()) {
//            int size = queue.size();
//            HashSet<String> explored = new HashSet<>();
//            while (size -- > 0) {
//                String word = queue.poll();
//                if (adjacency.containsKey(word)) {
//                    continue;
//                }
//                dict.remove(word);
//                List<String> adjacents = getAdjacents(word, dict);
//                adjacency.put(word, adjacents);
//                for (String adj : adjacents) {
//                    if (!found && adj.equals(endWord)) {
//                        found = true;
//                    }
//                    explored.add(adj);
//                    queue.offer(adj);
//                }
//            }
//            for (String word :explored) {
//                dict.remove(word);
//            }
//        }
//        if (found) {
//            return dfs(beginWord, endWord, adjacency, new HashMap<>());
//        }else {
//            return new ArrayList<>();
//        }
//    }
//
//    //25 chars for each char in word
//    private List<String> getAdjacents(String word, Set<String> dict) {
//        List<String> adjs = new ArrayList<>();
//        char[] wordChars = word.toCharArray();
//        for (int i = 0; i < wordChars.length; i++) {
//            for (char c = 'a'; c <= 'z'; c++) {
//                char temp = wordChars[i];
//                wordChars[i] = c;
//                String newadj = new String(wordChars);
//                if (dict.contains(newadj)) {
//                    adjs.add(newadj);
//                }
//                wordChars[i] = temp;
//            }
//        }
//        return adjs;
//    }
//    private List<List<String>> dfs(String src, String dest, Map<String, List<String>> adjacency,
//                                   Map<String, List<List<String>>> memo) {
//        if (memo.containsKey(src)) {
//            return memo.get(src);
//        }
//        List<List<String>> paths = new ArrayList<>();
//         if (src.equals(dest)) {
//             paths.add(new ArrayList<>(){{add(dest);}});
//             return paths;
//         }
//         List<String> adjacents = adjacency.get(src);
//         if (adjacents == null || adjacents.isEmpty()) {
//             return paths;
//         }
//         for (String adj : adjacents) {
//             List<List<String>> adjPaths = dfs(adj, dest, adjacency, memo);
//             for (List<String> path : adjPaths) {
//                 if (path.isEmpty()) continue;
//                 List<String> newPath = new ArrayList<>(){{add(src);}};
//                 newPath.addAll(path);
//                 paths.add(newPath);
//             }
//         }
//         memo.put(src, paths);
//         return paths;
//    }
//}
