//This problem belong to weekly contest 26

public class Solution{
   public int findLUSLength(String a , String b){
      if(a.equals(b)) return -1;     
      return Math.max(a.length(),b.length());
   }
}
