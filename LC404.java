class Solution {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        sumHelper(root);
        return sum;
    }
    private void sumHelper(TreeNode root){
        if(root.left != null && root.left.left == null && root.left.right == null){
            sum += root.left.val;
        }
        else{
            if(root.left != null) sumHelper(root.left);
        }
        if(root.right != null) sumHelper(root.right);
    }
}
//O(N)
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur.left != null && cur.left.left == null && cur.left.right == null){
                sum += cur.left.val;
            }
            if(cur.left != null) stack.push(cur.left);
            if(cur.right != null) stack.push(cur.right);
        }
        return sum;
    }
}
//O(N)
