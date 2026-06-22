typedef pair<int,int> ii;
typedef vector<ii> vii;
typedef vector<int> vi;

class Solution {
private:
    const int INF = 1e9+7;
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        priority_queue<ii, vii, greater<ii>> pq;
        vector<vii> AL(n+1);
        vi dist(n+1, INF);

        for (auto& t : times) {
            AL[t[0]].push_back({t[1], t[2]});
        }

        dist[k] = 0;
        pq.push({0, k});

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

        int delayTime = 0;
        for (int i = 1; i <= n; ++i) {
            delayTime = max(delayTime, dist[i]);
        }

        return delayTime == INF ? -1 : delayTime;
    }
};
