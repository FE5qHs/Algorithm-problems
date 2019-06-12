/*
* Author: 
*           angcz
* Function: 
*           Say you have an array for which the ith element is the price of a given stock on day i.
*           If you were only permitted to complete at most one transaction
*           (i.e., buy one and sell one share of the stock), 
*           design an algorithm to find the maximum profit.
*           Note that you cannot sell a stock before you buy one.
* Parameters:
*           prices:array that stores value of stock,index represents time
* Return:
*           maxprofit
* Modified: 
*           2018/7/18
*/
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
            // the element used to calculate current difference can be replaced
            // at any time during traversal,since smaller element can bring
            // larger difference at any time
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