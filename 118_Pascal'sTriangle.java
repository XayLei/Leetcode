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
        for(int i = 0; i < numRows; i++){ //ѭ���в�����ʼ��ֻ��row��һ������
            row.add(0,1);
            for(int j=1; j<row.size()-1; j++){  //���ڴ����м������,��nС��3ʱ�������ѭ���ǲ��ý����
                row.set(j,row.get(j)+row.get(j+1));
            }
            result.add(new ArrayList<>(row)); //ԭ����row�����ڣ������൱����ӵ���һ��ÿ�ֽ���ĸ��Ƶ�����
        }
        return result;
    }
}