public class Solution {
    public String reverseWords(String s) {
        if(s == null) return null;
        
        String[] sa = s.split(" +");
        for(int i =0; i < sa.length; i++){
            char[] a = sa[i].toCharArray();
            int j = 0;
            int k = a.length-1;
            while(j<k){
                char temp = a[j];
                a[j] = a[k];
                a[k] = temp;
                j++;
                k--;
            }
            
            StringBuilder s2 = new StringBuilder();
            for(int m =0; m<a.length; m++)
                s2.append(a[m]);
            sa[i] = s2.toString();
        }
        
        StringBuilder sd = new StringBuilder();
        for(int i =0; i<sa.length; i++){
            sd.append(sa[i]);
            sd.append(" ");
        }
        
        return sd.toString().trim();
    }
}
