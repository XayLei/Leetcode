import java.util.BitSet;
import java.util.Scanner;

public class Main {

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int[][] ranks = new int[N][5];
    for (int i=0;i<N;i++)
        for (int j=0;j<5;j++)
            ranks[i][j] = scanner.nextInt();
    int[] result = getRanksOfTotalClasses(ranks);
    for (int i=0;i<N;i++){
        System.out.println(result[i]);
    }
}

//TLE,时间超限，只通过了40%的数据
private static int[] getRanksOfTotalClasses(int[][] originRanks) {
    int N = originRanks.length;
    int[] result = new int[N];

    for (int i=0;i<N;i++){
		//保存最终的交集，即在所有科目上排名都超过学生i，那么对应的位为true
        BitSet bitSet = new BitSet(N);
        bitSet.set(0,N); //将指定的0（包括）到指定的N（不包括)范围内的位设置为 true
        for (int j=0;j<5;j++){ //
            //创建一个位 set，它的初始大小足以显式表示索引范围在 0 到 N-1 的位，所有位初始值为false
			//为每一行的每一列创建一个大小为N的集合（即一个大小为N的BitSet）
			//这个BitSit中每一位表示的是除J行以外的其他行的这一列的元素是否小于第J行这一列的元素
			//如果小于，那么相对应的这一行在newBitSet中的相应位就设为TRUE
            BitSet newBitSet = new BitSet(N); //这个里面显示的是在j科目中比学生I排名靠前的学生K,相应的k位为true
            for (int k=0;k<N;k++){ //遍历矩阵的每一行
                if (originRanks[k][j]<originRanks[i][j]){
                    newBitSet.set(k); //将指定索引处的位设置为true
                }
            }
            bitSet.and(newBitSet);//对所有位进行逻辑与操作
        }
		//bitSet.cardinality()返回bitSet中TRUE的个数
        result[i] = bitSet.cardinality()-1;
    }
    return result;
}
}