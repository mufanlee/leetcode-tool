package daily.dd20220814;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int maxScore(String s) {
        int ans = 0;
        int one = 0;
        for (char c : s.toCharArray()) {
            one += c - '0';
        }

        int zero = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zero++;
            } else {
                one--;
            }
            ans = Math.max(ans, zero + one);
        }
        return ans;
    }
}
/*"011101"
"00111"
"1111"*/

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            
            int ret = new Solution().maxScore(s);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}