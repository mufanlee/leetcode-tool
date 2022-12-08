package daily.dd20221207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m * 6 < n || n * 6 < m) {
            return -1;
        }

        int d = 0;
        for (int x : nums2) d += x;
        for (int x : nums1) d -= x;
        if (d < 0) {
            d = -d;
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        int[] cnt = new int[6];
        for (int x : nums1) cnt[6 - x]++;
        for (int x : nums2) cnt[x - 1]++;

        int ans = 0;
        for (int i = 5; i > 0; i--) {
            if (d <= i * cnt[i]) {
                return ans + (d + i - 1) / i;
            }

            d -= i * cnt[i];
            ans += cnt[i];
        }
        return ans;
    }
}
/*[1,2,3,4,5,6]
[1,1,2,2,2,2]
[1,1,1,1,1,1,1]
[6]
[6,6]
[1]*/

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
            int[] nums1 = stringToIntegerArray(line);
            line = in.readLine();
            int[] nums2 = stringToIntegerArray(line);
            
            int ret = new Solution().minOperations(nums1, nums2);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}