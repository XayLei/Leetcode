import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
       ArrayList<Integer> re = new ArrayList<>();
       if(matrix==null || matrix.length<=0 || matrix[0].length<=0) return re;
       int rows = matrix.length, col = matrix[0].length;
       int start = 0; //��ʾȦ����Ҳ��ʾÿһȦ����ʼ����
       while(rows>start*2 && col>start*2){ //�������ڣ���Ȧ�����������һȦ����ʼ�����2��������ھ����������ֹͣ
           help(matrix,rows,col,start,re);
           ++start;
       }
       return re;
    }
    public void help(int[][] matrix, int rows, int col, int start, ArrayList<Integer> re){
        int endx = col-1-start; //ÿһȦ����
        int endy = rows-1-start;//ÿһȦ����
        
		//������
        for(int i = start; i <= endx; i++){
            re.add(matrix[start][i]);
        }
        //�����ϵ�����
        if(start<endy){
            for(int i = start + 1; i<=endy; i++){ //����ʱҪ�ų���һ������Ϊ���б���ʱ�Ѿ����ʹ�
                re.add(matrix[i][endx]);
            }
        }
        //�����µ����£������ݼ�
        if(start<endx && start<endy){
            for(int i=endx-1; i>=start; i--){
                re.add(matrix[endy][i]);
            }
        }
        //�����µ����ϣ������ݼ�
        if(start<endx && start<endy-1){
            for(int i = endy-1;i>start; i--){
                re.add(matrix[i][start]);
            }
        }
    }
}