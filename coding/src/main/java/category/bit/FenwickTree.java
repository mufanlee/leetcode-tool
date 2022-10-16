package category.bit;

/**
 * FenwickTree
 *
 * @author lipeng
 */
public class FenwickTree {
    private int[] tree;

    public FenwickTree(int[] nums) {
        this.tree = nums;
    }

    public void add(int id, int val) {
        for (int i = id; i < tree.length; i += lowbit(i)) tree[i] += val;
    }

    public int sum(int id) {
        int res = 0;
        for (int i = id; i > 0; i -= lowbit(i)) res += tree[i];
        return res;
    }

    public static int lowbit(int x) {
        return x & -x;
    }
}
