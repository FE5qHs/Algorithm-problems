class Solution(object):
    def minNumber(self, nums):
        stringNums = [str(x) for x in nums]
        stringNums = sorted(stringNums, key=functools.cmp_to_key(self.cmp))
        res = ""
        for s in stringNums:
            res += s
        return res

    def cmp(self, a, b):
        res1 = a + b
        res2 = b + a
        if res1 > res2: return 1
        elif res1 < res2: return -1
        else: return 0