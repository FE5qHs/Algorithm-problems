/*
* Author: 
*           angcz
* Function: 
*           Given an array of integers, return indices of the two numbers such that they add up to a specific target.
*           You may assume that each input would have exactly one solution, and you may not use the same element twice.
* Parameters:
*           nums:array of integers
*           target:required target
* Return:
*           array that stores index of result
* Modified: 
*           2018/3/17
* Time complexity:
*           O(n²)
* Space complexity:
*           O(1)
*/
vector<int> twoSum(vector<int>& nums, int target)
{
    vector<int>result;
    for(int i = 0;i < nums.size();++i)
    {
        for(int j = i + 1;j < nums.size();++j)
        {
            if(nums[i] + nums[j] == target)
            {
                result.push_back(i);
                result.push_back(j);
                return result;
            }
        }
    }
}

/*
* Author: 
*           angcz
* Function: 
*           Given an array of integers, return indices of the two numbers such that they add up to a specific target.
*           You may assume that each input would have exactly one solution, and you may not use the same element twice.
* Parameters:
*           nums:array of integers
*           target:required target
* Return:
*           array that stores index of result
* Modified: 
*           2018/5/26
* Time complexity:
*           O(n)
* Space complexity:
*           O(n)
*/
vector<int> twoSum(const vector<int>& nums, int target)
{
    vector<int>result;
    unordered_multimap<int, int>temp;
    for (int i = 0; i < nums.size(); ++i)
    {
        temp.insert(pair<int, int>(target - nums[i], i));
    }
    for (int i = 0; i < nums.size(); ++i)
    {
        if (0 < temp.count(nums[i]))
        {
            result.push_back(temp.find(nums[i])->second);
            result.push_back(i);
            if(result[0] != result[1])
            {
                return result;
            }
            vector<int>().swap(result);
        }
    }
    return result;
}