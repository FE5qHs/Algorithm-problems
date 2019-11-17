class Solution {
    public List<List<String>> solveNQueens(int n) {
        ArrayList<ArrayList<Integer>> current = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        solveNQueensCore(n, 0, result, current);

        List<List<String>> graph = new ArrayList<>();
        for (int i = 0; i < result.size() / n; ++i) {
            List<String> newGraph = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                StringBuilder newStr = new StringBuilder();
                for (int k = 0; k < n; ++k) {
                    boolean flag = false;
                    for (int l = i * n; l < (i + 1) * n; ++l) {
                        if (j == result.get(l).get(0) && k == result.get(l).get(1)) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        newStr.append("Q");
                    } else {
                        newStr.append(".");
                    }
                }
                newGraph.add(newStr.toString());
            }
            graph.add(newGraph);
        }
        return graph;
    }
    
    private void solveNQueensCore(int n, int i, ArrayList<ArrayList<Integer>> result,
                                         ArrayList<ArrayList<Integer>> current) {
        if (n == current.size()) {
            for (ArrayList<Integer> a : current) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(a.get(0));
                temp.add(a.get(1));
                result.add(temp);
            }
        }
        boolean flag = false;
        for (; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (0 == current.size()) {
                    current.add(new ArrayList<>(Arrays.asList(i, j)));
                    solveNQueensCore(n, i, result, current);
                    current.remove(current.size() - 1);
                    continue;
                }
                for (ArrayList<Integer> k : current) {
                    if (i == k.get(0) || j == k.get(1) ||
                            Math.abs(i - k.get(0)) == Math.abs(j - k.get(1))) {
                        flag = false;
                        break;
                    } else {
                        flag = true;
                    }
                }
                if (flag) {
                    current.add(new ArrayList<>(Arrays.asList(i, j)));
                    solveNQueensCore(n, i, result, current);
                    current.remove(current.size() - 1);
                }
            }
        }
    }
}