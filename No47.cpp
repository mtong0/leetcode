#include <vector>
#include <map>
using namespace std;

class Solution {
public:
    vector<vector<int> > res;
    vector<vector<int> > permuteUnique(vector<int>& nums) {
        map<int, int> m;
        for(int i = 0; i < nums.size(); i++) {
            m[nums[i]] += 1;
        }

        vector<int> l;
        dp(m, m.size(), l);

        return res;
    }

    void dp(map<int, int> m, int key_num, vector<int> l) {
        if(key_num == 1) {
            for(map<int, int>::iterator it = m.begin(); it != m.end(); it++) {
                if(m[it->first] != 0) {
                    for(int i = 0; i < m[it->first]; i++) {
                        l.push_back(it->first);
                    }
                    vector<int> v = l;
                    res.push_back(v);
                    for(int i = 0; i < m[it->first]; i++) {
                        l.pop_back();
                    }
                    return;
                }
            }
        }

        for(map<int, int>::iterator it = m.begin(); it != m.end(); it++) {
            if(m[it->first] == 0) {
                continue;
            }

            m[it->first] -= 1;
            l.push_back(it->first);
            if(m[it->first] == 0) {
                dp(m, key_num-1, l);
            } else {
                dp(m, key_num, l);
            }
            l.pop_back();
            m[it->first] += 1;
        }
    }
};