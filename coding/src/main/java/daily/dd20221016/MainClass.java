package daily.dd20221016;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public boolean possibleBipartition1(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] d : dislikes) {
            map.computeIfAbsent(d[0], k -> new ArrayList<>()).add(d[1]);
            map.computeIfAbsent(d[1], k -> new ArrayList<>()).add(d[0]);
        }
        int[] colors = new int[n + 1];
        Arrays.fill(colors, -1);
        for (int i = 1; i <= n; i++) {
            if (colors[i] == -1 && !dfs(i, 0, map, colors)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int u, int color, Map<Integer, List<Integer>> map, int[] colors) {
        colors[u] = color;
        for (int v : map.getOrDefault(u, new ArrayList<>())) {
            if (colors[v] != -1 && colors[v] == color) {
                return false;
            }

            if (colors[v] == -1 && !dfs(v, (color + 1) % 2, map, colors)) {
                return false;
            }
        }
        return true;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] d : dislikes) {
            map.computeIfAbsent(d[0], k -> new ArrayList<>()).add(d[1]);
            map.computeIfAbsent(d[1], k -> new ArrayList<>()).add(d[0]);
        }

        UnionFind unionFind = new UnionFind(n + 1);
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            for (int x : entry.getValue()) {
                unionFind.union(entry.getValue().get(0), x);
                if (unionFind.connected(entry.getKey(), x)) {
                    return false;
                }
            }
        }
        return true;
    }

    class UnionFind {
        private final int[] parent;
        private final int[] rank;
        private int count;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            rank = new int[n];
            Arrays.fill(rank, 1);
        }

        // 路径压缩
        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }

            return parent[x] = find(parent[x]);
        }

        // 按秩合并
        public void union(int x, int y) {
            int fx = find(x);
            int fy = find(y);

            if (fx == fy) {
                return;
            }

            if (rank[fx] > rank[fy]) {
                parent[fy] = fx;
            } else {
                parent[fx] = fy;
            }

            if (rank[fx] == rank[fy]) {
                rank[fy]++;
            }
            count--;
        }

        public int count() {
            return count;
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
/*4
[[1,2],[1,3],[2,4]]
3
[[1,2],[1,3],[2,3]]
5
[[1,2],[2,3],[3,4],[4,5],[1,5]]*/

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static int[][] stringToInt2dArray(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
            return new int[0][0];
        }

        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            line = in.readLine();
            int[][] dislikes = stringToInt2dArray(line);

            boolean ret = new Solution().possibleBipartition(n, dislikes);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}