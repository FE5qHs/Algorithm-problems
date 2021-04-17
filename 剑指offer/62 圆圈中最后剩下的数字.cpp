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

// solution2
// time complexity O(nm)
// space complexity O(n)
class Solution {
public:
    int lastRemaining(int n, int m) {
        list<int> l;
        list<int>::iterator it;

        for (int i = 0; i < n; ++i) l.push_back(i);
        it = l.begin();

        while (l.size() != 1) {
            for (int i = 0; i < m - 1; ++i) {
                ++it;
                if (it == l.end()) it = l.begin();
            }

            it = l.erase(it);
            if (it == l.end()) it = l.begin();
        }

        return *l.begin();
    }
};