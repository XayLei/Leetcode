public class Solution{
	public int trappingWater(int[] height){
		int left = 0, right = height.length-1;  //定义左右两个
		int maxLeft=0, maxRight=0;   //用于保存左右遇到的最高的墙
		int res = 0;  //返回值
		
		while(left <= right){ //两端在最高墙处相遇重合，停止循环
			if(height[left] <= height[right]){ //如果左边墙的高度低于或等于右边墙的高度，则先从左边开始处理
				if(height[left] >= maxLeft){  //如果左边遍历到的墙的高度高于最高墙，则更新最高墙
					maxLeft = height[left];
				}else{
					res += maxLeft - height[left];  //否则就更新返回值，说明最高左墙的右边可以储水
				}
				left++;
			}else{  //处理右边的过程与左边相同，遍历到的值大于maxright就更新maxright，小于就更新返回值
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