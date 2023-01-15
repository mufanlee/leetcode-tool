package daily.dd20230112;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }

        StringBuilder ans = new StringBuilder();
        StringBuilder token = new StringBuilder();
        boolean flag = false;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                token = new StringBuilder();
                flag = true;
            } else if (c == ')') {
                ans.append(map.getOrDefault(token.toString(), "?"));
                flag = false;
            } else if (flag) {
                token.append(c);
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
/*"(name)is(age)yearsold"
[["name","bob"],["age","two"]]
"hi(name)"
[["a","b"]]
"(a)(a)(a)aaa"
[["a","yes"]]*/

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static List<String> stringToStringList(String line) {
        JsonArray jsonArray = JsonArray.readFrom(line);
        List<String> list = new ArrayList<>(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            list.add(jsonArray.get(i).asString());
        }
        return list;
    }
    
    public static String[] stringToStringArray(String line) {
        JsonArray jsonArray = JsonArray.readFrom(line);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
          arr[i] = jsonArray.get(i).asString();
        }
        return arr;
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
    
    public static List<List<String>> stringToString2dArray(String input) {
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
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            line = in.readLine();
            List<List<String>> knowledge = stringToString2dList(line);
            
            String ret = new Solution().evaluate(s, knowledge);
            
            String out = (ret);
            
            System.out.print(out);
        }
    }
}