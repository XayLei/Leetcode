/*
���ͣ�
     ����һ���������飬������ȫ�ǷǸ���������ÿ��Ԫ�ش����ڴ�λ�ÿ�����Ծ��������
	 �жϴ��������λ�������Ƿ����������������һ��λ��
	 
�㷨���ͣ�
     ����һ�����ֵ�����ڱ�����ÿ��λ���Ͽ�����Ծ��������
	 ���λ�õ�����i����max����˵���޷��������һ��λ�ã�����FALSE
	 ����˵��iС��max�������һ��λ��ǰ��ĳ���ط��������Ծ���볬�������һ��λ�õ�����
	 ����true

*/

public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int max=0;
        for(int i=0; i<n; i++){
            if(i>max) return false;
            max = Math.max(nums[i]+i,max);
        }
        return true;
    }
}