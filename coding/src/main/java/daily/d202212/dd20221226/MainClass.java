package daily.d202212.dd20221226;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int countHomogenous(String s) {
        final long mod = 1000000007;
        long ans = 0;
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }

            long cnt = j - i;
            ans = (ans + cnt * (cnt + 1) / 2) % mod;
            i = j;
        }
        return (int) ans;
    }
}

/*"abbcccaa"
"xy"
"zzzzz"*/

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            
            int ret = new Solution().countHomogenous(s);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}