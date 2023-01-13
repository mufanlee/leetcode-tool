package daily.dd20230113;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] cnt1 = new int[26];
        for (char c : s.toCharArray()) {
            cnt1[c - 'a']++;
        }
        int[] cnt2 = new int[26];
        for (char c : target.toCharArray()) {
            cnt2[c - 'a']++;
        }
        int ans = s.length();
        for (int i = 0; i < 26; i++) {
            if (cnt2[i] != 0)
                ans = Math.min(ans, cnt1[i] / cnt2[i]);
        }
        return ans;
    }
}
/*"ilovecodingonleetcode"
"code"
"abcba"
"abc"
"abbaccaddaeea"
"aaaaa"*/

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
            String target = stringToString(line);

            int ret = new Solution().rearrangeCharacters(s, target);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}