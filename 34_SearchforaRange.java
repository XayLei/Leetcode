public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = Solution.startSearch(nums,target);
        if(start==nums.length || nums[start] != target) return new int[]{-1,-1};
        return new int[]{start,Solution.startSearch(nums,target+1)-1}; //ȷ����β
    }
    
	//���ö��ַ����ң�����Ϊ��������
    private static int startSearch(int[] nums, int target){
        int left = 0,right=nums.length;
        while(left<right){
            int mid = left+(right-left)/2; //ȡ�����м�����
            if(nums[mid]<target){ //��������м�ֵС��target������Ҫ����߽缴left������mid+1��
                left = mid +1;
            }else{ //���򣬽��ұ߽�right����mid��
                right=mid;
            }
        }
        return left;
    }
}

/*
��ĿҪ��ĸ��Ӷ���O��log n��
*/