package daily.d202210.dd20221002;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public boolean canTransform(String start, String end) {
        int n = start.length();
        int i = 0, j = 0;
        while (i < n || j < n) {
            while (i < n && start.charAt(i) == 'X') i++;
            while (j < n && end.charAt(j) == 'X') j++;
            if (i == n || j == n) return i == j;
            if (start.charAt(i) != end.charAt(j)) return false;
            if (start.charAt(i) == 'L' && i < j) return false;
            if (start.charAt(i) == 'R' && i > j) return false;
            i++;
            j++;
        }
        return true;
    }
}
/*"RXXLRXRXL"
"XRLXXRRLX"
"X"
"L"*/

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
            String start = stringToString(line);
            line = in.readLine();
            String end = stringToString(line);
            
            boolean ret = new Solution().canTransform(start, end);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
        }
    }
}