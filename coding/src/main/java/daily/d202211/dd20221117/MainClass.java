package daily.d202211.dd20221117;

import base.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        List<Integer>[] lists = new List[26];
        for (int i = 0; i < 26; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < s.length(); i++) {
            lists[s.charAt(i) - 'a'].add(i);
        }

        int ans = 0;
        for (String word : words) {
            int i = 0;
            boolean flag = true;
            for (char c : word.toCharArray()) {
                int k = binarySearch(lists[c - 'a'], i);
                if (k == -1) {
                    flag = false;
                    break;
                }
                i = k + 1;
            }
            if (flag) {
                ans++;
            }
        }
        return ans;
    }

    private int binarySearch(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = l + r >> 1;
            if (list.get(mid) >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l == list.size() ? -1 : list.get(l);
    }
}
/*"abcde"
["a","bb","acd","ace"]
"dsahjpjauf"
["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]*/

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static String[] stringToStringArray(String line) {
        JsonArray jsonArray = JsonArray.readFrom(line);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.get(i).asString();
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            line = in.readLine();
            String[] words = stringToStringArray(line);

            int ret = new Solution().numMatchingSubseq(s, words);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}