//快排思想
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        if(input!=null && k<input.length){
            int end = input.length-1,start=0;
            int index = partition(input,start,end);
            while(index!=k-1){
                if(index>k-1){
                    end = index-1;
                    index = partition(input,start,end);
                }else{
                    start = index+1;
                    index = partition(input,start,end);
                }
            }
            for(int i=0;i<k;i++){
                al.add(input[i]);
            }
        }
        return al;
    }
    
    public int partition(int[] input, int left, int right){
        int privotKey = input[left];
        int privotPointer = left;
        while(left<right){
            while(left<right && input[left]<=privotKey) left++;
            while(left<right && input[right]>=privotKey) right--;
            swap(input,left,right);
        }
        swap(input,privotPointer,left);
        return left;
    }
    
    public void swap(int[] a,int b, int c){
        int temp = a[b];
        a[b] = a[c];
        a[c] = temp;
    }
}

//冒泡排序思想
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		if (k > input.length) {
			return al;
		}
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < input.length - i - 1; j++) {
				if (input[j] < input[j + 1]) {
					int temp = input[j];
					input[j] = input[j + 1];
					input[j + 1] = temp;
				}
			}
			al.add(input[input.length - i - 1]);
		}
		return al;
    }
}