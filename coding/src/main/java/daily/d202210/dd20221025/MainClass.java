package daily.d202210.dd20221025;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        Queue<int[]> queue = new ArrayDeque<>();
        List<int[]> island = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;

                queue.offer(new int[]{i, j});
                while (!queue.isEmpty()) {
                    int[] node = queue.poll();
                    int x = node[0];
                    int y = node[1];
                    island.add(node);
                    grid[x][y] = -1;
                    for (int k = 0; k < dx.length; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }

                for (int[] cell : island) {
                    queue.offer(cell);
                }
                int ans = 0;
                while (!queue.isEmpty()) {
                    int size = island.size();
                    for (int l = 0; l < size; l++) {
                        int[] node = queue.poll();
                        int x = node[0];
                        int y = node[1];
                        for (int k = 0; k < dx.length; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                if (grid[nx][ny] == 1) {
                                    return ans;
                                } else if (grid[nx][ny] == 0) {
                                    queue.offer(new int[]{nx, ny});
                                    grid[nx][ny] = -1;
                                }
                            }
                        }
                    }
                    ans++;
                }
            }
        }
        return 0;
    }
}
/*[[0,1],[1,0]]
[[0,1,0],[0,0,0],[0,0,1]]
[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]*/

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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] grid = stringToInt2dArray(line);

            int ret = new Solution().shortestBridge(grid);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}