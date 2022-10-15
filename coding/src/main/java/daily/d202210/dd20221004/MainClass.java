package daily.d202210.dd20221004;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int minAddToMakeValid(String s) {
        int ans = 0;
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (deque.isEmpty()) {
                    ans++;
                } else {
                    deque.pop();
                }
            } else {
                deque.push(c);
            }
        }
        while (!deque.isEmpty()) {
            deque.pop();
            ans++;
        }
        return ans;
    }
}
/*"())"
"((("*/

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            int ret = new Solution().minAddToMakeValid(s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}