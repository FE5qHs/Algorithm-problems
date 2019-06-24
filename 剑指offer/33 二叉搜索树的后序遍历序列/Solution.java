/*
I don't think this version is the best answer to this 
problem, it won't be a good answer considering 
generalization. The same thing happens again: writing 
down some code that hard to modify according to 
different situations. I need to modify it and think 
about what is going wrong with my train of thought.
*/
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (0 == sequence.length) {
            return false;
        } else if (sequence.length <= 2) {
            return true;
        }

        int split = sequence.length - 1;
        int root = sequence[sequence.length - 1];
        for (int i = 0; i < sequence.length - 1; ++i) {
            if (sequence[i] > root) {
                split = i;
                break;
            }
        }
        for (int i = split; i < sequence.length - 1; ++i) {
            if (sequence[i] < root) {
                return false;
            }
        }

        boolean left = true;
        if (split >= 3) {
            int[] left_arr = new int[split];
            System.arraycopy(sequence, 0, left_arr, 0, split);
            left = VerifySquenceOfBST(left_arr);
        }
        boolean right = true;
        if (sequence.length - 1 - split >= 3) {
            int[] right_arr = new int[sequence.length - 1 - split];
            System.arraycopy(sequence, split, right_arr, 0, sequence.length - 1 - split);
            right = VerifySquenceOfBST(right_arr);
        }
        return left && right;
    }
}