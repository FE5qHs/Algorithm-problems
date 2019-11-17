class Solution {
    private List<String> result = new ArrayList<>();
    
    public List<String> generateParenthesis(int pairNum) {
        generateParenthesisHelper(pairNum, 0, 0, "");
        return result;
    }
    
    private void generateParenthesisHelper(int pairNum, int leftPNum, int rightPNum, String cur) {
        if(pairNum * 2 == cur.length()) {
            result.add(cur);
            return;
        }
        if(leftPNum < pairNum) {
            generateParenthesisHelper(pairNum, leftPNum + 1, rightPNum, cur + "(");
        }
        if(rightPNum < pairNum && rightPNum < leftPNum) {
            generateParenthesisHelper(pairNum, leftPNum, rightPNum + 1, cur + ")");
        }
    }
}