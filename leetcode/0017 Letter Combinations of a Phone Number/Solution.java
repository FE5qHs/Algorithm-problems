class Solution {
    private List<String> result = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return result;
        }
        HashMap<Character, String> m = new HashMap<>();
        m.put('2', "abc");
        m.put('3', "def");
        m.put('4', "ghi");
        m.put('5', "jkl");
        m.put('6', "mno");
        m.put('7', "pqrs");
        m.put('8', "tuv");
        m.put('9', "wxyz");
        StringBuilder current = new StringBuilder();
        letterCombinationsHelper(digits, current, 0, m);
        return result;
    }
    
    private void letterCombinationsHelper(String digits, StringBuilder current, int idx, HashMap<Character, String> m) {
        if (idx == digits.length()) {
            result.add(current.toString());
            return;
        }
        String letters = m.get(digits.charAt(idx));
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));
            letterCombinationsHelper(digits, current, idx + 1, m);
            current.deleteCharAt(current.length() - 1);
        }
    }
}