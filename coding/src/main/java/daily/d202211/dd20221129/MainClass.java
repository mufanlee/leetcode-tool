package daily.d202211.dd20221129;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int minOperations(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt += (s.charAt(i) - '0') ^ (i & 1);
        }
        return Math.min(cnt, s.length() - cnt);
    }
}
/*"0100"
"10"
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
            
            int ret = new Solution().minOperations(s);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}