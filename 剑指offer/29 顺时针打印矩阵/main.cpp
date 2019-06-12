class Solution {
public:
    vector<int> printMatrix(vector<vector<int>> matrix) {
        int rows = matrix.size();
        int cols = matrix[0].size();
        vector<int> result;

        if (0 == rows || 0 == cols)
            return result;

        int i = 0;
        int j = 0;
        int it_times = ceil((rows > cols ? cols : rows) / 2.0);
        for (int it = 0; it < it_times; ++it) {
            if (1 == rows) {
                for (int k = 0; k < cols; ++k, ++j)
                    result.push_back(matrix[i][j]);
                return result;
            }
            if (1 == cols) {
                for (int k = 0; k < rows; ++k, ++i)
                    result.push_back(matrix[i][j]);
                return result;
            }

            for (int k = 0; k < cols - 1; ++k, ++j)
                result.push_back(matrix[i][j]);

            for (int k = 0; k < rows - 1; ++k, ++i)
                result.push_back(matrix[i][j]);

            for (int k = 0; k < cols - 1; ++k, --j)
                result.push_back(matrix[i][j]);

            for (int k = 0; k < rows - 1; ++k, --i)
                result.push_back(matrix[i][j]);

            ++i;
            ++j;
            rows -= 2;
            cols -= 2;
        }

        return result;
    }
};