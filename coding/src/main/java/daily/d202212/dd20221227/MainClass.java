package daily.d202212.dd20221227;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int minimumMoves(String s) {
        int ans = 0, i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'X') {
                i += 3;
                ans++;
            } else {
                i++;
            }
        }
        return ans;
    }
}

/*"XXX"
"XXOX"
"OOOO"*/

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            
            int ret = new Solution().minimumMoves(s);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}