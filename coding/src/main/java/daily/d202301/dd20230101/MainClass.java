package daily.d202301.dd20230101;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public char repeatedCharacter(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
            if (cnt[c - 'a'] == 2) {
                return c;
            }
        }
        return 'a';
    }
}
/*"abccbaacz"
"abcdd"*/

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static String charToString(char c) {
        return stringToString(String.valueOf(c));
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            
            char ret = new Solution().repeatedCharacter(s);
            
            String out = charToString(ret);
            
            System.out.print(out);
        }
    }
}