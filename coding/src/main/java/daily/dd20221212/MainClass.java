package daily.dd20221212;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int beautySum(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] cnts = new int[26];
            int max = 0;
            for (int j = i + 1; j < s.length(); j++) {
                int id = s.charAt(j) - 'a';
                cnts[id]++;
                max = Math.max(max, cnts[id]);
                int min = s.length();
                for (int x : cnts) {
                    if (x > 0) {
                        min = Math.min(min, x);
                    }
                }
                ans += max - min;
            }
        }
        return ans;
    }
}
/*"aabcb"
"aabcbaa"*/

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            
            int ret = new Solution().beautySum(s);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}