/**题目描述：
小易有一个长度为n序列，小易想移除掉里面的重复元素，但是小易想是对于每种元素保留最后出现的那个。小易遇到了困难,希望你来帮助他
输入描述：
输入包括两行：
第一行为序列长度n(1 ≤ n ≤ 50)
第二行为n个数sequence[i](1 ≤ sequence[i] ≤ 1000)，以空格分隔
输出描述：
输出消除重复元素之后的序列，以空格分隔，行末无空格
*/
import java.util.*;
import java.util.Map.Entry;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i]=sc.nextInt();
		}
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < n; i++) {
			hm.put(array[i], i);
		}
		
    //注意这里，创建迭代器，从hashmap中得到键值对对象
    Iterator iterator = hm.entrySet().iterator();
		int[] result = new int[n];
		while(iterator.hasNext()){
			//使用entry操作键值对，从中获取键对象和值对象
      Entry entry = (Entry)iterator.next();
			int key = (int)entry.getKey();
			int value = (int)entry.getValue();
			result[value]=key;
 		}
		
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if(result[i] != 0){
				al.add(result[i]);
			}
		}
		
		for (int i = 0; i < al.size(); i++) {
			if(i != al.size()-1){
				System.out.print(al.get(i) + " ");
			}else{
				System.out.print(al.get(i));
			}
		}
	}
}
