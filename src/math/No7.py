class No665:
    def reverse(self, x: int) -> int:
        MAXNUM = int(((1 << 31)-1)/10)
        DIDGIT = ((1 << 31)-1) % 10

        res = 0
        neg = x < 0
        x = abs(x)
        while x != 0:
            v = x % 10
            x = int(x / 10)
            if res > MAXNUM \
                    or (res == MAXNUM and not neg and v > DIDGIT-1) \
                    or (res == MAXNUM and not neg and v > DIDGIT):
                return 0
            else:
                res = res * 10 + v

        return res if not neg else -res
