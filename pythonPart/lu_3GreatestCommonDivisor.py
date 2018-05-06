class Solution():
  def gcd(self, a, b):
    while a != b:
      if a > b:
        a, b = b, a
      b = b - a
    return a
  def gcd3(self, a, b, c):
    d = self.gcd(a, b)
    res = self.gcd(d, c)
    return res
    
a = 100
b = 75
c = 50
sol = Solution()
print (sol.gcd3(a, b, c))
