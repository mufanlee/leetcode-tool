package daily.d202301.dd20230104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int l = 1, r = maxSum;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid, n, index, maxSum)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean check(int mid, int n, int index, int maxSum) {
        return sum(mid, index + 1) + sum(mid, n - index) - mid <= maxSum;
    }

    private long sum(long val, long len) {
        if (val > len) {
            return (val + val - len + 1) * len / 2;
        } else {
            return (val + 1) * val / 2 + len - val;
        }
    }
}
/*4
2
6
6
1
10*/

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            line = in.readLine();
            int index = Integer.parseInt(line);
            line = in.readLine();
            int maxSum = Integer.parseInt(line);
            
            int ret = new Solution().maxValue(n, index, maxSum);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}