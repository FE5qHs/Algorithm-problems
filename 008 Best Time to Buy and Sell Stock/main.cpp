class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if(prices.size() == 0)
        {
            return 0;
        }
        int min = prices[0], max_difference = 0, current_difference = 0;
        for (unsigned int i = 0; i < prices.size(); ++i)
        {
            if (prices[i] < min)
            {
                min = prices[i];
            }
            current_difference = prices[i] - min;
            if (current_difference > max_difference)
            {
                max_difference = current_difference;
            }
        }
        return max_difference;
    }
};