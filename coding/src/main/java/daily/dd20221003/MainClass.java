package daily.dd20221003;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public boolean checkOnesSegment(String s) {
        int i = 1;
        while (i < s.length() && s.charAt(i) == '1') {
            i++;
        }

        while (i < s.length()) {
            if (s.charAt(i) == '1') {
                return false;
            }
            i++;
        }
        return true;
    }
}
/*"1001"
"110"*/

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

            boolean ret = new Solution().checkOnesSegment(s);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}