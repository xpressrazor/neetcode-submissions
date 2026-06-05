class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int,int> m;
        for (int& num : nums) {
            m[num]++;
        }

        vector<int> bucket[1001];

        for (auto& x : m) {
            bucket[x.second].push_back(x.first);
        }

        vector<int>r;

        for (int i = 1000; i >= 0; --i) {
            if (bucket[i].size() > 0) {
                for (int& v : bucket[i]) {
                    r.push_back(v);
                    if (r.size() == k) return r;
                }
            }
        }

        return r;
    }
};
