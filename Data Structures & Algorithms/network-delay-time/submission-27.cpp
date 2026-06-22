typedef pair<int,int> ii;
typedef vector<pair<int,int>> vii;
typedef vector<int> vi;

class Solution {
private:
    const int INF = 1e9+7;
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        priority_queue<ii, vii, greater<ii>> pq;
        pq.push({0, k});

        vector<vii> AL(n+1);
        vi dist(n+1,INF);
        dist[k] = 0;

        for (auto& t : times) {
            AL[t[0]].push_back({t[1], t[2]});
        }

        while (!pq.empty()) {
            auto [d,u] = pq.top(); pq.pop();   // don't use reference, we don't want to change original values
            if (d > dist[u]) continue;          // >

            for (auto& [v,w] : AL[u]) {
                int d1 = dist[u] + w;

                if (d1 >= dist[v]) continue;   // >=

                dist[v] = d1;
                pq.push({d1, v});
            }
        }

        int time = 0;
        for (int u = 1; u <= n; ++u) {
            time = max(time, dist[u]);
        }

        return time == INF ? -1 : time;
    }
};
