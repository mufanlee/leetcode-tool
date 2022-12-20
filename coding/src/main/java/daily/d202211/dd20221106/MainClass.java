package daily.d202211.dd20221106;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public String interpret(String command) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                ans.append('G');
            } else if (command.charAt(i) == '(') {
                if (command.charAt(i + 1) == ')') {
                    ans.append('o');
                } else {
                    ans.append("al");
                }
            }
        }
        return ans.toString();
    }
}
/*"G()(al)"
"G()()()()(al)"
"(al)G(al)()()G"*/

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String command = stringToString(line);

            String ret = new Solution().interpret(command);

            String out = (ret);

            System.out.print(out);
        }
    }
}