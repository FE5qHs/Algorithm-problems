class Solution {
    public int romanToInt(String s) {
        int res = 0;
        int i = s.length() - 1;
        HashMap<String, Integer> m = new HashMap<>();
        m.put("I", 1);
        m.put("V", 5);
        m.put("X", 10);
        m.put("L", 50);
        m.put("C", 100);
        m.put("D", 500);
        m.put("M", 1000);
        m.put("IV", 4);
        m.put("IX", 9);
        m.put("XL", 40);
        m.put("XC", 90);
        m.put("CD", 400);
        m.put("CM", 900);
        while (i >= 0) {
            if (i - 1 >= 0 && m.containsKey(s.substring(i - 1, i + 1))) {
                res += m.get(s.substring(i - 1, i + 1));
                i -= 2;
            } else {
                res += m.get(Character.toString(s.charAt(i)));
                --i;
            }
        }
        return res;
    }
}