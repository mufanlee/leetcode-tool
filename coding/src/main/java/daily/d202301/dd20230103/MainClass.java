package daily.d202301.dd20230103;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public boolean areNumbersAscending(String s) {
        int i = 0, pre = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int sum = 0;
                while (i < s.length() && s.charAt(i) != ' ') {
                    sum = sum * 10 + s.charAt(i) - '0';
                    i++;
                }
                if (sum <= pre) return false;
                pre = sum;
            } else if (c != ' ') {
                while (i < s.length() && s.charAt(i) != ' ') i++;
            }
            i++;
        }
        return true;
    }
}
/*"1 box has 3 blue 4 red 6 green and 12 yellow marbles"
"hello world 5 x 5"
"sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"*/

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
            String s = stringToString(line);
            
            boolean ret = new Solution().areNumbersAscending(s);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
        }
    }
}