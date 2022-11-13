package daily.dd20221111;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int prefix = 0, suffix = 0;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (set.contains(s.charAt(i))) prefix++;
            if (set.contains(s.charAt(j))) suffix++;
            i++;
            j--;
        }
        return prefix == suffix;
    }
}
/*"book"
"textbook"*/

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            
            boolean ret = new Solution().halvesAreAlike(s);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
        }
    }
}