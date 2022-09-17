package daily.dd20220917;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int ans = 0;
        int[] ids = new int[26];
        Arrays.fill(ids, -1);
        for (int i = 0; i < s.length(); i++) {
            int id = s.charAt(i) - 'a';
            if (ids[id] != -1) {
                ans = Math.max(ans, i - ids[id] - 1);
            } else {
                ids[id] = i;
            }
        }
        return ans;
    }
}
/*"aa"
"abca"
"cbzxy"*/

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            
            int ret = new Solution().maxLengthBetweenEqualCharacters(s);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}