# Learning lisp
## 1
Write a function (NumberOfPrimes <list>) which counts the number of primesin a (possibly nested) list.

Example: (NumberOfPrimes ‘(((1)(2))(5)(3)((8)3)) returns 4.
## 2
Define a function (even <list>) which returns the subset (a list) of evennumbers contained in a given numeric,possibly nested list.

Example: (even‘(1 2 (3 4) -4)) returns (2 4 -4). Note that the result must maintain the order of the even numbers in the original list, and the result must be a flat list.
## 3
Define a function (SumIfNot <list1> <list2>) that returns the sum of all elements in list2 that do not appear in list1. Both lists may be nested lists.

Example: (SumIfNot ‘(1 8 (2)) ‘(1 (3 (8)) 8 9)) returns 12.