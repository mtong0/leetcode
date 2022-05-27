#include <vector>
#include <iostream>
#include <stdexcept>
using namespace std;
class Solution {
public:
    int networkDelayTime(vector<vector<int> >& times, int n, int k) {
        const int MAX_TIME = 101 * 100;
        vector<int> dist(n, MAX_TIME);
        dist[k-1] = 0;
        for (int i = 0; i < n; i++) {
            for (const auto& time: times) {
                int u = time[0] - 1, v = time[1] - 1, w = time[2];
                dist[v] = min(dist[v], dist[u] + w);
            }
        }

        int max_dist = *max_element(dist.begin(), dist.end());
        return max_dist == MAX_TIME ? -1:max_dist;
    }
};
int main() {
    return 0;
}