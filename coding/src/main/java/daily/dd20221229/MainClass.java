package daily.dd20221229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> ans = new ArrayList<>();
        int[] cnt = new int[101];
        for(int x : nums1) cnt[x] |= 1;
        for(int x : nums2) cnt[x] |= 2;
        for(int x : nums3) cnt[x] |= 4;
        for(int i = 1; i <= 100; i++) {
            int x = cnt[i];
            if((x & (x - 1)) > 0) ans.add(i);
        }
        return ans;
    }
}
/*[1,1,3,2]
[2,3]
[3]
[3,1]
[2,3]
[1,2]
[1,2,2]
[4,3,3]
[5]*/

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
    
    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums1 = stringToIntegerArray(line);
            line = in.readLine();
            int[] nums2 = stringToIntegerArray(line);
            line = in.readLine();
            int[] nums3 = stringToIntegerArray(line);
            
            List<Integer> ret = new Solution().twoOutOfThree(nums1, nums2, nums3);
            
            String out = integerArrayListToString(ret);
            
            System.out.print(out);
        }
    }
}