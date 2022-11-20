package daily.dd20221120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row + 2][query_glass + 2];
        dp[0][0] = poured;
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] <= 1) continue;
                dp[i + 1][j] = (dp[i][j] - 1) / 2;
                dp[i+ 1][j + 1] = (dp[i][j] - 1) / 2;
            }
        }
        return Math.min(dp[query_row][query_glass], 1);
    }
}
/*1
1
1
2
1
1
100000009
33
17*/

public class MainClass {
    public static String doubleToString(double input) {
        return new DecimalFormat("0.00000").format(input);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int poured = Integer.parseInt(line);
            line = in.readLine();
            int query_row = Integer.parseInt(line);
            line = in.readLine();
            int query_glass = Integer.parseInt(line);

            double ret = new Solution().champagneTower(poured, query_row, query_glass);

            String out = doubleToString(ret);

            System.out.print(out);
        }
    }
}