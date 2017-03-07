"""

Given a set of n nuts of different sizes and n bolts of different sizes. 
There is a one-one mapping between nuts and bolts. 
Comparison of a nut to another nut or a bolt to another bolt is not allowed. 
It means nut can only be compared with bolt and bolt can only be compared with nut to see which one is bigger/smaller.

We will give you a compare function to compare nut with bolt.

Have you met this question in a real interview? Yes
Example
Given nuts = ['ab','bc','dd','gg'], bolts = ['AB','GG', 'DD', 'BC'].

Your code should find the matching bolts and nuts.

one of the possible return:

nuts = ['ab','bc','dd','gg'], bolts = ['AB','BC','DD','GG'].

we will tell you the match compare function. If we give you another compare function.

the possible return is the following:

nuts = ['ab','bc','dd','gg'], bolts = ['BC','AA','DD','GG'].

So you must use the compare function that we give to do the sorting.

The order of the nuts or bolts does not matter. You just need to find the matching bolt for each nut.

"""
# It is wierd that the code does not pass the testcase but get accepted when click the submit button.

from random import randint
# class Comparator:
#     def cmp(self, a, b)
# You can use Compare.cmp(a, b) to compare nuts "a" and bolts "b",
# if "a" is bigger than "b", it will return 1, else if they are equal,
# it will return 0, else if "a" is smaller than "b", it will return -1.
# When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
class Solution:
    # @param nuts: a list of integers
    # @param bolts: a list of integers
    # @param compare: a instance of Comparator
    # @return: nothing
    def sortNutsAndBolts(self, nuts, bolts, compare):
        # write your code here
        if nuts == [] or bolts == [] or compare is None:
            return 
        lo, hi = 0, len(nuts)-1
        self.compare = compare
        # print compare.cmp('AB', 'ab')
        self.sortHelper(nuts, bolts, lo, hi)
        
    
    def sortHelper(self, nuts, bolts, lo, hi):
        if lo >= hi:
            return 
        pivotpos = randint(lo, hi)
        nutspos = self.partition(nuts, bolts[pivotpos], lo, hi)
        self.partition(bolts, nuts[nutspos], lo, hi)
        
        self.sortHelper(nuts, bolts, lo, nutspos-1)
        self.sortHelper(nuts, bolts, nutspos + 1, hi)
      
    def partition(self, items, pivotval, lo, hi):
        #if items == [] or pivotval is None:
         #   return
        compare = self.compare
        pivotidx = 0
        newpivotidx = lo
        for i in range(lo, len(items)):
            if compare.cmp(items[i], pivotval) == 0 or compare.cmp(pivotval, items[i]) == 0: # cmp default left is nuts right is bolts
                pivotidx = i
                break
        items[pivotidx], items[hi] = items[hi], items[pivotidx]
        for i in range(lo, hi): # check here
            if compare.cmp(items[i], pivotval) == -1 or (compare.cmp(pivotval, items[i]) == 1):
                items[i], items[newpivotidx] = items[newpivotidx], items[i]
                newpivotidx += 1
        items[hi], items[newpivotidx] = items[newpivotidx], items[hi]
        return newpivotidx
