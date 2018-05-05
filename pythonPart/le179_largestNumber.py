class Solution:   # cmp works for python2.7
    # @param {integer[]} nums
    # @return {string}
    def largestNumber(self, nums):
        newarr = []
        for ele in nums:
            newarr.append(str(ele))
        b = ''.join(sorted(newarr, cmp = lambda x, y: cmp(y + x, x + y)))
        return b[0] if b[0] == '0' else b
