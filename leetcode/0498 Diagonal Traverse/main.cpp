/*
* Author:
*           angcz
* Function:
*           Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order
* Parameters:
*           matrix:2 dimension vector that stores the matrix to traverse
* Return:
*           vector that stores the result of traversal in diagonal order
* Modified:
*           2018/7/20
*/
class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& matrix) {
        vector<int>result;
        if (matrix.size() == 0 || matrix[0].size() == 0)
        {
            return result;
        }
        unsigned int q = 1, rows = matrix.size(), cols = matrix[0].size();
        // stores current index
        int row = 0, col = 0;
        // represents different direction of traversing
        int stride[2][2] = { {1,-1},{-1,1} };
        for (unsigned int i = 0; i < rows * cols; ++i)
        {
            result.push_back(matrix[row][col]);
            // move to next element
            row += stride[q][0];
            col += stride[q][1];
            // four different situations of out of boundary,
            // ur element and bl element should be treated
            // as same as last column elements and last row elements
            if (row == rows)
            {
                // change the direction of traversing
                q = 1 - q;
                row -= 1;
                col += 2;
            }
            else if (col == cols)
            {
                q = 1 - q;
                col -= 1;
                row += 2;
            }
            else if (row < 0)
            {
                q = 1 - q;
                row += 1;
            }
            else if (col < 0)
            {
                q = 1 - q;
                col += 1;
            }
        }
        return result;
    }
};