package daily.d202212.dd20221223;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (String op : operations) {
            if ("X++".equals(op) || "++X".equals(op)) {
                ans++;
            } else {
                ans--;
            }
        }
        return ans;
    }
}
/*["--X","X++","X++"]
["++X","++X","X++"]
["X++","++X","--X","X--"]*/

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
            String[] operations = stringToStringArray(line);

            int ret = new Solution().finalValueAfterOperations(operations);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}