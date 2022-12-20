package daily.d202212.dd20221219;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            adj[x].add(y);
            adj[y].add(x);
        }
        boolean[] vis = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        vis[source] = true;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (u == destination) return true;
            for (int v : adj[u]) {
                if (!vis[v]) {
                    queue.offer(v);
                    vis[v] = true;
                }
            }
        }
        return false;
    }
}

/*3
[[0,1],[1,2],[2,0]]
0
2
6
[[0,1],[0,2],[3,5],[5,4],[4,3]]
0
5*/

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
            int[][] edges = stringToInt2dArray(line);
            line = in.readLine();
            int source = Integer.parseInt(line);
            line = in.readLine();
            int destination = Integer.parseInt(line);

            boolean ret = new Solution().validPath(n, edges, source, destination);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}