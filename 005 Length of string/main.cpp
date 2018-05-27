#include <iostream>

using namespace std;

/*
* Author:
*           angcz
* Function:
*           Calculate length of a c-style string without using loop.
* Parameters:
*           str:the c-style string needs to be measure
*           index:current position
* Return:
*           length of the string
* Modified:
*           2018/5/27
*/
unsigned int length_of_string(const char* str, unsigned int index)
{
    if (str[index] == '\0')
    {
        return index + 1;
    }
    else
    {
        return length_of_string(str, index + 1);
    }
}

int main()
{
    const char* str = "123456";
    cout << length_of_string(str, 0);
    cin.get();
}