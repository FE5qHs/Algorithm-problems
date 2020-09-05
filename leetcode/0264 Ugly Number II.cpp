class Solution {
public:
    int nthUglyNumber(int n) {
        set<unsigned long long> s;
        s.insert(1);
        auto it = s.begin();
        for (int i = 1; i <= n - 1; ++i) {
            s.insert(*it * 2);
            s.insert(*it * 3);
            s.insert(*it * 5);
            ++it;
        }
        return *it;
    }
};