class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> res = new ArrayList<>();

        if (0 == words.length) return res;
        if (1 == words.length && words[0].equals("")) {
            for (int i = 0; i <= s.length(); ++i) res.add(i);
            return res;
        }

        HashMap<String, Integer> originM = new HashMap<>();
        for (String w : words) {
            if (originM.containsKey(w)) {
                originM.put(w, originM.get(w) + 1);
            } else {
                originM.put(w, 1);
            }
        }

        int totalLen = words[0].length() * words.length;
        for (int i = 0; i < s.length() - totalLen + 1; ++i) {
            HashMap<String, Integer> m = new HashMap<>();
            m.putAll(originM);
            int j = i;
            for (; j < s.length(); j += words[0].length()) {
                String str = "";
                if (j + words[0].length() >= s.length()) {
                    str = s.substring(j);
                } else {
                    str = s.substring(j, j + words[0].length());
                }
                if (m.containsKey(str) && m.get(str) != 0) {
                    m.put(str, m.get(str) - 1);
                } else {
                    break;
                }
            }
            boolean flag = true;
            for (Integer k : m.values()) {
                if (k != 0) flag = false;
            }
            if (flag && j - i == totalLen) res.add(i);
        }
        
        return res;
    }
}