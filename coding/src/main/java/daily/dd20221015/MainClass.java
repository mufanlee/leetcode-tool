package daily.dd20221015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1, j = 0; i <= n && j < target.length; i++) {
            ans.add("Push");
            if (target[j] == i) {
                j++;
            } else {
                ans.add("Pop");
            }
        }
        return ans;
    }
}
/*[1,3]
3
[1,2,3]
3
[1,2]
4*/

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] target = stringToIntegerArray(line);
            line = in.readLine();
            int n = Integer.parseInt(line);

            List<String> ret = new Solution().buildArray(target, n);

            String out = stringListToString(ret);

            System.out.print(out);
        }
    }
}