public class Solution{
    public boolean isValidSudoku(Char[][] board){
        //数独比较的是1到9共8个数字是否重复
        for(int i =0; i<9; i++){
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> cube = new HahSet<>();
            for(int j=0; j<9; j++){
                //遍历每一行
                if(board[i][j]!='.' && !row.add(board[i][j])){
                    return false;
                }
                //将i与j调换，就是遍历每一列
                if(board[j][i]!='.' && !col.add(board[j][i])){
                    return false;
                }
                
                int rowIn = 3*(i/3);
                int colIn = 3*(i%3);
                if(board[rowIn+j/3][colIn+j%3] != '.' && !cube.add(board[rowIn+j/3][colIn+j%3])){
                    return false;
                }
            }
        }
        return true;
    }
}
