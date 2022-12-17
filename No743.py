from collections import defaultdict
from main.src.math import nextafter
from operator import ne
from typing import DefaultDict, List
import sys

class No665:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        graph = defaultdict(list)

        for i in range(len(times)):
            src = times[i][0]
            dst = times[i][1]
            w = times[i][2]

            graph[src].append((w, dst))

        time = [sys.maxsize for i in range(n+1)]

        q = []
        q.append(k)
        time[k] = 0

        while len(q) > 0:
            cur = q.pop(0)

            for pair in graph[cur]:
                w = pair[0]
                node = pair[1]

                cur_time = time[cur] + w
                if time[node] > cur_time:
                    time[node] = cur_time
                    q.append(node)
        
        ans = 0
        for i in range(n+1):
            ans = max(ans, time[i])
        
        return -1 if ans == sys.maxsize else ans

No665().networkDelayTime([[2, 1, 1], [2, 3, 1], [3, 4, 1]], 4, 2)