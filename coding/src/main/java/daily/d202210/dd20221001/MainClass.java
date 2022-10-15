package daily.d202210.dd20221001;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public String reformatNumber(String number) {
        StringBuilder ans = new StringBuilder();
        int cnt = 0;
        for (char c : number.toCharArray()) {
            if (c == ' ' || c == '-') {
                continue;
            }

            ans.append(c);
            cnt++;
            if (cnt == 3) {
                cnt = 0;
                ans.append('-');
            }
        }

        if (cnt == 1) {
            ans.deleteCharAt(ans.length() - 2);
            ans.insert(ans.length() - 2, '-');
        } else if (cnt == 0) {
            ans.deleteCharAt(ans.length() - 1);
        }
        return ans.toString();
    }
}
/*"1-23-45 6"
"123 4-567"
"123 4-5678"*/

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String number = stringToString(line);
            
            String ret = new Solution().reformatNumber(number);
            
            String out = (ret);
            
            System.out.print(out);
        }
    }
}