package blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lc40 {
    public List<List<Integer>> combination2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        LinkedList<Integer> comb = new LinkedList<>();
        backtrack(candidates, comb, target, 0, result);
        return result;
    }

    private void backtrack(int[] candidates, LinkedList<Integer> comb, int remain, int curr, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }
        for (int nextCur = curr; nextCur < candidates.length; ++nextCur) {
            if (nextCur > curr && candidates[nextCur] == candidates[nextCur- 1]) {
                continue;
            }
            int pick = candidates[nextCur];
            if (remain - pick < 0) break;
            backtrack(candidates, comb, remain - pick, nextCur + 1, result);
            comb.removeLast();
        }
    }
}
