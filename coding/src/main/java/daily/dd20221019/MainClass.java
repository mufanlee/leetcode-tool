package daily.dd20221019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] cnt = new int[2];
        for (int x : students) {
            cnt[x]++;
        }

        for (int x : sandwiches) {
            if (cnt[x] == 0) break;
            cnt[x]--;
        }
        return cnt[0] + cnt[1];
    }
}
/*[1,1,0,0]
[0,1,0,1]
[1,1,1,0,0,1]
[1,0,0,0,1,1]*/

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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] students = stringToIntegerArray(line);
            line = in.readLine();
            int[] sandwiches = stringToIntegerArray(line);

            int ret = new Solution().countStudents(students, sandwiches);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}