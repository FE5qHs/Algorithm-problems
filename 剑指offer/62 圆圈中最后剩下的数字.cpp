// solution1
// time complexity O(n^2)
// space complexity O(n)
class Solution {
public:
    int lastRemaining(int n, int m) {
        vector<int> arr;
        for (int i = 0; i < n; ++i) {
            arr.push_back(i);
        }

        int baseIdx = 0;
        while (arr.size() > 1) {
            baseIdx = (baseIdx + m - 1) % arr.size();
            arr.erase(arr.begin() + baseIdx);
        }

        return arr[0];
    }
};