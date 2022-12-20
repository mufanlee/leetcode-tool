package daily.d202212.dd20221213;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public boolean checkIfPangram(String sentence) {
        int mask = 0;
        for (char c : sentence.toCharArray()) {
            mask |= 1 << (c - 'a');
        }
        return mask == (1 << 26) - 1;
    }
}
/*"thequickbrownfoxjumpsoverthelazydog"
"leetcode"*/

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
            String sentence = stringToString(line);

            boolean ret = new Solution().checkIfPangram(sentence);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}