## detect whether 4 coordinates will form a rectangle
#
#
##


def checkRect(A):
  m = len(A)
  n = len(A[0])
  hset = set()
  for i in range(m - 1):
    for j in range(i + 1, m):
      x0, y0 = A[i][0], A[i][1]
      x1, y1 = A[j][0], A[j][1]
      hset.add(getDist(x0, y0, x1, y1))
  if len(hset) == 3:
    hset = list(hset)
    hset.sort()
    return hset[2] == hset[1] + hset[0]
  else:
    return False
      
      
def getDist(x0, y0, x1, y1):
  return (x0 - x1)**2 + (y0 - y1)**2
  
B = [[0, 0], [0, 2], [1, 0], [1, 2]]
print checkRect(B)
