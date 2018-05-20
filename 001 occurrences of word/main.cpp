#include <iostream>
#include <fstream>
#include <cstring>
#include <string>
#include <map>

/*
*
* Function: Count the number of occurrences of a word in a file,ignores case
* Parameters: A map stores word as key,number of occurrences as value and path of file stored using string
* Modified: 2018/5/20
*
*/
void frequency_of_word(std::map<std::string, unsigned int>& result, std::string path)
{
    std::ifstream infile(path);

    bool flag;
    char temp_ch;
    std::string temp_str;

    infile >> temp_ch;
    while (!infile.fail())
    {
        flag = 0;
        temp_str = "";
        //Stores letters in temp_str until meet non-letter
        while (temp_ch >= 'a' && temp_ch <= 'z')
        {
            //Deal with double input when meet eof
            if (infile.fail())
            {
                break;
            }
            temp_str.push_back(temp_ch);
            infile >> temp_ch;
        }
        //Deal with problem of storing word first time
        if (result.size() == 0)
        {
            std::string temp_str_2 = temp_str;
            result[temp_str_2] = 1;
        }
        else
        {
            for (std::map<std::string, unsigned int>::iterator it = result.begin(); it != result.end(); ++it)
            {
                if (0 == stricmp(it->first.c_str(), temp_str.c_str()))
                {
                    flag = 1;
                    ++it->second;
                    break;
                }
            }
            //If flag hasn't changed,that means same word(not case sensitive)doesn't exist
            if (!flag)
            {
                std::string temp_str_2 = temp_str;
                result[temp_str_2] = 1;
            }
        }
        //Discards non-letters
        while (temp_ch < 'a' || temp_ch > 'z')
        {
            infile >> temp_ch;
        }
    }
}

int main()
{
    std::map<std::string, unsigned int>result;
    frequency_of_word(result, "D:\\Downloads\\1.txt");
    //Output result
    for (std::map<std::string, unsigned int>::iterator it = result.begin(); it != result.end(); ++it)
    {
        std::cout << it->first << " : " << it->second << std::endl;
    }

    std::cin.get();
}