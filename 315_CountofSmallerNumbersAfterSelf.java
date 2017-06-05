public class Solution {
	
	//定义树节点内部类
    class Node {
        Node left, right;
        int val, sum, dup = 1;
        public Node(int v, int s) {
            val = v;
            sum = s;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        Node root = null;  //创建一个空的根节点
        for (int i = nums.length - 1; i >= 0; i--) {  //从后向前遍历
            root = insert(nums[i], root, ans, i, 0);
        }
        return Arrays.asList(ans);
    }
    private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
        if (node == null) {
            node = new Node(num, 0);
            ans[i] = preSum;
        } else if (node.val == num) {
            node.dup++;  //dup用于计某个值的重复个数
            ans[i] = preSum + node.sum;
        } else if (node.val > num) { //构建二叉查找树的左子树，由于查找树的左子树小于根节点，所以preSum初始化为0
            node.sum++;
            node.left = insert(num, node.left, ans, i, preSum);
        } else {  //构建右子树，右子树的preSum就是根节点的dup加上sum再加上
            node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
        }
        return node;
    }
}