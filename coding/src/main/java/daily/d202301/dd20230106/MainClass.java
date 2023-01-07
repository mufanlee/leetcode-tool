package daily.d202301.dd20230106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int countEven(int num) {
        int ans = 0;
        for (int i = 2; i <= num; i++) {
            int sum = 0, j = i;
            while (j > 0) {
                sum += j % 10;
                j /= 10;
            }
            if ((sum & 1) == 0) {
                ans++;
            }
        }
        return ans;
    }
}
/*4
30*/

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int num = Integer.parseInt(line);

            int ret = new Solution().countEven(num);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}