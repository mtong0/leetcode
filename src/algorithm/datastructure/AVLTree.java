//package src.datastructure;
//
//class TreeNode {
//    int val;
//    int height;
//    TreeNode left;
//    TreeNode right;
//    TreeNode() {}
//    TreeNode(int val) { this.val = val; }
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//
//    public int insert(int val) {
//        int rightHeight = 0 ;
//        int leftHeight = 0;
//        if (val > this.val) {
//            if (right == null) {
//                right = new TreeNode(val);
//                rightHeight = 1;
//            } else {
//                rightHeight = right.insert(val);
//            }
//        } else {
//            if (left == null) {
//                left = new TreeNode(val);
//                leftHeight = 1;
//            } else {
//                leftHeight = left.insert(val);
//            }
//
//        }
//    }
//}
//public class AVLTree {
//    public TreeNode init() {
//        return null;
//    }
//
//
//}
