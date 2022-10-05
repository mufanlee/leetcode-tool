package daily.dd20221005;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String domain : cpdomains) {
            String[] ss = domain.split(" ");
            int cnt = Integer.parseInt(ss[0]);
            map.put(ss[1], map.getOrDefault(ss[1], 0) + cnt);
            for (int i = 0; i < ss[1].length(); i++) {
                if (ss[1].charAt(i) == '.') {
                    String s = ss[1].substring(i + 1);
                    map.put(s, map.getOrDefault(s, 0) + cnt);
                }
            }
        }
        List<String> ans = new ArrayList<>(map.size());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue() + " " + entry.getKey());
        }
        return ans;
    }
}
/*["9001 discuss.leetcode.com"]
["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]*/

public class MainClass {
    public static String[] stringToStringArray(String line) {
        JsonArray jsonArray = JsonArray.readFrom(line);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.get(i).asString();
        }
        return arr;
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
            String[] cpdomains = stringToStringArray(line);

            List<String> ret = new Solution().subdomainVisits(cpdomains);

            String out = stringListToString(ret);

            System.out.print(out);
        }
    }
}