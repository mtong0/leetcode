//
// Created by M Tong on 8/7/22.
//

#include <vector>
#include <iostream>
using namespace std;
class Solution {
public:
    int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int repeatTime = minutesToTest / minutesToDie;
        vector<int> line1 = {2};
        vector<int> line2;
        int count = 0;
        for (int i = 1; ; i++) {
            for (int j = 0; j < repeatTime+1 && j <= i; j++) {
                if (j == 0) {
                    count = i + 2;
                    line2.push_back(count);
                } else {
                    count = line2.at(0) * line1.at(j-1);
                    line2.push_back(count);
                }
                if (count >= buckets) return i+1;
            }
            line1 = line2;
            line2 = {};
        }
    }
};
//
//int main() {
//    Solution s;
//    cout << s.poorPigs(4, 15, 30);
//    return 0;
//}