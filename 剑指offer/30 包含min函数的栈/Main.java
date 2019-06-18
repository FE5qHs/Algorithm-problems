import java.util.Stack;

public class Solution {
    private Stack<Integer> s;
    private int min;

    Solution() {
        s = new Stack<>();
        min = 0;
    }

    public void push(int node) {
        if (s.empty() || min > node) {
            min = node;
        }
        s.push(node);
    }

    public void pop() {
        boolean flag = false;
        if (s.peek() == min) {
            flag = true;
        }
        
        s.pop();

        if (flag) {
            int newMin = s.peek();
            for (Integer x : s) {
                if (x < newMin) {
                    newMin = x;
                }
            }
            min = newMin;
        }
    }

    public int top() {
        return s.peek();
    }

    public int min() {
        return min;
    }
}