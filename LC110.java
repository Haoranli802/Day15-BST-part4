class Solution {
    public boolean isBalanced(TreeNode root) {
        return level(root) != -1;
    }
    private int level(TreeNode root){
        if(root == null) return 0;
        int left = level(root.left);
        if(left == -1) return -1;
        
        int right = level(root.right);
        if(right == -1) return -1;
        
        if(Math.abs(left - right) > 1) return -1;
        return Math.max(level(root.left), level(root.right)) + 1;
    }
}
//O(N), O(N)
