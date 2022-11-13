package daily.dd20221113;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String customSortString1(String order, String s) {
        int[] ids = new int[26];
        Arrays.fill(ids, 26);
        for (int i = 0; i < order.length(); i++) {
            ids[order.charAt(i) - 'a'] = i;
        }

        Character[] chars = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        Arrays.sort(chars, Comparator.comparingInt(a -> ids[a - 'a']));
        StringBuilder ans = new StringBuilder();
        for (char c : chars) {
            ans.append(c);
        }
        return ans.toString();
    }

    public String customSortString(String order, String s) {
        int[] cnts = new int[26];
        for (char c : s.toCharArray()) {
            cnts[c - 'a']++;
        }

        StringBuilder ans = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (cnts[c - 'a']-- > 0) ans.append(c);
        }
        for (int i = 0; i < 26; i++) {
            while (cnts[i]-- > 0) ans.append((char) (i + 'a'));
        }
        return ans.toString();
    }
}
/*"cba"
"abcd"
"cbafg"
"abcd"*/

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String order = stringToString(line);
            line = in.readLine();
            String s = stringToString(line);

            String ret = new Solution().customSortString(order, s);

            String out = (ret);

            System.out.print(out);
        }
    }
}