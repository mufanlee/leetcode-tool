package daily.dd20230111;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public boolean digitCount(String num) {
        int[] cnt = new int[10];
        for (char c : num.toCharArray()) {
            cnt[c - '0']++;
        }

        for (int i = 0; i < num.length(); i++) {
            if (cnt[i] != num.charAt(i) - '0') {
                return false;
            }
        }
        return true;
    }
}
/*"1210"
"030"*/

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String num = stringToString(line);
            
            boolean ret = new Solution().digitCount(num);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
        }
    }
}