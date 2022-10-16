package daily.dd20221011;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int x = -1, y = -1;
        for(int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (x == -1) x = i;
                else if (y == -1) y = i;
                else return false;
            }
        }
        if (x == -1) return true;
        else if (y == -1) return false;
        else return s1.charAt(x) == s2.charAt(y) && s1.charAt(y) == s2.charAt(x);
    }
}
/*"bank"
"kanb"
"attack"
"defend"
"kelb"
"kelb"*/

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
            String s1 = stringToString(line);
            line = in.readLine();
            String s2 = stringToString(line);

            boolean ret = new Solution().areAlmostEqual(s1, s2);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}