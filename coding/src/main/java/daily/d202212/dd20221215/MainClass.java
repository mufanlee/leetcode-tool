package daily.d202212.dd20221215;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int getLucky(String s, int k) {
        int ans = 0;
        for (char c : s.toCharArray()) {
            int tmp = c - 'a' + 1;
            while (tmp > 0) {
                ans += tmp % 10;
                tmp /= 10;
            }
        }

        while (k > 1) {
            int sum = 0;
            while (ans > 0) {
                sum += ans % 10;
                ans /= 10;
            }
            ans = sum;
            k--;
        }
        return ans;
    }
}
/*"iiii"
1
"leetcode"
2
"zbax"
2*/

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            int ret = new Solution().getLucky(s, k);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}