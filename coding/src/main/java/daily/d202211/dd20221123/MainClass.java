package daily.d202211.dd20221123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int ans = 0;
        int[] cnts = new int[50];
        for (int i = lowLimit; i <= highLimit; i++) {
            int val = sum(i);
            cnts[val]++;
            ans = Math.max(ans, cnts[val]);
        }
        return ans;
    }

    private int sum(int val) {
        int res = 0;
        while (val > 0) {
            res += val % 10;
            val /= 10;
        }
        return res;
    }
}
/*1
10
5
15
19
28*/

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int lowLimit = Integer.parseInt(line);
            line = in.readLine();
            int highLimit = Integer.parseInt(line);
            
            int ret = new Solution().countBalls(lowLimit, highLimit);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}