// //
// // Created by M Tong on 8/15/22.
// //
#include <string>
#include <vector>
#include <stdio.h>
#include <map>
#include <queue>

using namespace std;
class Solution {
        public:
        // vector<vector<string> > findLadders(string beginWord, string endWord, vector<string>& wordList) {
        //     vector<vector<string> > res;
        //     bool existFlag = false;
        //     for (string word: wordList) {
        //         if (word == endWord) {
        //             existFlag = true;
        //         }
        //     }
        //     if (!existFlag) return res;

        //     map<string, vector<string> > wordMap;
        //     vector<string> words;

        //     queue<string> q;
        //     q.push(beginWord);
        //     while (q.size() > 0) {
        //         string word = q.front(); q.pop();
        //         auto& words = wordMap.emplace(word, new vector<string>).first;
        //         for (int i = 0; i < wordList.size(); i++) {
        //             if ()
        //         }
        //     }
        

        //     return res;
        // }

        // bool compare(string a, string b) {
        //     int count = 0;
        //     for (int i = 0; i < a.length(); i++) {
        //         if (a.at(i) != b.at(i)) {
        //             count ++;
        //             if (count > 1) {
        //                 return false;
        //             }
        //         }
        //     }
        //     return true;
        // }
};

int main() {
    vector<string> wordList;
    wordList = {"a", "b", "c"};
    // Solution().findLadders("begin", "end", wordList);
    return 0;
}