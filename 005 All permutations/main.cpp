#include <iostream>
#include <string>
#include <vector>

/*
* Author:
*           angcz
* Function:
*           find all permutation of a string
* Parameter:
*           original_str: the string which needed to be found all permutation
*
*           flag: the array that indicate corresponding index of string has been chosen or not
*
*           formed_str: current string,one of possible permutations
*
*           len: length of original_str
* Modified:
*           2018/6/4
*/
void core_part(const char* original_str, const bool* flag, const std::string formed_str, unsigned int len)
{
    //If current string is as long as original_str,that means one permutation has found,
    //output it and end current function
    if (formed_str.size() == len)
    {
        std::cout << formed_str << std::endl;
        return;
    }

    for (unsigned int i = 0; i < len; ++i)
    {
        if (flag[i] == 0)
        {
            //Element in flag equals to 0 means corresponding char in original_str
            //hasn't been chosen yet,add this char into current string
            std::string temp_str = formed_str;
            temp_str.push_back(original_str[i]);
            //A new array of flag that indicates changed current string
            bool* new_flag = new bool[len]();
            memcpy(new_flag, flag, len);
            new_flag[i] = 1;

            core_part(original_str, new_flag, temp_str, len);

            delete[] new_flag;
        }
    }
}

/*
* Author:
*           angcz
* Function:
*           find all permutation of a string
* Parameter:
*           the string which needed to be found all permutation
* Modified:
*           2018/6/4
*/
void all_permutation_recursive(const char* str)
{
    //Measure length of string
    unsigned int len = 0, index = 0;
    while (str[index] != '\0')
    {
        ++len;
        ++index;
    }
    //Creating array of flag
    bool* flag = new bool[len]();

    std::string temp_str;

    core_part(str, flag, temp_str, len);
}

int main()
{
    const char* str = "abcd";
    all_permutation_recursive(str);
    std::cin.get();
}