import re


class Solution:
    def monotoneIncreasingDigits(self, n: int) -> int:
        num_arr = [int(a) for a in str(n)]

        flag = False
        for i in range(len(num_arr)-1):
            j = i
            while num_arr[j+1] < num_arr[j] and j >= 0:
                num_arr[j] -= 1
                j -= 1
                flag = True
            
            if flag:
                for k in range(j+2, len(num_arr)):
                    num_arr[k] = 9
                break
        return int("".join(map(str, num_arr)))
        
      
print(Solution().monotoneIncreasingDigits(101))