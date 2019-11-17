class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length >= 3) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; ++i) {
                HashMap<Integer, Integer> m = new HashMap<>();
                if (i - 1 >= 0 && nums[i] == nums[i - 1]) continue;
                for (int j = i + 1; j < nums.length; ++j) {
                    m.put(nums[i] + nums[j], j);
                }
                for (int j = i + 1; j < nums.length; ++j) {
                    if (m.containsKey(-nums[j]) && j != m.get(-nums[j])) {
                        List<Integer> result = new ArrayList<>();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[m.get(-nums[j])]);
                        results.add(result);
                        m.remove(-nums[m.get(-nums[j])]);
                        m.remove(-nums[j]);
                    }
                }
            }
        }
        return results;
    }
}