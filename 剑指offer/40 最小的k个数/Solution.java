import java.util.*;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input.length < k) return res;
        
        Queue<Integer> pq = new PriorityQueue<>();
        for (int n : input) pq.add(n);

        for (int i = 0; i < k; i++) res.add(pq.remove());
        return res;
    }
}