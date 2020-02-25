import java.util.Hashtable;
 
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length != popA.length) {
            return false;
        } else if (pushA.length == 1 && pushA[0] != popA[0]) {
            return false;
        }

        Hashtable<Integer, Integer> m = new Hashtable<>();
        for (int i = 0; i < pushA.length; ++i) {
            m.put(pushA[i], i);
        }

        int baseIdx = m.get(popA[0]);
        int smallIdx = baseIdx - 1;
        int bigIdx = baseIdx;
        for (int i = 1; i < popA.length; ++i) {
            int curIdx = m.get(popA[i]);

            if (curIdx == smallIdx) {
                --smallIdx;
            } else if (curIdx == bigIdx) {
                --bigIdx;
            } else if (curIdx == baseIdx + 1) {
                ++baseIdx;
            } else if (curIdx > baseIdx + 1) {
                baseIdx = curIdx;
                bigIdx = baseIdx - 1;
            } else {
                return false;
            }
        }

        return true;
    }
}