package daily.d202301.dd20230105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int countPairs(int[] nums, int low, int high) {
        return getCnt(nums, high) - getCnt(nums, low - 1);
    }

    private int getCnt(int[] nums, int x) {
        int res = 0;
        Trie01 trie01 = new Trie01();
        for (int i = 1; i < nums.length; i++) {
            trie01.insert(nums[i - 1]);
            res += trie01.search(nums[i], x);
        }
        return res;
    }
}

class Trie01 {
    private static class TrieNode {
        TrieNode[] next = new TrieNode[2];
        int cnt = 0;
    }

    TrieNode root;

    public Trie01() {
        this.root = new TrieNode();
    }

    public void insert(int num) {
        TrieNode node = root;
        for (int i = 14; i >= 0; --i) {
            int val = (num >>> i) & 1;
            if (node.next[val] == null) {
                node.next[val] = new TrieNode();
            }
            node = node.next[val];
            node.cnt++;
        }
    }

    public int search(int num, int x) {
        int res = 0;
        TrieNode node = root;
        for (int i = 14; i >= 0; --i) {
            int val = (num >>> i) & 1;
            if (((x >>> i) & 1) == 1) {
                if (node.next[val] != null) {
                    res += node.next[val].cnt;
                }
                if (node.next[val ^ 1] == null) {
                    return res;
                }
                node = node.next[val ^ 1];
            } else {
                if (node.next[val] == null) {
                    return res;
                }
                node = node.next[val];
            }
        }
        res += node.cnt;
        return res;
    }
}
/*[1,4,2,7]
2
6
[9,8,4,2,1]
5
14*/

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
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int low = Integer.parseInt(line);
            line = in.readLine();
            int high = Integer.parseInt(line);

            int ret = new Solution().countPairs(nums, low, high);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}