/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].
*/
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<=rowIndex; i++){ //������ж�����������ӵȺţ�������Ϊ0ʱ����
            result.add(0,1);
            for(int j = 1; j<result.size()-1; j++){
                result.set(j,result.get(j)+result.get(j+1));
            }
        }
        return result;
    }
}