package daily.dd20230116;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        int i = 0, j = 0, m = words1.length, n = words2.length;
        while (i < m && i < n && words1[i].equals(words2[i])) {
            i++;
        }
        while (j < m - i && j < n - i && words1[m - j - 1].equals(words2[n - j - 1])) {
            j++;
        }
        return i + j == Math.min(m, n);
    }
}
/*"My name is Haley"
"My Haley"
"of"
"A lot of words"
"Eating right now"
"Eating"*/

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
            String sentence1 = stringToString(line);
            line = in.readLine();
            String sentence2 = stringToString(line);
            
            boolean ret = new Solution().areSentencesSimilar(sentence1, sentence2);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
        }
    }
}