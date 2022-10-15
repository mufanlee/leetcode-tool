package daily.d202209.dd20220909;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int minOperations(String[] logs) {
        int depth = 0;
        for (String log : logs) {
            if ("./".equals(log)) {
            } else if ("../".equals(log)) {
                if (depth > 0) {
                    depth--;
                }
            } else {
                depth++;
            }
        }
        return depth;
    }
}
/*["d1/","d2/","../","d21/","./"]
["d1/","d2/","./","d3/","../","d31/"]
["d1/","../","../","../"]*/

public class MainClass {
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
            String[] logs = stringToStringArray(line);

            int ret = new Solution().minOperations(logs);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}