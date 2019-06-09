#include <iostream>
#include <climits>
#include <vector>

using namespace std;

/*
A class can store huge positive interger which larger than maximum of unsigned long long
++ and << operator implemented
*/
class enormous_number
{
private:
    // number is stored using char array in reverse order
    vector<char>number;
    // an assistant function called by ++ operator
    void increase_one(int current_index);
public:
    enormous_number();
    // return current bit of number
    unsigned int show_bits();
    enormous_number operator++();
    friend ostream & operator<<(ostream &out, enormous_number &number);
};

enormous_number::enormous_number()
{
    number.push_back('0');
}

void enormous_number::increase_one(int current_index)
{
    if (number[current_index] == '9')
    {
        number[current_index] = '0';
        if (current_index == number.size() - 1)
            number.push_back('1');
        else
            increase_one(current_index + 1);
    }
    else
        ++number[current_index];
}

enormous_number enormous_number::operator++()
{
    increase_one(0);
    return *this;
}

unsigned int enormous_number::show_bits()
{
    return number.size();
}

ostream &operator<<(ostream &out, enormous_number &en)
{
    if (en.number.size() == 1)
        out << en.number[0];
    else
        for (int i = en.number.size() - 1; i >= 0; --i)
            out << en.number[i];
    return out;
}

void output_natural_number(int total_bits)
{
    if (total_bits < 1)
    {
        cout << "Inappropriate bits number!" << endl;
        return;
    }
    int max_bit = 1;
    unsigned int ull_max = ULLONG_MAX;
    while (ull_max /= 10)
        ++max_bit;
    // if required max natural number can be displayed using ull
    // then it's meaningless to use enormous_number class 
    if (total_bits < max_bit)
        for (unsigned int i = 1; i < pow(10, total_bits); ++i)
            cout << i << endl;
    else
        for (enormous_number en; en.show_bits() <= total_bits; ++en)
            cout << en << endl;
}

int main()
{
    output_natural_number(2);
    cin.get();
}