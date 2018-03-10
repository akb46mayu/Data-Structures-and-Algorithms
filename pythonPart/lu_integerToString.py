# EPI 6.1 
def int2str(x):
  sign = -1 if x < 0 else 1
  if sign == -1:
    x = -x
  res = []
  while 1:
    ch = chr(ord('0') + x % 10)
    res.append(ch)
    x = x // 10
    if x == 0:
      break
    
  if sign == -1:
    return '-' + ''.join(reversed(res))
  else:
    return ''.join(reversed(res))
  
  
input = [235, -1056, 0]
for i in range(len(input)):
  print (int2str(input[i]))
