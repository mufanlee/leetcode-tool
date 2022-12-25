package daily.dd20221224;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder ans = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() || j < word2.length()) {
            char a = i < word1.length() ? word1.charAt(i) : ' ';
            char b = j < word2.length() ? word2.charAt(j) : ' ';
            if (word1.substring(i).compareTo(word2.substring(j)) < 0) {
                ans.append(b);
                j++;
            } else {
                ans.append(a);
                i++;
            }
        }
        return ans.toString();
    }
}

/*"cabaa"
"bcaaa"
"abcabc"
"abdcaba"*/

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String word1 = stringToString(line);
            line = in.readLine();
            String word2 = stringToString(line);

            String ret = new Solution().largestMerge(word1, word2);

            String out = (ret);

            System.out.print(out);
        }
    }
}