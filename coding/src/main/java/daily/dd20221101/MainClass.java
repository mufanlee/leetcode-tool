package daily.dd20221101;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0, j = 0, x = 0, y = 0;
        while (i < word1.length && j < word2.length) {
            if (word1[i].charAt(x++) != word2[j].charAt(y++)) {
                return false;
            }

            if (x == word1[i].length()) {
                i++;
                x = 0;
            }

            if (y == word2[j].length()) {
                j++;
                y = 0;
            }
        }
        return i == word1.length && j == word2.length;
    }
}
/*["ab", "c"]
["a", "bc"]
["a", "cb"]
["ab", "c"]
["abc", "d", "defg"]
["abcddefg"]*/

public class MainClass {
    public static String[] stringToStringArray(String line) {
        JsonArray jsonArray = JsonArray.readFrom(line);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.get(i).asString();
        }
        return arr;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String[] word1 = stringToStringArray(line);
            line = in.readLine();
            String[] word2 = stringToStringArray(line);

            boolean ret = new Solution().arrayStringsAreEqual(word1, word2);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}