#include <iostream>
#include <vector>
#include <string>

using namespace std;

bool fun2(const vector<vector<char>>& matrix, const string& str, int i, int j, int index)
{
    if (i < 0 || j < 0 || i > matrix.size() || j > matrix[0].size() || matrix[i][j] != str[index])
    {
        return 0;
    }
    if (str[index] == matrix[i][j] && index == str.size())
    {
        return 1;
    }
    if (fun2(matrix, str, i - 1, j, index + 1) || fun2(matrix, str, i + 1, j, index + 1)
        || fun2(matrix, str, i, j - 1, index + 1) || fun2(matrix, str, i, j + 1, index + 1))
    {
        return 1;
    }
    return 0;
}

bool fun(const vector<vector<char>>& matrix, const string& str)
{
    for (int i = 0; i < matrix.size(); ++i)
    {
        for (int j = 0; j < matrix[0].size(); ++j)
        {
            if (fun2(matrix, str, i, j, 0))
            {
                return 1;
            }
        }
    }
    return 0;
}

int main()
{
    vector<vector<char>>matrix = { {'a','b','t','g' },{ 'c','f','c','s' },{ 'j','d','e','h' } };
    string str = "bfce";
    cout << fun(matrix, str);
    cin.get();
}