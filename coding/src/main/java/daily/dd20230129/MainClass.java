package daily.dd20230129;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int countAsterisks(String s) {
        boolean valid = true;
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (c == '|') {
                valid = !valid;
            } else if (c == '*' && valid) {
                ans++;
            }
        }
        return ans;
    }
}
/*"l|*e*et|c**o|*de|"
"iamprogrammer"
"yo|uar|e**|b|e***au|tifu|l"*/

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            
            int ret = new Solution().countAsterisks(s);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}