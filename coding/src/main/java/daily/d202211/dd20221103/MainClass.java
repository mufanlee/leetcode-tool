package daily.d202211.dd20221103;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int maxRepeating1(String sequence, String word) {
        int ans = 1;
        StringBuilder sb = new StringBuilder(word);
        while (!sequence.contains(sb.toString())) {
            sb.append(word);
            ans++;
        }
        return ans - 1;
    }

    public int maxRepeating(String sequence, String word) {
        int n = sequence.length(), m = word.length(), ans = 0;
        int[] dp = new int[n + 10];
        for (int i = 1; i <= n; i++) {
            if (i - m < 0) continue;
            if (sequence.substring(i - m, i).equals(word)) {
                dp[i] = dp[i - m] + 1;
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
/*"ababc"
"ab"
"ababc"
"ba"
"ababc"
"ac"*/

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String sequence = stringToString(line);
            line = in.readLine();
            String word = stringToString(line);

            int ret = new Solution().maxRepeating(sequence, word);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}