public class Solution {
    public int removeDuplicates(int[] nums) {
        int count=1, n=nums.length;
        if(n < 2) return n;  //�������ĳ���С��2����ֱ�ӷ�������ĳ��ȣ������ܴ����ظ���Ԫ��
        for(int i=1;i<n;i++){  //ѭ������������ĵڶ���Ԫ�ؿ�ʼ
            if(nums[i]!=nums[i-1]){
                nums[count++] = nums[i]; //�Ƚ����ظ���Ԫ����ǰ�ƶ���Ȼ�����count��ֵ
            }
        }
        return count;
    }
}