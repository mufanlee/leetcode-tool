package daily.d202210.dd20221029;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int id = ruleKey.equals("type") ? 0 : (ruleKey.equals("color") ? 1 : 2);
        int ans = 0;
        for (List<String> item : items) {
            if (item.get(id).equals(ruleValue)) {
                ans++;
            }
        }
        return ans;
    }
}
/*[["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]]
"color"
"silver"
[["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]]
"type"
"phone"*/

public class MainClass {
    public static List<String> stringToStringList(String line) {
        JsonArray jsonArray = JsonArray.readFrom(line);
        List<String> list = new ArrayList<>(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            list.add(jsonArray.get(i).asString());
        }
        return list;
    }
    
    public static List<List<String>> stringToString2dList(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
          return new ArrayList<List<String>>();
        }
        List<List<String>> list = new ArrayList<>(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
          JsonArray cols = jsonArray.get(i).asArray();
          list.add(stringToStringList(cols.toString()));
        }
        return list;
    }
    
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            List<List<String>> items = stringToString2dList(line);
            line = in.readLine();
            String ruleKey = stringToString(line);
            line = in.readLine();
            String ruleValue = stringToString(line);
            
            int ret = new Solution().countMatches(items, ruleKey, ruleValue);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}