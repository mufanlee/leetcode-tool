package daily.d202210.dd20221027;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int arraySign(int[] nums) {
        int ans = 1;
        for (int x : nums) {
            if (x == 0) return 0;
            ans *= x < 0 ? -1 : 1;
        }
        return ans;
    }
}
/*[-1,-2,-3,-4,3,2,1]
[1,5,0,2,-3]
[-1,1,-1,1,-1]*/

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
            int[] nums = stringToIntegerArray(line);
            
            int ret = new Solution().arraySign(nums);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}