package daily.d202209.dd20220927;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] letters = new int[256];
        for (char c : s1.toCharArray()) {
            letters[c]++;
        }

        for (char c : s2.toCharArray()) {
            letters[c]--;
            if (letters[c] < 0) return false;
        }
        return true;
    }
}
/*"abc"
"bca"
"abc"
"bad"*/

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

            boolean ret = new Solution().CheckPermutation(s1, s2);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}