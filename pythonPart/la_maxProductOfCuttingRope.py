class Solution(object):
  def maxProduct(self, length):
    """
    input: int length
    return: int
    """
    # write your solution here

    n = length
    M = [0] * (n + 1)
    M[1] = 1
    for i in range(2, n + 1):  # total length of each case
      for l in range(1, i // 2 + 1):
        r = i - l
        M[i] = max(M[i], max(l, M[l]) * max(r, M[r]))
    return M[n]
