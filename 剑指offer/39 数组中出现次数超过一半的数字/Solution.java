import java.util.*;

public class Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (0 == array.length) return 0;
        int res = 0;
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i : array) {
            if (m.containsKey(i)) {
                m.put(i, m.get(i) + 1);
            } else {
                m.put(i, 1);
            }
        }
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            if (e.getValue() > array.length / 2)
                res = e.getKey();
        }
        return res;
    }
}