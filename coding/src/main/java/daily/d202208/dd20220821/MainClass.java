package daily.d202208.dd20220821;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int isPrefixOfWord1(String sentence, String searchWord) {
        String[] ss = sentence.split(" ");
        for (int i = 0; i < ss.length; i++) {
            if (ss[i].startsWith(searchWord)) {
                return i;
            }
        }
        return -1;
    }

    public int isPrefixOfWord(String sentence, String searchWord) {
        int n = sentence.length(), index = 1, start = 0, end = 0;
        while (start < n) {
            while (end < n && sentence.charAt(end) != ' ') {
                end++;
            }
            if (isPrefix(sentence, start, end, searchWord)) {
                return index;
            }

            index++;
            end++;
            start = end;
        }
        return -1;
    }

    public boolean isPrefix(String sentence, int start, int end, String searchWord) {
        for (int i = 0; i < searchWord.length(); i++) {
            if (start + i >= end || sentence.charAt(start + i) != searchWord.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
/*"i love eating burger"
"burg"
"this problem is an easy problem"
"pro"
"i am tired"
"you"*/

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String sentence = stringToString(line);
            line = in.readLine();
            String searchWord = stringToString(line);
            
            int ret = new Solution().isPrefixOfWord(sentence, searchWord);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}