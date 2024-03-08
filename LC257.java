class Solution {
    List<String> result;
    List<Integer> path;
    public List<String> binaryTreePaths(TreeNode root) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        backTracking(root);
        return result;
    }
    private void backTracking(TreeNode root){
        path.add(root.val);
        if(root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < path.size() - 1; i++){
                sb.append(path.get(i));
                sb.append("->");
            }
            sb.append(path.get(path.size() - 1));
            result.add(sb.toString());
        }
        if(root.left != null){
            backTracking(root.left);
            path.removeLast();
        }
        if(root.right != null){
            backTracking(root.right);
            path.removeLast();
        }
    }
}
//O(N^2), O(N^2)

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        Stack<Object> stack = new Stack<>();
        stack.push(root);
        stack.push(root.val + "");
        while(!stack.isEmpty()){
            String path = (String)stack.pop();
            TreeNode cur = (TreeNode)stack.pop();
            if(cur.left == null && cur.right == null){
                result.add(path);
            }
            if(cur.left != null){
                stack.push(cur.left);
                stack.push(path + "->" + cur.left.val);
            }
            if(cur.right != null){
                stack.push(cur.right);
                stack.push(path + "->" + cur.right.val);
            }
        }
        return result;
    }
}

//O(N^2), O(N^2)
