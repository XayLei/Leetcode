/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
题目：
给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
*/
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null) return null;
        if(pNode.right!=null){ //如果右子树不为空，则按照中序遍历的结果，下一个节点为右子树的最左节点
            pNode = pNode.right;
            while(pNode.left!=null)
                pNode = pNode.left;
            return pNode;
        }
        while(pNode.next!=null){ //若右子树为空，则下个节点为当前节点的父节点，且当前节点是父节点的左子节点
            if(pNode.next.left==pNode) //如果当前节点是父节点的左子节点，则直接返回当前节点的父节点
                return pNode.next;
            pNode = pNode.next;
        }
        return null;
    }
}