public class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for(int i =2; i<n; i++){
            if(notPrime[i] == false){
                count++;
				//it starts from 2, the first prime, then mark the multip of 2 as true in notPrime, 
				//so the loop of i will skip them. the next prime is 3, 
				//do the same thing. Then it is 4, which 2*2, so the not prime is true, and will skip to next.
                for(int j=2;i*j<n; j++){ 
                    notPrime[i*j] = true;
                }
            }
        }
        return count;
    }
}