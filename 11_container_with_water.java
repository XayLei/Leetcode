public class Solution {
    public int maxArea(int[] height) {
        int maxArea=0;
		int left=0,right=height.length-1;
		if(right<=0) return 0;
		while(left<right){
			int area = areaCal(height, left, right);
			if(height[left]<height[right]){
				left++;
			}else{
				right--;
			}
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
    }
    
    private int areaCal(int[] height, int i, int j) {
		return Math.min(height[i],height[j])*Math.abs(j-i);
	}
  
    //another method
  	public int maxArea(int[] height) {
		int maxArea=0;
		int i=0,j=height.length-1;
		while(i<j){
			maxArea = Math.max(maxArea, Math.min(height[i],height[j])*Math.abs(j-i));
			if(height[i]<height[j])
				i++;
			else
				j--;		
		}
		return maxArea;
	  }
}
