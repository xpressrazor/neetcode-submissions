class Solution {
public:
    int getValue(vector<int>& arr) {
        int r = 0;
        for (int i = 0; i < arr.size(); ++i) {
            if (arr[i] > 0) r |= (1 << i);
        }

        return r;
    }

    int rangeBitwiseAnd(int left, int right) {
        vector<int>rarr(32, 0);
        vector<int>larr(32, 0);

        for (int i = 0; i < 32; ++i) {
            if (left&(1<<i)) larr[i] = 1;
            if (right&(1<<i)) rarr[i] = 1;
        }

        vector<int> result(32, 0);
        for (int i = 0; i < 32; ++i) {
            if (larr[i] == 0 || rarr[i] == 0) {
                result[i] = 0;
            } else {
                rarr[i] = 0;
                int x = getValue(rarr);
                if (x < left) rarr[i] = 1;
                result[i] = rarr[i];
            }
        }

        int v = getValue(result);
        return v;
    }
};