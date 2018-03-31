class Solution(object):
  def match(self, input, pattern):
    """
    input: string input, string pattern
    return: boolean
    """
    # write your solution here
    
    n1 = len(input)
    n2 = len(pattern)
    if n1 == 0 and n2 == 0:
      return True
    if n1 == 0 or n2 == 0 or n1 < n2:
      return False
    i , j = 0, 0
    while i < n1 and j < n2:
      ch = pattern[j]
      if ch.isdigit():
        num = 0
        while j < n2 and pattern[j].isdigit():
          num = num * 10 + ord(pattern[j]) - ord('0')
          j += 1
       	while num > 0:
          i += 1
          num -= 1
      else:
        if (i < n1 and j < n2 and input[i] != pattern[j]):
          return False
        i = i + 1
        j = j + 1         
    return i == n1 and j == n2
