package contest.c300;

import java.util.Arrays;

/**
 * 第300场周赛
 *
 * @author lipeng
 */
public class Solution {
    public String decodeMessage(String key, String message) {
        int[] map = new int[26];
        Arrays.fill(map, -1);
        int i = 0;
        for (char c : key.toCharArray()) {
            if (c == ' ') continue;
            int j = c - 'a';
            if (map[j] == -1) {
                map[j] = i;
                i++;
            }
        }

        StringBuilder ans = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c == ' ') {
                ans.append(c);
                continue;
            }
            ans.append((char) (map[c - 'a'] + 'a'));
        }
        return ans.toString();
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int[][] spiralMatrix1(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        int t = 0, l = 0, b = m - 1, r = n - 1;
        while (t <= b && l <= r) {
            for (int j = l; j <= r; j++) {
                ans[t][j] = head == null ? -1 : head.val;
                if (head != null) head = head.next;
            }
            t++;
            for (int i = t; i <= b; i++) {
                ans[i][r] = head == null ? -1 : head.val;
                if (head != null) head = head.next;
            }
            r--;
            if (b > t) {
                for (int j = r; j >= l; j--) {
                    ans[b][j] = head == null ? -1 : head.val;
                    if (head != null) head = head.next;
                }
                b--;
            }
            if (l < r) {
                for (int i = b; i >= t; i--) {
                    ans[i][l] = head == null ? -1 : head.val;
                    if (head != null) head = head.next;
                }
                l++;
            }
        }
        return ans;
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        // 初始化答案矩阵值为-1
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(ans[i], -1);
        }
        // 顺时针填充矩阵
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int x = 0, y = 0, d = 0;
        while (true) {
            ans[x][y] = head.val;
            head = head.next;
            // 链表已经遍历完，退出
            if (head == null) {
                break;
            }
            // 计算下一个位置坐标
            while (true) {
                // 尝试往前走一步
                int nx = x + dx[d];
                int ny = y + dy[d];
                // 走出矩阵或走到已填充位置，换一个方向
                if (nx < 0 || ny < 0 || nx >= m || ny >= n || ans[nx][ny] != -1) {
                    d = (d + 1) % 4;
                    continue;
                }
                // 走到下一个要填充位置
                x = nx;
                y = ny;
                break;
            }
        }
        return ans;
    }

    public int peopleAwareOfSecret1(int n, int delay, int forget) {
        final long MOD = 1000000007;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = Math.max(i - forget + 1, 1); j < i - delay; j++) {
                dp[i] = (dp[i] + dp[j]) % MOD;
            }
        }
        long ans = 0;
        for (int i = n - forget + 1; i <= n; i++) {
            ans = (ans + dp[i]) % MOD;
        }
        return (int) ans;
    }

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        final long MOD = 1000000007;
        long[] sum = new long[n + 1];
        sum[1] = 1;
        for (int i = 2; i <= n; i++) {
            int l = Math.max(i - forget, 0);
            int r = Math.max(i - delay, 0);
            long f = (sum[r] - sum[l] + MOD) % MOD;
            sum[i] = (sum[i - 1] + f) % MOD;
        }
        return (int) ((sum[n] - sum[Math.max(n - forget, 0)] + MOD) % MOD);
    }

    private int m;
    private int n;
    private long[][] dp; // 表示以(i,j)格子为起点的路径数
    private static final long MOD = 1000000007;
    private final int[] dx = {0, 1, 0, -1};
    private final int[] dy = {1, 0, -1, 0};

    public int countPaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new long[m][n];
        long ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = (ans + dfs(i, j, grid)) % MOD;
            }
        }
        return (int) ans;
    }

    private long dfs(int x, int y, int[][] grid) {
        if (dp[x][y] != 0) { // 已经遍历过直接返回
            return dp[x][y];
        }

        dp[x][y] = 1; // 以(x,y)为起点长度为1的路径数
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 超出边界
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }
            // 累加比(i,j)格子值大的格子的路径数
            if (grid[x][y] < grid[nx][ny]) {
                dp[x][y] = (dp[x][y] + dfs(nx, ny, grid)) % MOD;
            }
        }
        return dp[x][y];
    }
}
