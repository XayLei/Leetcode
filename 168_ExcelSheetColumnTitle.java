public class Solution {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));//0���൱��һֱ����һλ���룬��B > AB > AAB....
            n /= 26;
        }

        return result.toString();
    }
}

public class Solution {
    public String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
    }
}