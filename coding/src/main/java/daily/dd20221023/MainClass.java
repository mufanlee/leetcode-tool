package daily.dd20221023;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0, j = 0; i < word1.length() || j < word2.length(); i++, j++) {
            if (i < word1.length()) {
                ans.append(word1.charAt(i));
            }
            if (j < word2.length()) {
                ans.append(word2.charAt(j));
            }
        }
        return ans.toString();
    }
}
/*"abc"
"pqr"
"ab"
"pqrs"
"abcd"
"pq"*/

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String word1 = stringToString(line);
            line = in.readLine();
            String word2 = stringToString(line);
            
            String ret = new Solution().mergeAlternately(word1, word2);
            
            String out = (ret);
            
            System.out.print(out);
        }
    }
}