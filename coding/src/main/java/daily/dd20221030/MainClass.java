package daily.dd20221030;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        dfs(0, s.toCharArray(), ans);
        return ans;
    }

    private void dfs(int id, char[] arr, List<String> res) {
        if (id == arr.length) {
            res.add(String.valueOf(arr));
            return;
        }

        dfs(id + 1, arr, res);
        if (Character.isLetter(arr[id])) {
            arr[id] ^= 32;
            dfs(id + 1, arr, res);
        }
    }
}
/*"a1b2"
"3z4"*/

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            List<String> ret = new Solution().letterCasePermutation(s);

            String out = stringListToString(ret);

            System.out.print(out);
        }
    }
}