package daily.dd20220811;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public String reformat(String s) {
        int digitCnt = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCnt++;
            }
        }

        int n = s.length();
        int alphaCnt = n - digitCnt;
        if (Math.abs(alphaCnt - digitCnt) > 1) {
            return "";
        }

        boolean flag = digitCnt > alphaCnt;
        char[] chars = s.toCharArray();
        for (int i = 0, j = 1; i < n; i += 2) {
            if (Character.isDigit(chars[i]) != flag) {
                while (Character.isDigit(chars[j]) != flag) {
                    j += 2;
                }
                char c = chars[i];
                chars[i] = chars[j];
                chars[j] = c;
            }
        }
        return String.valueOf(chars);
    }
}
/*"a0b1c2"
"leetcode"
"1229857369"*/

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            String ret = new Solution().reformat(s);

            String out = (ret);

            System.out.print(out);
        }
    }
}