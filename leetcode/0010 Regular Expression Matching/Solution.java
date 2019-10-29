class Solution {
    public boolean isMatch(String s, String p) {
        return isMatchHelper(s, 0, p, 0);
    }
    
    private boolean isMatchHelper(String s, int sIdx, String p, int pIdx) {
        if (s.length() == sIdx && p.length() == pIdx) {
            return true;
        }
        if (s.length() != sIdx && p.length() == pIdx) {
            return false;
        }
        if (pIdx + 1 < p.length() && '*' == p.charAt(pIdx + 1)) {
            if (s.length() != sIdx && (s.charAt(sIdx) == p.charAt(pIdx) || '.' == p.charAt(pIdx))) {
                return isMatchHelper(s, sIdx + 1, p, pIdx) || isMatchHelper(s, sIdx, p, pIdx + 2);
            } else {
                return isMatchHelper(s, sIdx, p, pIdx + 2);
            }
        } else if (s.length() != sIdx && (s.charAt(sIdx) == p.charAt(pIdx) || '.' == p.charAt(pIdx))) {
            return isMatchHelper(s, sIdx + 1, p, pIdx + 1);
        }
        return false;
    }
}