package daily.dd20221108;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (char c : allowed.toCharArray()) set.add(c);
        int ans = 0;
        for (String word : words) {
            boolean flag = true;
            for (char c : word.toCharArray()) {
                if (!set.contains(c)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans++;
            }
        }
        return ans;
    }
}
/*"ab"
["ad","bd","aaab","baa","badab"]
"abc"
["a","b","c","ab","ac","bc","abc"]
"cad"
["cc","acd","b","ba","bac","bad","ac","d"]*/

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static String[] stringToStringArray(String line) {
        JsonArray jsonArray = JsonArray.readFrom(line);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.get(i).asString();
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String allowed = stringToString(line);
            line = in.readLine();
            String[] words = stringToStringArray(line);

            int ret = new Solution().countConsistentStrings(allowed, words);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}