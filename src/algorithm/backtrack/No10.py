class No10:
    def isMatch(self, s: str, p: str) -> bool:
        arr = [[0 for i in range(len(p))] for j in range(len(s))]
        
        for i in range(len(p)):
            if p[i] == '*':
                for j in range(i, len(s)):
                    arr[j][i] = 1
            
            else:
                if i == 0 and (s[i] == p[i] or p[i] == '.'):
                    arr[i][i] = 1
                else:
                    for j in range(i-1, len(s)-1):
                        if arr[j][i-1] == 1 and (s[i] == p[i] or p[i] == '.'):
                            arr[j+1][i] = 1
                            break
            
        return arr[len(s)-1][len(p)-1]