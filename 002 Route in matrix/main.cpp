#include <iostream>
#include <string>

/*
* Author: angcz
* Function: Check whether char in matrix indicated by i and j is same as char in
*            string indicated by index,if they are,check surrounding of char in
*            matrix and next char in string and so on until all the char of string
*            has finished comparing.
* Parameters: matrix: the matrix stores characteristics,which is an array of string
*             ,each string represents a row in matrix
*
*             str: the string that we want to find
*
*             i: current row(index of matrix)in matrix
*
*             j: current column(index of matrix)in matrix
*
*             index: current index of string,indicates char that we want to search
*
*             row: number of rows of matrix
*
*             col: number of columns of matrix
*
*             indication: a bool matrix which has same size as char matrix,whenever
*             a char in matrix are searched,set corresponding bool to 1
* Return: Whether the string can be found via matrix[i][j] or not,1 means yes,
*         0 means no
* Modified : 2018/5/21
*/
bool back_tracking(const std::string* matrix, const std::string& str, unsigned int i,
    unsigned int j, unsigned int index, unsigned int row, unsigned int col, bool** indication)
{
    //If this char has been searched or different from corresponding char in string,stop search
    if (indication[i][j] == 1 || matrix[i][j] != str[index])
    {
        return 0;
    }
    //Set corresponding bool to 1 to prevent duplicate search from happening
    indication[i][j] = 1;
    //If chars are same and search has finished
    if (str[index] == matrix[i][j] && index == str.size() - 1)
    {
        return 1;
    }
    //These ifs are set for checking out of boundary
    if (i > 0)
    {
        if (back_tracking(matrix, str, i - 1, j, index + 1, row, col, indication))
        {
            return 1;
        }
    }
    if (j > 0)
    {
        if (back_tracking(matrix, str, i, j - 1, index + 1, row, col, indication))
        {
            return 1;
        }
    }
    if (i < row - 1)
    {
        if (back_tracking(matrix, str, i + 1, j, index + 1, row, col, indication))
        {
            return 1;
        }
    }
    if (j < col - 1)
    {
        if (back_tracking(matrix, str, i, j + 1, index + 1, row, col, indication))
        {
            return 1;
        }
    }
    return 0;
}

/*
* Author: angcz
* Function: Find whether a continous,non repeating route in matrix of char
*           that forms a corresponding string exists or not.
* Parameters: matrix: the matrix stores characteristics,which is an array of string
*             ,each string represents a row in matrix
*
*             str: the string that we want to find
*
*             row: number of rows of matrix
*
*             col: number of columns of matrix
* Return: Whether the string can be found or not,1 means yes,0 means no
* Modified: 2018/5/21
*/
bool find_route(const std::string* matrix, const std::string& str, unsigned int row, unsigned int col)
{
    //A matrix has same size as char matrix to store searching information
    bool** indication = new bool*[row]();
    for (unsigned int i = 0; i < row; ++i)
    {
        indication[i] = new bool[col]();
    }
    //Start searching
    for (unsigned int i = 0; i < row; ++i)
    {
        for (unsigned int j = 0; j < col; ++j)
        {
            if (back_tracking(matrix, str, i, j, 0, row, col, indication))
            {
                //Manage dynamic memory
                for (unsigned int i = 0; i < row; ++i)
                {
                    delete[] indication[i];
                }
                delete[] indication;

                return 1;
            }
            //Reset indication matrix
            for (unsigned int i = 0; i < row; ++i)
            {
                for (unsigned int j = 0; j < col; ++j)
                {
                    indication[i][j] = 0;
                }
            }
        }
    }
    //Manage dynamic memory
    for (unsigned int i = 0; i < row; ++i)
    {
        delete[] indication[i];
    }
    delete[] indication;

    return 0;
}

int main()
{
    std::string matrix[3] = { "abtg","cfcs","jdeh" };
    std::string str = "bfce";
    std::cout << find_route(matrix, str, 3, 4);
    std::cin.get();
}