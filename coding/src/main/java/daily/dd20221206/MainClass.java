package daily.dd20221206;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) <= '9') {
                int j = i;
                while (j < word.length() && word.charAt(j) <= '9') j++;
                while (i < j && word.charAt(i) == '0') i++;
                set.add(word.substring(i, j));
                i = j;
            }
        }
        return set.size();
    }
}
/*"a123bc34d8ef34"
"leet1234code234"
"a1b01c001"*/

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String word = stringToString(line);
            
            int ret = new Solution().numDifferentIntegers(word);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}