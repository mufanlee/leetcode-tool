package daily.d202212.dd20221228;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int minimumLength(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            char c = s.charAt(i);
            while (i <= j && s.charAt(i) == c) i++;
            while (i <= j && s.charAt(j) == c) j--;
        }
        return j - i + 1;
    }
}

/*"ca"
"cabaabac"
"aabccabba"*/

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            
            int ret = new Solution().minimumLength(s);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}