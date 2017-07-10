/*
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        for(int i = 0; i < numRows; i++){ //循环中操作的始终只有row这一个数组
            row.add(0,1);
            for(int j=1; j<row.size()-1; j++){  //用于处理中间的数字,当n小于3时，这个内循环是不用进入的
                row.set(j,row.get(j)+row.get(j+1));
            }
            result.add(new ArrayList<>(row)); //原来的row还存在，这里相当于添加的是一个每轮结果的复制的数组
        }
        return result;
    }
}