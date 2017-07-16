import java.util.ArrayList;
import java.util.Collections;
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> re = new ArrayList<>();
        if(str != null && str.length()>0){
            help(str.toCharArray(),0,re);
            Collections.sort(re);
        }
        return re;
    }
    
    public void help(char[] ch, int i, ArrayList<String> re){
        if(i==ch.length-1){
            re.add(String.valueOf(ch));
        }else{
            for(int j=i; j<ch.length; j++){
                if(j == i || ch[j] != ch[i]){
                    swap(ch,i,j);
                    help(ch,i+1,re);
                    swap(ch,i,j);
                }
            }
        }
    }
    
    public void swap(char[] ch, int i, int j){
        Character temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}