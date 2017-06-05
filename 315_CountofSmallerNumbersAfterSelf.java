public class Solution {
	
	//�������ڵ��ڲ���
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
        Node root = null;  //����һ���յĸ��ڵ�
        for (int i = nums.length - 1; i >= 0; i--) {  //�Ӻ���ǰ����
            root = insert(nums[i], root, ans, i, 0);
        }
        return Arrays.asList(ans);
    }
    private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
        if (node == null) {
            node = new Node(num, 0);
            ans[i] = preSum;
        } else if (node.val == num) {
            node.dup++;  //dup���ڼ�ĳ��ֵ���ظ�����
            ans[i] = preSum + node.sum;
        } else if (node.val > num) { //��������������������������ڲ�������������С�ڸ��ڵ㣬����preSum��ʼ��Ϊ0
            node.sum++;
            node.left = insert(num, node.left, ans, i, preSum);
        } else {  //��������������������preSum���Ǹ��ڵ��dup����sum�ټ���
            node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
        }
        return node;
    }
}