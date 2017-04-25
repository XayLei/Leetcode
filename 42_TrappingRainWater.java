public class Solution{
	public int trappingWater(int[] height){
		int left = 0, right = height.length-1;  //������������
		int maxLeft=0, maxRight=0;   //���ڱ���������������ߵ�ǽ
		int res = 0;  //����ֵ
		
		while(left <= right){ //���������ǽ�������غϣ�ֹͣѭ��
			if(height[left] <= height[right]){ //������ǽ�ĸ߶ȵ��ڻ�����ұ�ǽ�ĸ߶ȣ����ȴ���߿�ʼ����
				if(height[left] >= maxLeft){  //�����߱�������ǽ�ĸ߶ȸ������ǽ����������ǽ
					maxLeft = height[left];
				}else{
					res += maxLeft - height[left];  //����͸��·���ֵ��˵�������ǽ���ұ߿��Դ�ˮ
				}
				left++;
			}else{  //�����ұߵĹ����������ͬ����������ֵ����maxright�͸���maxright��С�ھ͸��·���ֵ
				if(height[right] >= maxRight){
					maxRight = height[right];
				}else{
					res += maxRight - height[right];
				}
				right--;
			}
		}
		return res;
	}
}