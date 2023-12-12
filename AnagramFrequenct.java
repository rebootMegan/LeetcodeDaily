import java.util.*;

/**
 * 给一串 wordlist 比如 cats,csat, tsac, in, the, bat, tab
 * 再给你一个sentence list : [cats, in, the], [bat in csat]
 * 要求你返回anagram 的 product frequency
 * Ex: cats 有两个anagram, in 有一个, the 有一个, 所以第一个sentence是 2*1*1 = 2
 * Output: [2, 4]
 */
public class AnagramFrequenct {
    public static List<Integer> anagramProductFrequencies(List<String> wordlist, List<List<String>> sentences) {
        // 建立哈希表存储每个单词的变位词数量
        Map<String, Integer> count = new HashMap<>();
        for (String word : wordlist) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            count.put(sorted, count.getOrDefault(sorted, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (List<String> sentence : sentences) {
            int product = 1;
            for (String word : sentence) {
                char[] chars = word.toCharArray();
                Arrays.sort(chars);
                String sorted = new String(chars);
                int temp = count.getOrDefault(sorted, 0);
                if (temp > 1) {
                    product *= (temp - 1);
                }
            }
            result.add(product);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> wordlist = Arrays.asList("cats", "csat", "tsac", "in", "the", "bat", "tab");
        List<List<String>> sentences = Arrays.asList(
                Arrays.asList("cats", "in", "the"),
                Arrays.asList("bat", "in", "csat")
        );

        List<Integer> frequencies = anagramProductFrequencies(wordlist, sentences);
        System.out.println(frequencies);
    }
}