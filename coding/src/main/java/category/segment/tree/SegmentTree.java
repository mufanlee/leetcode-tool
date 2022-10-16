package category.segment.tree;

/**
 * 线段树
 *
 * @author lipeng
 */
public class SegmentTree {
    class SegmentTreeNode {
        public int start, end;
        public SegmentTreeNode left, right;
        private int val;

        public SegmentTreeNode(int start, int end, int val) {
            this.start = start;
            this.end = end;
            this.val = val;
        }
    }

    public SegmentTreeNode build(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public SegmentTreeNode build(int[] nums, int start, int end) {
        if (start == end) {
            return new SegmentTreeNode(start, end, nums[start]);
        }

        SegmentTreeNode root = new SegmentTreeNode(start, end, nums[start]);
        int mid = (start + end) >> 1;
        root.left = build(nums, start, mid);
        root.right = build(nums, mid + 1, end);
        root.val = root.left.val + root.right.val;
        return root;
    }

    public int query(SegmentTreeNode root, int start, int end) {
        if (start <= root.start && root.end <= end) {
            return root.val;
        }

        int mid = (start + end) >> 1;
        int res = 0;
        if (start <= mid) res += query(root.left, start, end);
        if (end > mid) res += query(root.right, start, end);
        return res;
    }

    public void update(SegmentTreeNode root, int index, int val) {
        if (root.start == index && root.end == index) {
            root.val = val;
            return;
        }

        int mid = (root.start + root.end) >> 1;
        if (index <= mid) {
            update(root.left, index, val);
        } else {
            update(root.right, index, val);
        }
        root.val = root.left.val + root.right.val;
    }
}
