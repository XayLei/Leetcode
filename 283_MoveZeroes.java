public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums==null || nums.length==0) return;
        
        int insertNum=0;
        for(int num : nums){  //��������
            if(num!=0) nums[insertNum++] = num;  //���Ԫ�ز�Ϊ0����˳����뵽������
        }
        
        while(insertNum<nums.length){ //��󣬲�Ϊ0��Ԫ��ȫ����˳����뵽������ǰ�棬��ʱ���insertNumС�����鳤�ȣ����ں���ȫ����0
            nums[insertNum++] = 0;
        }
    }
}