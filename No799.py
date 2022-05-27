class Solution:
    def champagneTower(self, poured: int, query_row: int, query_glass: int) -> float:
        cur_num = [poured]
        next_num = [0, 0]
        for i in range(0, query_row):
            for j in range(len(cur_num)):
                if cur_num[j] > 1:
                    next_num[j] += (cur_num[j]-1)/2
                    next_num[j+1] += (cur_num[j]-1)/2
                    cur_num[j] = 1

            cur_num = next_num.copy()
            next_num = [0 for k in range(i+3)]

        return cur_num[query_glass] if cur_num[query_glass] < 1 else 1

Solution().champagneTower(2, 1, 1)