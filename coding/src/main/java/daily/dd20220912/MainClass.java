package daily.dd20220912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
    public int specialArray1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] >= i && (i == n || nums[i] < i)) {
                return i;
            }
        }
        return -1;
    }

    public int specialArray(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[1001];
        int tot = 0;
        for (int x : nums) {
            cnt[x]++;
            if (x > n) {
                tot++;
            }
        }

        for (int i = n; i > 0; i--) {
            tot += cnt[i];
            if (tot == i) {
                return i;
            }
        }
        return -1;
    }
}
/*[3,5]
[0,0]
[0,4,3,0,4]*/

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
            
            int ret = new Solution().specialArray(nums);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}