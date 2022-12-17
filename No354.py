from typing import List


class No665:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        for i in range(len(envelopes)):
            envelopes[i].append(i)
        
        envelopes_w = envelopes.copy().sort(key=lambda a, b: b[0] - a[0])
        envelopes_h = envelopes.copy().sort(key=lambda a, b: b[0] - a[0])

        width_rank = []
        height_rank = []

