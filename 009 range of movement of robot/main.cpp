#include <iostream>

/*
* Author: 
*           angcz
* Function: 
*           part that executed recursion search
* Parameters:
*           threshold: threshold of sum of every bits of indexes
*           rows: sum of rows of matrix to be searched of
*           cols: sum of cols of matrix to be searched of
*           flags: flag matrix that has same size as matrix to be searched of,
*                  flags[i,j] == 1 represents [i,j] in matrix to be searched
*                  of has already been accessed
*           total: sum of grids that can be accessed
*           currentRowsIndex: current index of row
*           currentColsIndex: current index of col
* Modified : 2018/7/22
*/
void movingCountCore(int threshold, int rows, int cols, bool **flags, int &total, int currentRowsIndex, int currentColsIndex)
{
    // out of boundary and already been accessed judgement
    if (currentRowsIndex < 0 || currentRowsIndex > rows - 1
        || currentColsIndex < 0 || currentColsIndex > cols - 1
        || 1 == flags[currentRowsIndex][currentColsIndex]) { return; }
    // beyond threshold judgement
    int rowsIndexTotal = 0, colsIndexTotal = 0, currentRowsTemp = currentRowsIndex, currentColsTemp = currentColsIndex;
    while (currentRowsTemp / 10 != 0)
    {
        rowsIndexTotal += currentRowsTemp % 10;
        currentRowsTemp = currentRowsTemp / 10;
    }
    rowsIndexTotal += currentRowsTemp % 10;
    while (currentColsTemp / 10 != 0)
    {
        colsIndexTotal += currentColsTemp % 10;
        currentColsTemp = currentColsTemp / 10;
    }
    colsIndexTotal += currentColsTemp % 10;

    if (rowsIndexTotal + colsIndexTotal > threshold) { return; }
    // set corresponding flag to 1
    // ATTENTION! this step should be executed before recursion
    // otherwise will lead to infinite loop
    ++total;
    flags[currentRowsIndex][currentColsIndex] = 1;
    // search in four directions
    movingCountCore(threshold, rows, cols, flags, total, currentRowsIndex + 1, currentColsIndex);
    movingCountCore(threshold, rows, cols, flags, total, currentRowsIndex, currentColsIndex + 1);
    movingCountCore(threshold, rows, cols, flags, total, currentRowsIndex - 1, currentColsIndex);
    movingCountCore(threshold, rows, cols, flags, total, currentRowsIndex, currentColsIndex - 1);

    return;
}

/*
* Author:
*           angcz
* Function:
*           find the sum of grids that can be accessed by robot
* Parameters:
*           threshold: threshold of sum of every bits of indexes
*           rows: sum of rows of matrix to be searched of
*           cols: sum of cols of matrix to be searched of
* Modified : 2018/7/22
*/
int movingCount(int threshold, int rows, int cols)
{
    bool **flags = new bool *[rows]();
    for (int i = 0; i < rows; ++i) { flags[i] = new bool[cols](); }

    int total = 0, currentRowsIndex = 0, currentColsIndex = 0;

    movingCountCore(threshold, rows, cols, flags, total, currentRowsIndex, currentColsIndex);

    for (int i = 0; i < rows; ++i) { delete[] flags[i]; }
    delete[] flags;

    return total;
}

int main()
{
    std::cout << movingCount(18, 40, 40);
    std::cin.get();
}