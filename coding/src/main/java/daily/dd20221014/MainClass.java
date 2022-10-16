package daily.dd20221014;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int distinctSubseqII(String s) {
        final int mod = (int) 1e9 + 7;
        int n = s.length();
        int[][] dp = new int[n + 1][26];
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            for (int j = 0; j < 26; j++) {
                if (c != j) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    dp[i + 1][j] = 1;
                    for (int k = 0; k < 26; k++) {
                        dp[i + 1][j] = (dp[i + 1][j] + dp[i][k]) % mod;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans = (ans + dp[n][i]) % mod;
        }
        return ans;
    }
}
/*"abc"
"aba"
"aaa"*/

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            int ret = new Solution().distinctSubseqII(s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}