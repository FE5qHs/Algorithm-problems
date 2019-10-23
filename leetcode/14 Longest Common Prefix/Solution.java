class Solution {
    public String longestCommonPrefix(String[] strs) {
        ArrayList<ArrayList<String>> m = new ArrayList<>();
        if (strs.length > 0) {
            for (int i = 0; i < strs[0].length(); ++i) {
                ArrayList<String> newArr = new ArrayList<>(Arrays.asList(Character.toString(strs[0].charAt(i)), "1"));
                m.add(newArr);
            }
            
            for (int i = 1; i < strs.length; ++i) {
                for (int j = 0; j < m.size(); ++j) {
                    if (j == strs[i].length()) {
                        break;
                    }
                    if (Character.toString(strs[i].charAt(j)).equals(m.get(j).get(0))) {
                        m.get(j).set(1, Integer.toString(Integer.parseInt(m.get(j).get(1)) + 1));
                    } else {
                        break;
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (ArrayList<String> arr : m) {
            if (Integer.parseInt(arr.get(1)) == strs.length) {
                result.append(arr.get(0));
            }
        }

        return result.toString();
    }
}