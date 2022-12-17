package src.segmenttree;

public class No307 {
    SegmentTreeNode segmentTreeNode;
    public No307(int[] nums) {
        segmentTreeNode = new SegmentTreeNode(0, nums.length - 1, 0).buildTree(0, nums.length-1, nums);
    }

    public void update(int index, int val) {
        segmentTreeNode.updateTree(index, val);
    }

    public int sumRange(int left, int right) {
        return segmentTreeNode.sumRange(left, right);
    }

    private static class SegmentTreeNode {
        int start;
        int end;
        int sum;
        SegmentTreeNode left;
        SegmentTreeNode right;

        public SegmentTreeNode(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
        }

        public SegmentTreeNode(int start, int end, int sum, SegmentTreeNode left, SegmentTreeNode right) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            this.left = left;
            this.right = right;
        }

        static SegmentTreeNode buildTree(int start, int end, int[] vals) {
            if (start == end) {
                return new SegmentTreeNode(start, end, vals[start]);
            }
            int mid = (start + end) / 2;
            SegmentTreeNode left = buildTree(start, mid,  vals);
            SegmentTreeNode right = buildTree(mid + 1, end, vals);
            return new SegmentTreeNode(start, end, left.sum + right.sum, left, right);
        }

        void updateTree(int index, int val) {
            if (index == start && index == end) {
                sum = val;
                return;
            }
            int mid = (start + end) / 2;
            if (index <= mid) {
                left.updateTree(index, val);
            } else {
                right.updateTree(index, val);
            }
            sum = left.sum + right.sum;
        }

        int sumRange(int leftIndex, int rightIndex) {
            if (leftIndex == this.start && rightIndex == this.end) {
                return sum;
            }
            int mid = (start + end) / 2;
            if (leftIndex > mid) {
                return right.sumRange(leftIndex, rightIndex);
            } else if (rightIndex <= mid) {
                return left.sumRange(leftIndex, rightIndex);
            } else {
                return left.sumRange(leftIndex, mid) + right.sumRange(mid+1, rightIndex);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        No307 no307 = new No307(nums);
        no307.update(1,2);
        System.out.println(no307.sumRange(0, 2));
    }
}

