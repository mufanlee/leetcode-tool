package daily.d202211.dd20221119;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0, sum = 0;
        for (int g : gain) {
            sum += g;
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
/*[-5,1,5,0,-7]
[-4,-3,-2,-1,4,3,2]*/

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] gain = stringToIntegerArray(line);
            
            int ret = new Solution().largestAltitude(gain);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}