package category.segment.array;

/**
 * 线段树
 *
 * @author lipeng
 */
public class SegmentTree {
    private int[] tree;
    private int n;

    public SegmentTree(int[] nums) {
        n = nums.length;
        tree = new int[n * 4];
        build(1, 0, n - 1, nums);
    }

    public int query(int start, int end) {
        return query(1, 0, n - 1, start, end);
    }

    public void update(int index, int val) {
        update(1, 0, n - 1, index, val);
    }

    private int build(int node, int left, int right, int[] nums) {
        if (left == right) {
            return tree[node] = nums[left];
        }
        int mid = (left + right) >> 1;
        int leftVal = build(node * 2, left, mid, nums);
        int rightVal = build(node * 2 + 1, mid + 1, right, nums);
        return tree[node] = leftVal + rightVal;
    }

    private int query(int node, int left, int right, int start, int end) {
        if (end < left || start > right) {
            return 0;
        }

        if (start <= left && right <= end) {
            return tree[node];
        }

        int mid = (left + right) >> 1;
        return query(node * 2, left, mid, start, end)
                + query(node * 2 + 1, mid + 1, right, start, end);
    }

    private void update(int node, int left, int right, int index, int val) {
        if (left == right) {
            tree[node] = val;
            return;
        }

        int mid = (left + right) >> 1;
        if (left <= index && index <= mid) {
            update(node * 2, left, mid, index, val);
        } else {
            update(node * 2 + 1, mid + 1, right, index, val);
        }
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
}
