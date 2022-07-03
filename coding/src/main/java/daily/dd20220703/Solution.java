package daily.dd20220703;

class Solution {
    public int nextGreaterElement(int n) {
        // 转换为字符数组
        char[] nums = Integer.toString(n).toCharArray();
        // 反转
        reverse(0, nums.length - 1, nums);
        // 从最小位置开始，找出第一个降序位置
        int idx = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                idx = i + 1;
                break;
            }
        }
        // 没找到，即数组本来就是降序，没有比其大的最小整数，返回-1
        if (idx == -1) return -1;
        // 找出(0,idx-1)中比idx出值大的最小值，由于(0,idx-1)是增序的，直接从0位置开始找
        int idy = -1;
        for (int i = 0; i < idx; i++) {
            if (nums[i] > nums[idx]) {
                idy = i;
                break;
            }
        }
        // 交换两个数
        swap(idx, idy, nums);
        // 将(0,idx-1)中的数变为降序
        reverse(0, idx - 1, nums);
        // 求出整数
        long val = 0;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            val = val * 10 + (nums[i] - '0');
        }
        return val > Integer.MAX_VALUE ? -1 : (int) val;
    }

    private void reverse(int i, int j, char[] nums) {
        while (i < j) {
            swap(i, j, nums);
            i++;
            j--;
        }
    }

    private void swap(int i, int j, char[] nums) {
        char tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nextGreaterElement(12385764));
    }
}