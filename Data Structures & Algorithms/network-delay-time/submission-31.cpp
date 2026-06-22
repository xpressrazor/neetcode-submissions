typedef pair<int,int> ii;
typedef vector<ii> vii;
typedef vector<int> vi;

class Solution {
private:
    const int INF = 1e9+7;

public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        vector<vii> AL(n+1);
        priority_queue<ii, vii, greater<ii>> pq;
        vi dist(n+1, INF);

        dist[k] = 0;
        pq.push({0, k});

        for (auto &t : times) {
            AL[t[0]].push_back({t[1], t[2]});
        }    

        while (!pq.empty()) {
            auto [d,u] = pq.top(); pq.pop();

            if (d > dist[u]) continue;

            for (auto &[v,w] : AL[u]) {
                int d1 = d + w;

                if (d1 >= dist[v]) continue;

                dist[v] = d1;
                pq.push({d1, v});
            }
        }

        int minTime = 0;
        for (int i = 1; i <= n; ++i) {
            minTime = max(minTime, dist[i]);
        }

        return minTime == INF ? -1 : minTime;
    }
};
